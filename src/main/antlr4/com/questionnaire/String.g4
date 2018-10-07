grammar String;

string
    :lowerFunction
    |upperFunction
    |stringConstant
    |stringLiteral
    ;

lowerFunction       : 'lower(' string ')';
upperFunction       : 'upper(' string ')';

stringLiteral: STRING_LITERAL;

stringConstant
    :ASSOCIATION_NAME
    |BORROWER_NAME;

STRING_LITERAL : '"' (~["\\\r\n])* '"';

// Constants
ASSOCIATION_NAME    : 'ASSOCIATION_NAME';
BORROWER_NAME       : 'BORROWER_NAME';

WS             : [ \t\r\n]+ -> skip;