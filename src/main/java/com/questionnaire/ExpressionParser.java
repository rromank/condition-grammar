package com.questionnaire;

import com.questionnaire.visitor.ConditionVisitorImpl;
import com.questionnaire.visitor.NumericVisitorImpl;
import com.questionnaire.visitor.StringVisitorImpl;
import com.questionnaire.visitor.VisitorContext;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class ExpressionParser {

    private VisitorContext visitorContext = new VisitorContext();

    public ExpressionParser(Questionnaire questionnaire, List<String> disabledProperties) {
        visitorContext.setQuestionnaire(questionnaire);
        visitorContext.setDisabledProperties(disabledProperties);
        visitorContext.setExpressionParser(this);
    }

    public boolean parseBoolean(String expression) {
        ConditionLexer lexer = new ConditionLexer(CharStreams.fromString(expression));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ConditionParser parser = new ConditionParser(tokens);
        ParseTree tree = parser.condition();

        ConditionVisitorImpl visitor = new ConditionVisitorImpl(visitorContext);
        return visitor.visit(tree);
    }

    public String parseString(String value) {
        StringLexer lexer = new StringLexer(CharStreams.fromString(value));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        StringParser parser = new StringParser(tokens);
        ParseTree tree = parser.string();

        StringVisitorImpl visitor = new StringVisitorImpl(visitorContext);
        return visitor.visit(tree);
    }

    public Double parseNumeric(String value) {
        NumericLexer lexer = new NumericLexer(CharStreams.fromString(value));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NumericParser parser = new NumericParser(tokens);
        ParseTree tree = parser.numeric();

        NumericVisitorImpl visitor = new NumericVisitorImpl(visitorContext);
        return visitor.visit(tree);
    }

}
