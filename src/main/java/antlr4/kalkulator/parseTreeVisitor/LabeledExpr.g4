grammar LabeledExpr;

@header{package antlr4.kalkulator.parseTreeVisitor;
        import java.util.*;}

prog : stat+ EOF;

stat: expr '\n'                           # printExpr
   | ID '=' expr '\n'                    # assign
   | '\n'                               # blank
   | 'clear'                             # clear
   | 'if' '(' expr ')' stat ('else' stat {$expr.v == 0}? )? # ifElse
   ;

expr : ID              #id
  | INT             #int
  | '(' expr ')'      #parens
  | <assoc=right>expr op='^' expr #Exponentiation
  | expr op=('*' | '/') expr #MulDiv
  | expr op=('+' | '-') expr #AddSub
  | expr op=('==' | '<' | '>') expr #Compare
  | expr op=('?' | ':') expr #Conditional
  ;


MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
POW: '^';
IF: 'if';
ELSE: 'else';
EQUAL: '==';
LESS: '<';
GREATER: '>';
CONDITIONAL: '?';
COLON: ':';
ASSIGN: '=';

ID : [a-zA-Z]+ ;     // match integers
INT : [0-9]+ ;
OTHER: . -> skip ; // toss out whitespace
