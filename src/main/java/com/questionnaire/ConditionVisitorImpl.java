package com.questionnaire;

public class ConditionVisitorImpl extends ConditionBaseVisitor<Boolean> {

    @Override
    public Boolean visitBool(ConditionParser.BoolContext ctx) {
        return Boolean.parseBoolean(ctx.BOOL().getText());
    }

    @Override
    public Boolean visitAndExpression(ConditionParser.AndExpressionContext ctx) {
        return visit(ctx.expr(0)) && visit(ctx.expr(1));
    }

    @Override
    public Boolean visitOrExpression(ConditionParser.OrExpressionContext ctx) {
        return visit(ctx.expr(0)) || visit(ctx.expr(1));
    }

    @Override
    public Boolean visitBraces(ConditionParser.BracesContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Boolean visitLowerEquity(ConditionParser.LowerEquityContext ctx) {
        String lowerCaseArgument = getStringFromLiteral(ctx.lowerFunction().stringLiteral()).toLowerCase();
        return  getStringFromLiteral(ctx.stringLiteral()).equals(lowerCaseArgument);
    }

    @Override
    public Boolean visitUpperEquity(ConditionParser.UpperEquityContext ctx) {
        String upperCaseArgument = getStringFromLiteral(ctx.upperFunction().stringLiteral()).toUpperCase();
        return getStringFromLiteral(ctx.stringLiteral()).equals(upperCaseArgument);
    }

    @Override
    public Boolean visitContainsFunction(ConditionParser.ContainsFunctionContext ctx) {
        String literal = getStringFromLiteral(ctx.stringLiteral(0));
        String argument = getStringFromLiteral(ctx.stringLiteral(1));
        return literal.contains(argument);
    }

    private String getStringFromLiteral(ConditionParser.StringLiteralContext ctx) {
        String stringLiteral = ctx.getText();
        return stringLiteral.substring(1, stringLiteral.length() - 1);
    }
}
