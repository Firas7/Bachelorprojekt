grammar RelAlgebra;

prog: 
	expr (',' expr)* # Program | EOF #EOF
;

expr: SELECT PREDICATE+ '(' RELATION ')'   # Selection 
	| PROJECT ATTRIBUT+ '(' RELATION ')'   # Projection 
	| JOIN # Join_
;

// parser rules
/*select:
	SELECT PREDICATE+ '(' RELATION ')'  
;

project:
	PROJECT ATTRIBUT+ '(' RELATION ')' 
;


join:
	JOIN 
;

cartesian:
	CARTESIAN # Cartesian_
;*/

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
	[/] [a-zA-Z0-9_] [=] [a-zA-Z0-9_]
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


