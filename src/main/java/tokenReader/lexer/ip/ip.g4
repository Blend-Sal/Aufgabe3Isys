lexer grammar ip;

IP : OCTET '.' OCTET '.' OCTET '.' OCTET;
OCTET : '2' '5' '0'..'5' | '2' '0'..'4' DIGIT | '1' DIGIT DIGIT | '0'..'9' DIGIT? | '0';
DIGIT : [0-9];
WS : [ \t\r\n]+ -> skip;
