grammar Expr;

@header {
 package antlr4.kalkulator.grammarActions.tools;
 import java.util.*;
 }

 @parser::members {
 /** "memory" for our calculator; variable/value pairs go here */
 Map<String, Integer> memory = new HashMap<String, Integer>();

 int eval(int left, int op, int right) {
 switch (op) {
     case MUL: return left * right;
     case DIV: return left / right;
     case ADD: return left + right;
     case SUB: return left - right;
     case POW: return (int) Math.pow(left, right);
     case EQUAL: return left == right ? 1 : 0;
     case LESS: return left < right ? 1 : 0;
     case GREATER: return left > right ? 1 : 0;
     case CONDITIONAL: return right != 0 ? left : 0;
     case ASSIGN: return right;
 }
 return 0;
 }
 }

prog returns [int v]
  : stat+ {$v=$stat.v;}
  ;

stat returns [int v]
 : CLEAR '\n' {ExprParser.memory.clear(); $v = 0;}
 | e '=' ID {ExprParser.memory.put($ID.text, $e.v);}
 | e '\n' {System.out.println($e.v); $v = $e.v;}
 | 'if' '(' e ')' stat1=stat 'else' stat2=stat {$v = $e.v != 0 ? $stat1.v : $stat2.v;}
 | '\n' {$v = 0;}
 ;

 e returns [int v]
 : a=e op=('*'|'/'|'^'|EQUAL|LESS|GREATER|CONDITIONAL|ASSIGN) b=e {$v = eval($a.v, $op.type, $b.v);}
 | a=e op=('+'|'-') b=e {$v = eval($a.v, $op.type, $b.v);}
 | ID {$v = memory.get($ID.text);}
 | INT {$v = Integer.parseInt($INT.text);}
 | '(' e ')' {$v = $e.v;}
 ;

 CONDITIONAL : '?';
 COLON : ':';
 CLEAR : 'clear';
 MUL : '*';
 DIV : '/';
 ADD : '+';
 SUB : '-';
 POW : '^';
 EQUAL : '==';
 LESS : '<';
 GREATER : '>';
 ASSIGN : '=';
 IF : 'if';
 ELSE : 'else';
 INT : [0-9]+ ;
 ID : [a-zA-Z]+ ;   // match integers

 NEWLINE:'\n' ; // return newlines to parser (is end-statement signal)
 OTHER : . -> skip ; // toss out whitespace
