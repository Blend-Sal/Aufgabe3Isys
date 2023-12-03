/** Simple statically-typed programming language with functions and variables
 *  taken from "Language Implementation Patterns" book.
 */
grammar Cymbol;

@header {
package antlr4.graph;
import java.util.*;
}

file:   (functionDecl | varDecl)+ ;

varDecl
    :   type ID ('=' expr)? ';'
    ;
type:   'float' | 'int' | 'void' ; // user-defined types

functionDecl
    :   type ID '(' formalParameters? ')' block // "void f(int x) {...}"
    ;
formalParameters
    :   formalParameter (',' formalParameter)*
    ;
formalParameter
    :   type ID
    ;

block:  '{' stat* '}' ;   // possibly empty statement block
stat:   block                                   #BlockStat
    |   varDecl                                 #VarDevlStat
    |   'if' '(' expr ')' stat ('else' stat)?   #IfElse
    |   'return' expr? ';'                      #Return
    |   expr '=' expr ';'                       #Assign // assignment
    |   expr ';'                                #CallStat // func call
    ;

expr:   ID '(' exprList? ')'                        #Call  // func call like f(), f(x), f(1,2)
    |   ID '[' expr ']'                             #Index       // array index like a[i], a[i][j]
    |   '-' expr                                    #Negate       // unary minus
    |   '!' expr                                    #Not       // boolean not
    |   expr ('*' |'/') expr                        #MultDiv
    |   expr ('+'|'-') expr                         #AddSub
    |   expr '==' expr                              #Equal     // equality comparison (lowest priority op)
    |   expr ('!=' | '<' | '>' | '>=' | '<=') expr  #Compare
    |   ID                                          #Var                            // variable reference
    |   INT                                         #Int
    |   '(' expr ')'                                #Parens
    ;
exprList : expr (',' expr)* ;   // arg list

ID  :   LETTER (LETTER | [0-9])* ;
fragment
LETTER : [a-zA-Z] ;

INT :   [0-9]+ ;

WS  :   [ \t\n\r]+ -> skip ;

SL_COMMENT
    :   '//' .*? '\n' -> skip
    ;
