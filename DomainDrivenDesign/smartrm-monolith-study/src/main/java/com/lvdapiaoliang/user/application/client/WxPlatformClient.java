package com.lvdapiaoliang.user.application.client;

import com.lvdapiaoliang.user.application.dto.WxCode2SessionResultDto;

/**
 * @author: lvguopeng
 * @description:
 */
public interface WxPlatformClient {

  WxCode2SessionResultDto code2Session(String code);

}
