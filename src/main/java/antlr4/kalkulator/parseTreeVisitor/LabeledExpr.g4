grammar LabeledExpr;

@header{package antlr4.kalkulator.parseTreeVisitor;
        import java.util.*;}

prog : stat+ EOF;

stat : expr ASSIGN ID '\n' #assign
    | expr '\n' #printExpr
    | '\n' #blank
    ;
expr : INT              #int
   | '(' expr ')'       #parens
   | <assoc=right>expr op='^' expr #Exponentiation
   | expr op=('*' | '/') expr #MulDiv
   | expr op=('+' | '-') expr #AddSub
   | expr op=('==' | '<' | '>') expr #Compare
   | expr op=('?' | ':') expr #Conditional
   | ID               #id
   ;

MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
POW: '^';
EQUAL: '==';
LESS: '<';
GREATER: '>';
CONDITIONAL: '?';
COLON: ':';
ASSIGN: '=';

ID : [a-zA-Z]+ ;     // match integers
INT : [0-9]+ ;
OTHER: . -> skip ; // toss out whitespace
