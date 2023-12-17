grammar Cymbol;


file:  include* (functionDecl | varDecl)+ ;

include: '#include' ('<stdio.h>'| '<stdbool.h>');

functionDecl
    :   type ID '(' formalParameters? ')' block
    ;

formalParameters
    :   formalParameter (',' formalParameter)*
    ;
formalParameter
    :   type ID
    ;

stat:   block
    |   varDecl
    |   ifStat
    |   forStat
    |   whileStat
    |   returnStat ';'
    |   assignStat  ';'
    |   printStat  ';'
    |   expr ';'
    ;

block:  '{' stat* '}' ;

assignStat:  ID '=' expr ;

ifStat
    :   ifSingle
    |   ifElse
    ;

ifSingle: 'if' '('bexpr ')' stat ;

ifElse: 'if' '('bexpr ')' stat 'else' stat ;

forStat: 'for' '(' assignStat ';' bexpr ';' assignStat ')' stat ;

whileStat: 'while' '('bexpr')' stat ;

returnStat: 'return' expr ;

args
    :   argsNone
    |   argsSingle
    |   argsMul
    ;

argsNone : ;

argsSingle : expr ;

argsMul : expr (',' expr)+ ;

printStat: 'printf' '(' '"' '%d' '\\n' '"' ',' expr ')';

varDecl:   type ID ';' ;

type:   'float' | 'int' ;

expr:   op = '-' expr           # Minus
    |   expr op=('*'|'/') expr  # MulDiv
    |   expr op=('+'|'-') expr  # AddSub
    |   ID                      # VarRef
    |   INT                     # Int
    |   '(' expr ')'            # Parentheses
    |   ID '(' args ')'         # FunctionCall
    ;

bexpr:   '!' bexpr                          # Not
    |   expr op=('=='|'!='|'<'|'>') expr    # RelOp
    |   'true'                              # True
    |   'false'                             # False
    |   '(' bexpr ')'                       # Parentheses_Bool
    ;

K_INT
    :   'int'
    ;
K_FLOAT
    :   'float'
    ;
K_VOID
    :   'void'
    ;

ID  :   LETTER (LETTER | [0-9])* ;
fragment
LETTER : [a-zA-Z] ;

INT :   [0-9]+ ;

WS  :   [ \t\n\r]+ -> skip ;

SL_COMMENT
    :   '//' .*? '\n' -> skip
    ;
