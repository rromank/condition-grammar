package com.questionnaire.visitor;

import com.questionnaire.StringBaseVisitor;
import com.questionnaire.StringParser;
import org.antlr.v4.runtime.tree.ParseTree;

public class StringVisitorImpl extends StringBaseVisitor<String> {

    private VisitorContext visitorContext;

    public StringVisitorImpl(VisitorContext visitorContext) {
        this.visitorContext = visitorContext;
    }

    public String visit(ParseTree tree) {
        return super.visit(tree);
    }

    @Override
    public String visitLowerFunction(StringParser.LowerFunctionContext ctx) {
        return getStringFromLiteral(ctx.string().stringLiteral()).toLowerCase();
    }

    @Override
    public String visitUpperFunction(StringParser.UpperFunctionContext ctx) {
        return getStringFromLiteral(ctx.string().stringLiteral()).toUpperCase();
    }

    @Override
    public String visitStringLiteral(StringParser.StringLiteralContext ctx) {
        return getStringFromLiteral(ctx);
    }

    private String getStringFromLiteral(StringParser.StringLiteralContext ctx) {
        String stringLiteral = ctx.getText();
        return stringLiteral.substring(1, stringLiteral.length() - 1);
    }

    @Override
    public String visitStringConstant(StringParser.StringConstantContext ctx) {
        if (visitorContext.getDisabledProperties().contains(ctx.getText())) {
            visitorContext.setConstantsDisabled(true);
        }
        return visitorContext.getQuestionnaire().getStringProperty(ctx.getText());
    }
}
