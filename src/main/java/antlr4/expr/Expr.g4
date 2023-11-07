grammar Expr;

prog : stat+ | EOF;

stat : expr '\n' | '\n' ;

expr : INT
    | '(' expr ')'
    | expr '*' expr
    | expr '/' expr
    | expr '+' expr
    | expr '-' expr
    ;

INT : [0-9]+ ;
OTHER: .->skip;