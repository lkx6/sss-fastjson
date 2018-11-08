package com.liukx.fastjson.parser;

/**
 * fastjson性能很关键的一个类,符号表
 * Created by liukx on 2018-11-08.
 */
public class SymbolTable {

    private final String[] symbols; //这是一个以字符串的hashCode为下标数组,还用了字符串常量池
    private final int indexMask;

    /**
     * @description 这是一个比较底层的字符串方法
     * @author liukx
     * @date 2018-11-08
     */
    public String addSymbol(char[] buffer,int offset,int len,int hash){
        int bucket = hash & this.indexMask; //位与运算符
        String symbol = this.symbols[bucket]; //通过这种方式取
        if(symbol == null){
            symbol = (new String(buffer,offset,len)).intern(); //字符串常量池,这是很有用,这是一个native方法
            this.symbols[bucket] = symbol;
            return symbol;
        }else {
            boolean eq = true;
            if(hash == symbol.hashCode() && len == symbol.length()){
                for (int i=0;i<len;++i){
                    if(buffer[offset +i ] != symbol.charAt(i)){ //todo string.charAt(int index)
                        eq = false;
                        break;
                    }
                }
            }else {
                eq = false;
            }
            return eq ? symbol : new String(buffer,offset,len);
        }
    }

    public String addSymbol(String buffer,int offset,int len,int hash){
        int bucket = hash & this.indexMask;
        String symbol = this.symbols[bucket];
        if(symbol != null){
            //字符串比较相等的一个方法
            return (hash == symbol.hashCode() && len == symbol.length() && buffer.startsWith(symbol,offset))
                    ? symbol : subString(buffer,offset,len);
        }else {
            symbol = len == buffer.length() ? buffer : subString(buffer,offset,len);
            symbol = symbol.intern();
            this.symbols[bucket] = symbol;
            return symbol;
        }
    }

    private String subString(String src, int offset, int len) {
        char[] chars = new char[len];
        src.getChars(offset,offset + len,chars,0);
        return new String(chars);
    }


}
