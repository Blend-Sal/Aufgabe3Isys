grammar exprit;

prog: stat+;
stat: expr '\n' | '\n';
expr: term (('+'|'-') term)*;
term: fact | fact (('*'|'/') fact)+;
fact: '+' fact | '-' fact | '(' expr ')' | INT;

INT: [0-9]+;
OTHER: .-> skip;
