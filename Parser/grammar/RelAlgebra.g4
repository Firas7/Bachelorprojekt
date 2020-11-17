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
	'[' attribut comparator attribut ']' #Predicate_
;

relation: 
	ID #simple | expr #nested
;

select:
	SELECT predicate '('relation')'
;

project: 
	PROJECT '[' (attribut',' | attribut)+ ']' '('relation')'
;

cartesian:
	'(' relation ')' (CARTESIAN '(' relation ')')+
;

join:
	'(' relation ')' JOIN predicate '(' relation ')' 
;

attribut:
	ID '.' ID | ID
;

comparator:
	'=' | '<' | '>'
;


// lexer rules

// Terminaltype: SELECT , nicht terminaltype: 'SL'

/* Select Token */
SELECT: 
	'SL'
;
/* Project Token */
PROJECT:
	'PR'
;
/* Join Token */
JOIN: 
	'JN'
;

CARTESIAN: 
	'X'
;
/* Relation Token */

ID:
	[a-zA-Z0-9] [a-zA-Z0-9_]*
;

VALUE:
	'"' .*? '"'
;

COMPERATOR:
	'=' | '<' | '>'
;

WS:
	[ \t\r\n]+ -> skip	
;

//fragments defined to make the input case-insensitive
fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');

