package com.lvdapiaoliang.infracore.event;

import org.springframework.context.ApplicationListener;

/**
 * @author: lvguopeng
 * @description: 事件处理器接口
 */
public interface DomainEventHandler<T extends DomainEvent> extends ApplicationListener<T> {

}
