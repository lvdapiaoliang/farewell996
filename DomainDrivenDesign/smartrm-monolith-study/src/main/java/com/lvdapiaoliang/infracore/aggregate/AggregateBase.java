package com.lvdapiaoliang.infracore.aggregate;

import com.lvdapiaoliang.infracore.api.CommonError;
import com.lvdapiaoliang.infracore.event.DomainEvent;
import com.lvdapiaoliang.infracore.event.DomainEventBus;
import com.lvdapiaoliang.infracore.exception.DomainException;

/**
 * @author: lvguopeng
 * @description:
 */
public abstract class AggregateBase {

  protected long version;

  private boolean versionInc = false;

  protected DomainEventBus eventBus;

  protected void incVersion() {
    version++;
    versionInc = true;
  }

  public long getVersion() {
    return version;
  }

  public boolean isVersionInc() {
    return versionInc;
  }

  protected void setEventBus(DomainEventBus eventBus) {
    this.eventBus = eventBus;
  }

  protected void emitEvent(DomainEvent event) {
    if (eventBus != null) {
      eventBus.post(event);
    } else {
      throw new DomainException(CommonError.NoEventBus);
    }
  }


}
