package com.questionnaire;

public class NumericVisitorImpl extends NumericBaseVisitor<Double> {

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
