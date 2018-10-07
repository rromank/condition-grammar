grammar Condition;

import String;

calc: expr;

expr
    :LPAR expr RPAR                 # braces
    |expr AND expr                  # andExpression
    |expr OR expr                   # orExpression
    |string EQ string               # equityExpression
    |containsFunction               # contains
    |bool                           # boolExpression
    ;

containsFunction    : stringLiteral '.contains(' stringLiteral ')';

bool: BOOL;

BOOL  : 'true' | 'false';
AND   : '&&';
OR    : '||';
EQ    : '==';

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