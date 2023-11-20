grammar pTListener;

@header {package antlr4.kalkulator.parseTreeListener;}

prog: stat+;

stat: expr '\n' # printExpr
     | ID '=' expr '\n' # idstate
     | CLEAR '\n' # clear
     | '\n' # blank;

expr: INT # int
      | ID # id
      | '(' expr ')' # parens
      | <assoc=right> expr '^' expr # potence
      | expr op=('*' | '/') expr # mulDiv
      | expr op=('+' | '-') expr # addSub
      | expr op=QSTMARK expr op=COLON expr # conditionalExpr
      | expr op=ASSIGN expr # assign
      | expr op=('==' | '<' | '>') expr # compare
;


INT: [0-9]+;
CLEAR: 'clear';
ID: [a-zA-Z]+;
QSTMARK: '?';
COLON: ':';
POT: '^';
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
EQUALS: '==';
GREATERTHAN: '<';
LESSTHAN: '>';
ASSIGN: '=';
NEWLINE: '\n';
OTHER: .->skip;
