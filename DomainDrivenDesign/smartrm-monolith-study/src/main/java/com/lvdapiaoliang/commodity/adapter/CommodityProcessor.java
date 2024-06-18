package com.lvdapiaoliang.commodity.adapter;

import com.lvdapiaoliang.commodity.domain.model.Commodity;
import java.io.IOException;

/**
 * @author: lvguopeng
 * @description:
 */
public interface CommodityProcessor {

  public void onCommodity(Commodity commodity) throws IOException;

}
