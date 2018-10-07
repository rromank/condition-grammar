grammar Condition;

import Numeric, String;

calc: expr;

expr
    :LPAR expr RPAR                 # braces
    |numericComparison              # numericComparisonExpression
    |expr AND expr                  # boolAnd
    |expr OR expr                   # boolOr
    |expr EQ expr                   # boolEq
    |expr NEQ expr                  # boolNeq
    |containsFunction               # contains
    |stringComparison               # stringComparisonExpression
    |bool                           # boolExpression
    ;

stringComparison
    :string EQ string               # stringEq
    |string NEQ string              # stringNeq
    ;

numericComparison
    :numeric EQ numeric             # numericEq
    |numeric NEQ numeric            # numericNeq
    |numeric LT numeric             # numericLt
    |numeric GT numeric             # numericGt
    |numeric LE numeric             # numericLe
    |numeric GE numeric             # numericGe
    ;

containsFunction    : stringLiteral '.contains(' stringLiteral ')';

bool: BOOL;

BOOL  : 'true' | 'false';
AND   : '&&';
OR    : '||';
EQ    : '==';
NEQ   : '!=';
LT    : '<';
GT    : '>';
LE    : '<=';
GE    : '>=';

LPAR  : '(';
RPAR  : ')';


WS    : [ \t\r\n]+ -> skip;