package com.questionnaire;

public class NumericVisitorImpl extends NumericBaseVisitor<Double> {

    @Override
    public Double visitNumber(NumericParser.NumberContext ctx) {
        return Double.parseDouble(ctx.numberLiteral().getText());
    }

    @Override
    public Double visitNumericBraces(NumericParser.NumericBracesContext ctx) {
        return visit(ctx.numeric());
    }

    @Override
    public Double visitDiv(NumericParser.DivContext ctx) {
        return visit(ctx.numeric(0)) / visit(ctx.numeric(1));
    }

    @Override
    public Double visitMinus(NumericParser.MinusContext ctx) {
        return visit(ctx.numeric(0)) - visit(ctx.numeric(1));
    }

    @Override
    public Double visitMult(NumericParser.MultContext ctx) {
        return visit(ctx.numeric(0)) * visit(ctx.numeric(1));
    }

    @Override
    public Double visitPlus(NumericParser.PlusContext ctx) {
        return visit(ctx.numeric(0)) + visit(ctx.numeric(1));
    }
}
