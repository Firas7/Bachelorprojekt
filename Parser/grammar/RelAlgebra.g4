grammar RelAlgebra;

prog: 
	expr # Program
;

expr: select #Selection
	| project #Projection
	| cartesian #Carstesian
	| join #Join_ 
	| rename #Rename_
	| union #Union_
	| intersection #Intersection_
	| difference #Difference_
;

difference:
	'(' relation ')' DIFFERENCE '(' relation ')' 
;

intersection:
	'(' relation ')' INTERSECTION '(' relation ')'
;
union:
	'(' relation ')' UNION '(' relation ')'
;

rename:
	RENAME '[' ID ']' '(' relation ')'
;
predicate:
	 attribut comparator attribut
	 
;

conditions:
	 subPredicate | subPredicate OR conditions
;

subPredicate:
	predicate | predicate AND subPredicate | '(' conditions ')' | ISNOT conditions
;

relation: 
	ID #simple | expr #nested
;

select:
	SELECT '[' conditions ']' '('relation')'
;

project: 
	PROJECT '[' attribut  (',' attribut)* ']' '('relation')'
;

cartesian:
	'(' relation ')' (CARTESIAN '(' relation ')')+
;

join:
	'(' relation ')' var JOIN  '[' conditions ']' '(' relation ')'
;

attribut:
	(ID'.')? ID
;

comparator:
	'=' | '<' | '>'| '>=' | '<=' | '!='
;


var:
	( 'R' | 'L' | 'F' )?
;

/* Lexer rules */

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

/* Cartesian Token */
CARTESIAN: 
	'X'
;

/* Rename Token */
RENAME:
	'R'
;

/* Union Token */
UNION:
	'UN'
;

/* Intersection Token */
INTERSECTION:
	'IN'
;

/* Difference Token */
DIFFERENCE:
	'DI'
;

/* ID Token */
ID:
	[a-zA-Z0-9] [a-zA-Z0-9_]*
;

/* And Token */
AND:
	'&'
;

/* Or Token */
OR:
	'|'
;

/* Is not Token */
ISNOT:
	'!'
;

/* ignore whitespace  */
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

