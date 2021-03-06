package com.questionnaire.visitor;

import com.questionnaire.ExpressionParser;
import com.questionnaire.Questionnaire;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AbstractVisitorTest {

    @Parameterized.Parameters(name = "{0} == {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"true", true},
                {"false", false},
                {"true && true", true},
                {"true && false", false},
                {"false && true", false},
                {"false && false", false},
                {"true || true", true},
                {"true || false", true},
                {"false || true", true},
                {"false || false", false},
                {"(true || false) && true", true},
                {"(true || false) && false", false},
                {"lower(\"ABC\") == \"abc\"", true},
                {"\"abc\" == lower(\"ABC\")", true},
                {"lower(\"ABCD\") == \"abc\"", false},
                {"\"abc\" == lower(\"ABCD\")", false},
                {"upper(\"abc\") == \"ABC\"", true},
                {"\"ABC\" == upper(\"abc\")", true},
                {"upper(\"abcd\") == \"ABC\"", false},
                {"\"ABC\" == upper(\"abcd\")", false},
                {"\"hello\".contains(\"el\")", true},
                {"\"hello\".contains(\"abc\")", false},
                {"\"abc\" == \"abc\"", true},
                {"\"abc\" != \"abc\"", false},
                {"\"abc\" != \"xyz\"", true},
                {"true == true", true},
                {"true == false", false},
                {"true != true", false},
                {"true != false", true},
                {"false == false", true},
                {"false == true", false},
                {"false != false", false},
                {"false != true", true},
                {"(2 + 3) > 4", true},
                {"(2 + 3) >= 5", true},
                {"\"VERY LONG STRING\".contains(upper(\"long\")) && 15 + 3 > 17", true},
                {"ASSOCIATION_NAME == \"ABC Association\"", true},
                {"(ASSOCIATION_NAME == \"ABC Association\" || 5 < 3) || \"abc\".contains(\"z\")", false},
        });
    }

    @Parameterized.Parameter
    public String condition;

    @Parameterized.Parameter(1)
    public boolean expected;

    @Test
    public void test() {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setAssociationName("ABC Association");
        questionnaire.setBorrowerName("John Smith");

        List<String> disabledProperties = new ArrayList<>();
        disabledProperties.add("ASSOCIATION_NAME");

        ExpressionParser expressionParser = new ExpressionParser(questionnaire, disabledProperties);

        Assert.assertEquals(expected, expressionParser.parseBoolean(condition));
    }
}
