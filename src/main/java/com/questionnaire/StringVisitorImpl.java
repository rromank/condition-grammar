package com.questionnaire;

public class StringVisitorImpl extends StringBaseVisitor<String> {

    @Override
    public String visitLowerFunction(StringParser.LowerFunctionContext ctx) {
        return getStringFromLiteral(ctx.stringLiteral()).toLowerCase();
    }

    @Override
    public String visitUpperFunction(StringParser.UpperFunctionContext ctx) {
        return getStringFromLiteral(ctx.stringLiteral()).toUpperCase();
    }

    @Override
    public String visitStringLiteral(StringParser.StringLiteralContext ctx) {
        return getStringFromLiteral(ctx);
    }

    private String getStringFromLiteral(StringParser.StringLiteralContext ctx) {
        String stringLiteral = ctx.getText();
        return stringLiteral.substring(1, stringLiteral.length() - 1);
    }
}
