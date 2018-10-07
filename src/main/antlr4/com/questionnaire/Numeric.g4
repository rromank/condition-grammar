grammar Numeric;

numeric
    :LPAR numeric RPAR              # numericBraces
    |numeric PLUS numeric           # plus
    |numeric MINUS numeric          # minus
    |numeric MULT numeric           # mult
    |numeric DIV numeric            # div
    |numberLiteral                  # number
    ;

numberLiteral
//    :DOUBLE
    :INT;

//DOUBLE : '-'? [0-9]+'.'[0-9]+;
INT    : [0-9]+;

PLUS  : '+';
MINUS : '-';
MULT  : '*';
DIV   : '/';

LPAR  : '(';
RPAR  : ')';

WS    : [ \t\r\n]+ -> skip;