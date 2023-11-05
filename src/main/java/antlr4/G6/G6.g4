grammar G6;

prog: stat | prog stat;
stat: expr '\n' | '\n';
expr: term | expr '+' term | expr '-' term;
term: fact | term'*'fact | term '/' fact;
fact: INT |  '(' (expr) ')';

INT: [0-9]+;
OTHER: .-> skip;
