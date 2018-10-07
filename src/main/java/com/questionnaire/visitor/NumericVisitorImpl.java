package com.questionnaire.visitor;

import com.questionnaire.NumericBaseVisitor;
import com.questionnaire.NumericParser;
import com.questionnaire.Questionnaire;
import org.antlr.v4.runtime.tree.ParseTree;

public class NumericVisitorImpl extends NumericBaseVisitor<Double> {

    private VisitorContext visitorContext;

    public NumericVisitorImpl(VisitorContext visitorContext) {
        this.visitorContext = visitorContext;
    }

    public Double visit(ParseTree tree) {
        return super.visit(tree);
    }

    @Override
    public Double visitNumber(NumericParser.NumberContext ctx) {
        return Double.parseDouble(ctx.INT().getText());
    }

    @Override
    public Double visitNumericBraces(NumericParser.NumericBracesContext ctx) {
        return visit(ctx.numeric());
    }

    @Override
    public Double visitNumericDiv(NumericParser.NumericDivContext ctx) {
        return visit(ctx.numeric(0)) / visit(ctx.numeric(1));
    }

    @Override
    public Double visitNumericMinus(NumericParser.NumericMinusContext ctx) {
        return visit(ctx.numeric(0)) - visit(ctx.numeric(1));
    }

    @Override
    public Double visitNumericMult(NumericParser.NumericMultContext ctx) {
        return visit(ctx.numeric(0)) * visit(ctx.numeric(1));
    }

    @Override
    public Double visitNumericPlus(NumericParser.NumericPlusContext ctx) {
        return visit(ctx.numeric(0)) + visit(ctx.numeric(1));
    }
}
