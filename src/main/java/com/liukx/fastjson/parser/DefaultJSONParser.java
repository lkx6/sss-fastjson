package com.liukx.fastjson.parser;

import com.liukx.fastjson.JSONException;

/**
 * Created by liukx on 2018-11-08.
 */
public class DefaultJSONParser {

    public final JSONLexer lexer;

    public DefaultJSONParser() {
    }

    public DefaultJSONParser(String input, ParserConfig config, int features) {
    }

    public Object parse() {
        return this.parse((Object)null);
    }

    public Object parse(Object fieldName) {
        JSONLexer lexer = this.lexer;
        switch (lexer.token()){
            case 1:
            case 5:
            case 10:
            case 11:
            case 13:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            default:
                throw new JSONException("syntax error, " + lexer.info());
            case 2:
                Number intValue = lexer.integerValue();
                lexer.nextToken();
                return intValue;
            case 3:
                Object value = lexer.decimalValue(lexer.isEnabled(Feature.));

        }

    }
}
