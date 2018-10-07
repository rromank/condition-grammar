grammar String;

string
    :lowerFunction
    |upperFunction
    |stringLiteral
    ;

lowerFunction       : 'lower(' stringLiteral ')';
upperFunction       : 'upper(' stringLiteral ')';

stringLiteral: STRING_LITERAL ;

STRING_LITERAL : '"' (~["\\\r\n])* '"';

WS    : [ \t\r\n]+ -> skip;