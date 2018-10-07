grammar Condition;

import String;

calc: expr;

expr
    :LPAR expr RPAR                 # braces
    |expr AND expr                  # andExpression
    |expr OR expr                   # orExpression
    |expr EQ expr                   # eqExpression
    |expr NEQ expr                  # neqExpression
    |containsFunction               # contains
    |stringComparison               # stringComparisonExpression
    |bool                           # boolExpression
    ;

stringComparison
    :string EQ string               # stringEqExpression
    |string NEQ string              # stringNeqExpression
    ;


containsFunction    : stringLiteral '.contains(' stringLiteral ')';

bool: BOOL;

BOOL  : 'true' | 'false';
AND   : '&&';
OR    : '||';
EQ    : '==';
NEQ   : '!=';

GT    : '>';
LT    : '<';

PLUS  : '+';
MINUS : '-';
MULT  : '*';
DIV   : '/';
LPAR  : '(';
RPAR  : ')';

NUMBER: '-'? [0-9]+;

WS    : [ \t\r\n]+ -> skip;