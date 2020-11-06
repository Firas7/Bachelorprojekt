grammar RelAlgebra;

prog: 
	expr # Program  
	
;

expr: select #Selection
	| project #Projection
	| cartesian #Carstesian
	| join #Join_ 
	| EOF #EOF
;


predicate:
	PREDICATE #Predicate_
;

relation: 
	RELATION #simple | expr #nested
;
// lexer rules
SELECT: 
	'SL'
;

select:
	SELECT predicate '('relation')'
;

project: 
	PROJECT ATTRIBUT+ '('relation')' 
;

cartesian:
	CARTESIAN  '(' relation ( ',' relation )+ ')'
;

join:
	JOIN predicate '(' relation ( ',' relation )+ ')'
;

PROJECT:
	'PR'
;

JOIN: 
	'JN'
;

CARTESIAN: 
	'X'
;

PREDICATE:
	'['.*?']'
;

RELATION:
	[a-zA-Z] [a-zA-Z0-9_]*
;

ATTRIBUT:
	[_][a-zA-Z0-9_]*
;

WS:
	[ \t\r\n]+ -> skip	
;


