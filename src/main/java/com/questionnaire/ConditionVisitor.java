//package com.questionnaire;
//
//public class ConditionVisitor extends AbstractVisitor<ConditionLexer, ConditionParser> {
//    public ConditionVisitor(String text) {
//        super(ConditionLexer.class, ConditionParser.class, text);
//    }
//
//    public boolean result() {
//        switch (getParser().calc().expr()) {
//
//        }
//        return visit(getParser().calc().expr());
//    }
//
//    private boolean visit(ConditionParser.AndExpressionContext andExpressionContext) {
//        return visit(andExpressionContext.expr(0)) && visit(andExpressionContext.expr(1));
//    }
//
//    private boolean visit(ConditionParser.ExprContext context) {
//        if (context.bool() != null) {
//            return Boolean.parseBoolean(context.bool().getText());
//        } else if (context.AND() != null) {
//            return visit(context.expr(0)) && visit(context.expr(1));
//        } else if (context.OR() != null) {
//            return visit(context.expr(0)) || visit(context.expr(1));
//        } else {
//            throw new IllegalStateException();
//        }
//
////        if(context.number() != null) {
////            return Double.parseDouble(context.number().getText());
////        }
////        else if (context.BR_CLOSE() != null) {
////            return visit(context.expr(0));
////        }
////        else if (context.TIMES() != null) {
////            return visit(context.expr(0)) * visit(context.expr(1));
////        }
//    }
//
//    public static boolean parseBoolean(String text) {
//        return new ConditionVisitor(text).result();
//    }
//}