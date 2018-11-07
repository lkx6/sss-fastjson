package com.liukx.fastjson;

import java.util.TimeZone;

/**
 * json的抽象类,为子类实现了此接口
 * Created by liukx on 2018-11-06.
 */
public abstract class JSON implements JSONStreamAware,JSONAware {

    public static TimeZone defaultTimeZone = TimeZone.getDefault();


}
