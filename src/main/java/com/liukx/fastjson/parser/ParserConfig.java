package com.liukx.fastjson.parser;

/**
 * json解析config
 * Created by liukx on 2018-11-08.
 */
public class ParserConfig {

    //待完善

    public static ParserConfig global; //todo 自己持有自己的静态变量,为什么这么写呢
    public final SymbolTable symbolTable;

    //todo 为什么不直接取,而要写一个静态方法来获取呢
    public static ParserConfig getGlobalInstance(){
        return global;
    }


}
