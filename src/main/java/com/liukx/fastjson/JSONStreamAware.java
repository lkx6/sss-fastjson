package com.liukx.fastjson;

import java.io.IOException;

/**
 * Appendable:从jdk1.5开始的一个接口,应该是用于append字符串
 * Created by liukx on 2018-11-06.
 */
public interface JSONStreamAware {

    void writeJSONString(Appendable appendable) throws IOException;

}
