lexer grammar ip;

IP : OCTET '.' OCTET '.' OCTET '.' OCTET;
fragment OCTET : '2' '5' '0'..'5' | '2' '0'..'4' DIGIT | '1' DIGIT DIGIT | '0'..'9' DIGIT? | '0';
fragment DIGIT : [0-9];

OTHER : . -> skip;