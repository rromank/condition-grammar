package com.questionnaire.visitor;

import com.questionnaire.ExpressionParser;
import com.questionnaire.Questionnaire;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VisitorContext {
    private Questionnaire questionnaire;
    private ExpressionParser expressionParser;
    private List<String> disabledProperties;
    private boolean constantsDisabled;
}
