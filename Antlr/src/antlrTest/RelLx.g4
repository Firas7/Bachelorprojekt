lexer grammar RelLx;

PROJEKT:
	[p][r];

ATTRIBUT:
	'\''.*?'\'';

RELATION:
	[a-zA-Z] [a-zA-Z0-9_]*;

COMMENT:
 	'--' ~[\r\n]* -> skip;

WS:
	[ \t\n]+ -> skip;
