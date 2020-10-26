grammar RelAlgebra;


expression: select | project | EOF;

// parser rules
select:
	SELECT PREDICATE '(' RELATION ')'
;


project:
	PROJECT ATTRIBUT+ '(' RELATION ')'
;


join:
	JOIN
;


cartesian:
	CARTESIAN
;

// lexer rules
SELECT: 
	[S][L]
;

PROJECT: 
	[P][R]
;

JOIN: 
	[j]
;

CARTESIAN: 
	[x]
;

PREDICATE:
	[P]
	//'[' .*? ']'
;

RELATION:
	[a-zA-Z] [a-zA-Z0-9_]*
;

ATTRIBUT:
	[_][a-zA-Z] [a-zA-Z0-9_]*
	//'\''.*?'\''
;

WS:
	[ \t\r\n]+ -> skip	
;


