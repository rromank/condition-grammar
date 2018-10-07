package com.questionnaire.visitor;

import com.questionnaire.ConditionBaseVisitor;
import com.questionnaire.ConditionParser;
import com.questionnaire.ExpressionParser;
import com.questionnaire.Questionnaire;
import org.antlr.v4.runtime.tree.ParseTree;

public class ConditionVisitorImpl extends ConditionBaseVisitor<Boolean> {

    private VisitorContext visitorContext;

    public ConditionVisitorImpl(VisitorContext visitorContext) {
        this.visitorContext = visitorContext;
    }

    public Boolean visit(ParseTree tree) {
        return super.visit(tree);
    }

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
        Boolean left = visit(ctx.condition(0));
        if (visitorContext.isConstantsDisabled()) {
            left = false;
            visitorContext.setConstantsDisabled(false);
        }

        Boolean right = visit(ctx.condition(1));
        if (visitorContext.isConstantsDisabled()) {
            right = false;
            visitorContext.setConstantsDisabled(false);
        }

        return left || right;
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
        String left = visitorContext.getExpressionParser().parseString(ctx.string(0).getText());
        String right = visitorContext.getExpressionParser().parseString(ctx.string(1).getText());
        return left.equals(right);
    }

    @Override
    public Boolean visitStringNeq(ConditionParser.StringNeqContext ctx) {
        String left = visitorContext.getExpressionParser().parseString(ctx.string(0).getText());
        String right = visitorContext.getExpressionParser().parseString(ctx.string(1).getText());
        return !left.equals(right);
    }

    @Override
    public Boolean visitLowerFunction(ConditionParser.LowerFunctionContext ctx) {
        return super.visitLowerFunction(ctx);
    }

    @Override
    public Boolean visitContainsFunction(ConditionParser.ContainsFunctionContext ctx) {
        String literal = visitorContext.getExpressionParser().parseString(ctx.stringLiteral().getText());
        String argument = visitorContext.getExpressionParser().parseString(ctx.string().getText());
        return literal.contains(argument);
    }

    @Override
    public Boolean visitNumericEq(ConditionParser.NumericEqContext ctx) {
        Double left = visitorContext.getExpressionParser().parseNumeric(ctx.numeric(0).getText());
        Double right = visitorContext.getExpressionParser().parseNumeric(ctx.numeric(1).getText());
        return left.equals(right);
    }

    @Override
    public Boolean visitNumericNeq(ConditionParser.NumericNeqContext ctx) {
        Double left = visitorContext.getExpressionParser().parseNumeric(ctx.numeric(0).getText());
        Double right = visitorContext.getExpressionParser().parseNumeric(ctx.numeric(1).getText());
        return !left.equals(right);
    }

    @Override
    public Boolean visitNumericLt(ConditionParser.NumericLtContext ctx) {
        Double left = visitorContext.getExpressionParser().parseNumeric(ctx.numeric(0).getText());
        Double right = visitorContext.getExpressionParser().parseNumeric(ctx.numeric(1).getText());
        return left < right;
    }

    @Override
    public Boolean visitNumericGt(ConditionParser.NumericGtContext ctx) {
        Double left = visitorContext.getExpressionParser().parseNumeric(ctx.numeric(0).getText());
        Double right = visitorContext.getExpressionParser().parseNumeric(ctx.numeric(1).getText());
        return left > right;
    }

    @Override
    public Boolean visitNumericLe(ConditionParser.NumericLeContext ctx) {
        Double left = visitorContext.getExpressionParser().parseNumeric(ctx.numeric(0).getText());
        Double right = visitorContext.getExpressionParser().parseNumeric(ctx.numeric(1).getText());
        return left <= right;
    }

    @Override
    public Boolean visitNumericGe(ConditionParser.NumericGeContext ctx) {
        Double left = visitorContext.getExpressionParser().parseNumeric(ctx.numeric(0).getText());
        Double right = visitorContext.getExpressionParser().parseNumeric(ctx.numeric(1).getText());
        return left >= right;
    }
}
