grammar Condition;

calc: expr;

expr
    :LPAR expr RPAR                 # braces
    |expr AND expr                  # andExpression
    |expr OR expr                   # orExpression
    |literalEquity                  # equity
    |containsFunction               # contains
    |bool                           # boolExpression
    ;

literalEquity
    :lowerEquity
    |upperEquity
    ;

lowerEquity
    :stringLiteral EQ lowerFunction
    |lowerFunction EQ stringLiteral
    ;

upperEquity
    :stringLiteral EQ upperFunction
    |upperFunction EQ stringLiteral
    ;

containsFunction    : stringLiteral '.contains(' stringLiteral ')';
lowerFunction       : 'lower(' stringLiteral ')';
upperFunction       : 'upper(' stringLiteral ')';

bool: BOOL;
stringLiteral: STRING_LITERAL ;

STRING_LITERAL : '"' (~["\\\r\n])* '"';

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