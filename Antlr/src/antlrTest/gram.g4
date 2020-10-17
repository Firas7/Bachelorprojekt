grammar gram;

@header {

	package antlrTest;
}
// Start Symbol
stat:
	(expr)+ EOF
;

expr:
	project
;

project:
	PROJECT '(' relation ')'
;

PROJECT:
	[p][r]
;

relation:
	RELATION
;

RELATION:
	[a-z][A-Z]
;


NUM: '0' | '-' ? [1-9][0-9]*;
INT_TYPE: 'INT';
COMMENT: '--' ~[\r\n]* -> skip;
WS: [ \t\n]+ -> skip;
