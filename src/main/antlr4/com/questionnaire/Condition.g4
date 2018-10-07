grammar Condition;

import Numeric, String;

condition
    :LPAR condition RPAR            # boolBraces
    |condition AND condition        # boolAnd
    |condition OR condition         # boolOr
    |condition EQ condition         # boolEq
    |condition NEQ condition        # boolNeq
    |numericComparison              # numericComparisonExpression
    |stringComparison               # stringComparisonExpression
    |containsFunction               # contains
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

containsFunction : stringLiteral '.contains(' string ')';

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