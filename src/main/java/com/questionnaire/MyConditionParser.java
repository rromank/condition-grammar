package com.questionnaire;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MyConditionParser {

    public static boolean parse(String expression) {
        ConditionLexer lexer = new ConditionLexer(CharStreams.fromString(expression));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ConditionParser parser = new ConditionParser(tokens);
        ParseTree tree = parser.calc();

        ConditionVisitorImpl visitor = new ConditionVisitorImpl();
        return visitor.visit(tree);
    }

}
