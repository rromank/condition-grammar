package com.questionnaire;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

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
                {"\"hello\".contains(\"abc\")", false}
        });
    }

    @Parameterized.Parameter
    public String condition;

    @Parameterized.Parameter(1)
    public boolean expected;

    @Test
    public void test() {
        assertEquals(expected, MyConditionParser.parse(condition));
    }
//    @Test
//    public void test() {
//        assertEquals(expected, MyConditionParser.parse("true && true"));
//    }

}
