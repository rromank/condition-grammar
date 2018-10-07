grammar Numeric;

numeric
    :LPAR numeric RPAR              # numericBraces
    |numeric PLUS numeric           # numericPlus
    |numeric MINUS numeric          # numericMinus
    |numeric MULT numeric           # numericMult
    |numeric DIV numeric            # numericDiv
    |INT                            # number
    ;

INT    : [0-9]+;

PLUS  : '+';
MINUS : '-';
MULT  : '*';
DIV   : '/';

LPAR  : '(';
RPAR  : ')';

WS    : [ \t\r\n]+ -> skip;