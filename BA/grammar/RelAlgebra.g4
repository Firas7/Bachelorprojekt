grammar RelAlgebra;

import RelLex;

expression: select;
select: SL PREDICATE '(' relation ')';

relation:  RELATION #simple | expression #nested;
