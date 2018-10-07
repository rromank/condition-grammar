package com.questionnaire;

public class ConditionVisitorImpl extends ConditionBaseVisitor<Boolean> {

    @Override
    public Boolean visitBool(ConditionParser.BoolContext ctx) {
        return Boolean.parseBoolean(ctx.BOOL().getText());
    }

    @Override
    public Boolean visitBoolAnd(ConditionParser.BoolAndContext ctx) {
        return visit(ctx.condition(0)) && visit(ctx.condition(1));
    }

    @Override
    public Boolean visitBoolOr(ConditionParser.BoolOrContext ctx) {
        return visit(ctx.condition(0)) || visit(ctx.condition(1));
    }

    @Override
    public Boolean visitBoolEq(ConditionParser.BoolEqContext ctx) {
        return visit(ctx.condition(0)).equals(visit(ctx.condition(1)));
    }

    @Override
    public Boolean visitBoolNeq(ConditionParser.BoolNeqContext ctx) {
        return !visit(ctx.condition(0)).equals(visit(ctx.condition(1)));
    }

    @Override
    public Boolean visitBoolBraces(ConditionParser.BoolBracesContext ctx) {
        return visit(ctx.condition());
    }

    @Override
    public Boolean visitStringEq(ConditionParser.StringEqContext ctx) {
        String left = ExpressionParser.parseString(ctx.string(0).getText());
        String right = ExpressionParser.parseString(ctx.string(1).getText());
        return left.equals(right);
    }

    @Override
    public Boolean visitStringNeq(ConditionParser.StringNeqContext ctx) {
        String left = ExpressionParser.parseString(ctx.string(0).getText());
        String right = ExpressionParser.parseString(ctx.string(1).getText());
        return !left.equals(right);
    }

    @Override
    public Boolean visitLowerFunction(ConditionParser.LowerFunctionContext ctx) {
        return super.visitLowerFunction(ctx);
    }

    @Override
    public Boolean visitContainsFunction(ConditionParser.ContainsFunctionContext ctx) {
        String literal = ExpressionParser.parseString(ctx.stringLiteral().getText());
        String argument = ExpressionParser.parseString(ctx.string().getText());
        return literal.contains(argument);
    }

    @Override
    public Boolean visitNumericEq(ConditionParser.NumericEqContext ctx) {
        Double left = ExpressionParser.parseNumeric(ctx.numeric(0).getText());
        Double right = ExpressionParser.parseNumeric(ctx.numeric(1).getText());
        return left.equals(right);
    }

    @Override
    public Boolean visitNumericNeq(ConditionParser.NumericNeqContext ctx) {
        Double left = ExpressionParser.parseNumeric(ctx.numeric(0).getText());
        Double right = ExpressionParser.parseNumeric(ctx.numeric(1).getText());
        return !left.equals(right);
    }

    @Override
    public Boolean visitNumericLt(ConditionParser.NumericLtContext ctx) {
        Double left = ExpressionParser.parseNumeric(ctx.numeric(0).getText());
        Double right = ExpressionParser.parseNumeric(ctx.numeric(1).getText());
        return left < right;
    }

    @Override
    public Boolean visitNumericGt(ConditionParser.NumericGtContext ctx) {
        Double left = ExpressionParser.parseNumeric(ctx.numeric(0).getText());
        Double right = ExpressionParser.parseNumeric(ctx.numeric(1).getText());
        return left > right;
    }

    @Override
    public Boolean visitNumericLe(ConditionParser.NumericLeContext ctx) {
        Double left = ExpressionParser.parseNumeric(ctx.numeric(0).getText());
        Double right = ExpressionParser.parseNumeric(ctx.numeric(1).getText());
        return left <= right;
    }

    @Override
    public Boolean visitNumericGe(ConditionParser.NumericGeContext ctx) {
        Double left = ExpressionParser.parseNumeric(ctx.numeric(0).getText());
        Double right = ExpressionParser.parseNumeric(ctx.numeric(1).getText());
        return left >= right;
    }
}
