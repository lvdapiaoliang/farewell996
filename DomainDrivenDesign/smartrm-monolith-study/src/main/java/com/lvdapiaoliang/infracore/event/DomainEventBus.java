package com.lvdapiaoliang.infracore.event;

/**
 * @author: lvguopeng
 * @description:事件总线
 */
public interface DomainEventBus {

  void post(DomainEvent event);

  void register(DomainEventHandler handler);

}
