grammar String;

string
    :lowerFunction
    |upperFunction
    |stringConstant
    |stringLiteral
    ;

lowerFunction: 'lower(' string ')';
upperFunction: 'upper(' string ')';

stringLiteral: STRING_LITERAL;
STRING_LITERAL : '"' (~["\\\r\n])* '"';

stringConstant
    :ASSOCIATION_NAME
    |BORROWER_NAME;

// Constants
ASSOCIATION_NAME    : 'ASSOCIATION_NAME';
BORROWER_NAME       : 'BORROWER_NAME';

WS             : [ \t\r\n]+ -> skip;