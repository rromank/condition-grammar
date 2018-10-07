grammar String;

string
    :lowerFunction
    |upperFunction
    |stringLiteral
    ;

lowerFunction       : 'lower(' string ')';
upperFunction       : 'upper(' string ')';

stringLiteral: STRING_LITERAL ;

STRING_LITERAL : '"' (~["\\\r\n])* '"';

WS    : [ \t\r\n]+ -> skip;