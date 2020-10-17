grammar Expr;

// Start Symbol
prog:
	(decl | expr)+
;

decl: ID ':' INT_TYPE '=' EOF;

expr: expr '*' expr
	| expr '+' expr
	| ID
	| NUM
;

ID: [a-z][a-zA-Z0-9]*;
NUM: '0' | '-'?[1-9][0-9]*;
INT_TYPE: 'INT';
// Comments
COMMENT: '--' ~[\r\n]* -> skip;
WS: [ \t\n]+ -> skip;


