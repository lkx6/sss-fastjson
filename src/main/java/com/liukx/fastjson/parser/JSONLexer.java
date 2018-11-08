package com.liukx.fastjson.parser;

/**
 * Created by liukx on 2018-11-08.
 */
public interface JSONLexer {
    int token();

    String info();

    Number integerValue();

    void nextToken();

    Object decimalValue();
}
