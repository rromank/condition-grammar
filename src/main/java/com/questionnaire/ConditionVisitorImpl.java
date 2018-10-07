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
    public Boolean visitEqExpression(ConditionParser.EqExpressionContext ctx) {
        return visit(ctx.expr(0)).equals(visit(ctx.expr(1)));
    }

    @Override
    public Boolean visitNeqExpression(ConditionParser.NeqExpressionContext ctx) {
        return !visit(ctx.expr(0)).equals(visit(ctx.expr(1)));
    }

    @Override
    public Boolean visitBraces(ConditionParser.BracesContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Boolean visitStringEqExpression(ConditionParser.StringEqExpressionContext ctx) {
        String left = MyConditionParser.parseString(ctx.string(0).getText());
        String right = MyConditionParser.parseString(ctx.string(1).getText());
        return left.equals(right);
    }

    @Override
    public Boolean visitStringNeqExpression(ConditionParser.StringNeqExpressionContext ctx) {
        String left = MyConditionParser.parseString(ctx.string(0).getText());
        String right = MyConditionParser.parseString(ctx.string(1).getText());
        return !left.equals(right);
    }

    @Override
    public Boolean visitLowerFunction(ConditionParser.LowerFunctionContext ctx) {
        return super.visitLowerFunction(ctx);
    }

    @Override
    public Boolean visitContainsFunction(ConditionParser.ContainsFunctionContext ctx) {
        String literal = MyConditionParser.parseString(ctx.stringLiteral(0).getText());
        String argument = MyConditionParser.parseString(ctx.stringLiteral(1).getText());
        return literal.contains(argument);
    }
}
