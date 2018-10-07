package com.questionnaire;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class ExpressionParser {

    public static boolean parseBoolean(String expression) {
        ConditionLexer lexer = new ConditionLexer(CharStreams.fromString(expression));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ConditionParser parser = new ConditionParser(tokens);
        ParseTree tree = parser.condition();

        ConditionVisitorImpl visitor = new ConditionVisitorImpl();
        return visitor.visit(tree);
    }

    public static String parseString(String value) {
        StringLexer lexer = new StringLexer(CharStreams.fromString(value));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        StringParser parser = new StringParser(tokens);
        ParseTree tree = parser.string();

        StringVisitorImpl visitor = new StringVisitorImpl();
        return visitor.visit(tree);
    }

    public static Double parseNumeric(String value) {
        NumericLexer lexer = new NumericLexer(CharStreams.fromString(value));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NumericParser parser = new NumericParser(tokens);
        ParseTree tree = parser.numeric();

        NumericVisitorImpl visitor = new NumericVisitorImpl();
        return visitor.visit(tree);
    }

}
