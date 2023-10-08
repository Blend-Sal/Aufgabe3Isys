lexer grammar times;

TIME
: HOUR DP MIN (DP MIN)?;

fragment HOUR: (([0-1][0-9]) | ([2][0-3]));
fragment MIN: [0-5][0-9];
fragment DP: ':';

OTHER : . -> skip;