package com.liukx.fastjson;


import com.liukx.fastjson.parser.DefaultJSONParser;
import com.liukx.fastjson.parser.ParserConfig;
import com.liukx.fastjson.serializer.SerializeFilter;

import java.util.Locale;
import java.util.TimeZone;

/**
 * json的抽象类,为子类实现了此接口
 * Created by liukx on 2018-11-06.
 */
public abstract class JSON implements JSONStreamAware,JSONAware {

    public static TimeZone defaultTimeZone = TimeZone.getDefault();
    public static Locale defaultLocale = Locale.getDefault();
    public static String DEFAULT_TYPE_KEY = "@type"; //todo 有什么用
    static final SerializeFilter[] emptyFilters = new SerializeFilter[0]; //todo 为什么不使用public
    public static String DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"; //默认的时间格式,可以用这个
    public static int DEFAULT_PARSER_FEATURE; //todo 默认解析器特性,这两个是啥
    public static int DEFAULT_GENERATE_FEATURE;//默认生成器特性
    private static final ThreadLocal<byte[]> bytesLocal; //todo ThreadLocal在这里的作用
    private static final ThreadLocal<char[]> charsLocal;
    public static final String VERSION = "1.2.28"; //fastjson版本号

    public JSON() {
    }

    public static void setDefaultTypeKey(String typeKey){
        DEFAULT_TYPE_KEY = typeKey; //DEFAULT_TYPE_KEY不是final的
        //todo addSymbol的这个方法,为什么length,hashcode不放到方法内部呢
        ParserConfig.global.symbolTable.addSymbol(typeKey,0,typeKey.length(),typeKey.hashCode());
    }

    public static Object parse(String text){
        return parse(text,DEFAULT_PARSER_FEATURE);
    }

    public static Object parse(String text, int features) {
        if(text == null){
            return null;
        }else {
            DefaultJSONParser parser = new DefaultJSONParser(text,ParserConfig.getGlobalInstance(),features);
            Object value = parser.parse();

        }
    }


}
