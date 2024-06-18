package com.lvdapiaoliang.flow;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author lvdapiaoliang
 * @Description
 * @create 2023-11-17 20:59
 */
public class FlowDemo {

  /**
   * 1、Publisher：发布者
   * 2、Subscriber：订阅者
   * 3、Subscription： 订阅关系
   * 4、Processor： 处理器
   *
   * @param args
   */

  //发布订阅模型：观察者模式，
  public static void main(String[] args) throws InterruptedException {

    //1、定义一个发布者； 发布数据；
    SubmissionPublisher<String> publisher = new SubmissionPublisher<>();


    //2、定一个中间操作：  给每个元素加个 哈哈 前缀
    MyProcessor myProcessor1 = new MyProcessor();
    MyProcessor myProcessor2 = new MyProcessor();
    MyProcessor myProcessor3 = new MyProcessor();


    //3、定义一个订阅者； 订阅者感兴趣发布者的数据；
    Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>() {

      private Flow.Subscription subscription;

      @Override //在订阅时  onXxxx：在xxx事件发生时，执行这个回调
      public void onSubscribe(Flow.Subscription subscription) {
        System.out.println(Thread.currentThread() + "订阅开始了：" + subscription);
        this.subscription = subscription;
        //从上游请求一个数据
        subscription.request(1);
      }

      @Override //在下一个元素到达时； 执行这个回调；   接受到新数据
      public void onNext(String item) {
        System.out.println(Thread.currentThread() + "订阅者，接受到数据：" + item);

        if (item.equals("p-7")) {
//          subscription.cancel(); //取消订阅
          subscription.request(1);
        } else {
          subscription.request(1);
        }
      }

      @Override //在错误发生时，
      public void onError(Throwable throwable) {
        System.out.println(Thread.currentThread() + "订阅者，接受到错误信号：" + throwable);
      }

      @Override //在完成时
      public void onComplete() {
        System.out.println(Thread.currentThread() + "订阅者，接受到完成信号：");
      }
    };

    //4、绑定发布者和订阅者  链表关系绑定出责任链。
    //发布者绑定处理器1，此时处理器相当于订阅者。
    publisher.subscribe(myProcessor1);
    //处理器1绑定处理器2，此时处理器1相当于发布者，处理器2相当于订阅者。
    myProcessor1.subscribe(myProcessor2);
    //处理器2绑定处理器3，此时处理器2相当于发布者，处理器3相当于订阅者。
    myProcessor2.subscribe(myProcessor3);
    //处理器3绑定订阅者，此时处理器3相当于发布者。
    myProcessor3.subscribe(subscriber);
    //绑定操作；就是发布者，记住了所有订阅者都有谁，有数据后，给所有订阅者把数据推送过去。


//    publisher.subscribe(subscriber);

    for (int i = 0; i < 10; i++) {
      //发布10条数据
//      publisher.submit("p-" + i);
      if (i == 5) {
//        publisher.closeExceptionally(new RuntimeException("5555"));
      } else {
        publisher.submit("p-" + i);
      }
      //publisher发布的所有数据在它的buffer区；
      //中断
      //            publisher.closeExceptionally();
    }


    //ReactiveStream
    //jvm底层对于整个发布订阅关系做好了 异步+缓存区处理 = 响应式系统；

    //发布者通道关闭
    publisher.close();

    //        publisher.subscribe(subscriber2);


    //发布者有数据，订阅者就会拿到


    Thread.sleep(20000);

  }

  //定义流中间操作处理器； 只用写订阅者的接口
  static class MyProcessor extends SubmissionPublisher<String>
      implements Flow.Processor<String, String> {

    private Flow.Subscription subscription; //保存绑定关系

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
      // 这是在Subscriber服务器订阅Publisher以接收消息时调用的第一种方法。 通常，我们调用subscription.request开始从处理器接收具体数量的数据流。
      System.out.println("processor订阅绑定完成");
      this.subscription = subscription;
      subscription.request(1); //找上游要一个数据
    }

    @Override //数据到达，触发这个回调
    public void onNext(String item) {
      // 从Publisher处收到数据时，将调用此方法，这是我们在其中实现业务逻辑以处理data stream，然后从Publisher处请求更多数据的地方。
      System.out.println("processor拿到数据：" + item);
      //再加工
      item += "：哈哈";
      submit(item);//把我加工后的数据发出去
      subscription.request(1); //再要新数据
    }

    @Override
    public void onError(Throwable throwable) {
      // 当发生不可恢复的错误时，将调用此方法，我们可以使用此方法清理任务，例如关闭数据库连接。

    }

    @Override
    public void onComplete() {
      // 这类似于finally方法，并且在Publisher没有push任何其他data stream并且关闭Publisher时被调用。 我们可以使用它发送成功处理流的通知。

    }
  }
}
