lexer grammar GuavaVocabulary;

// Simple characters
DOT     : '.'  ;
COMMA   : ','  ;
SEMI    : ';'  ;
SQUOTE  : '\'' ;
DQUOTE  : '"'  ;

// Arithmetic operations
DIV     : '/'   ;
MULT    : '*'   ;
PLUS    : '+'   ;
MINUS   : '-'   ;
POWER   : '^'   ;
MOD     : 'mod' ;

// Assign operation
ASSIGN  : '=' ;

// Boolean operations
NOT     : '~'  ;
OR      : '|'  ;
AND     : '&'  ;
EQ      : '==' ;
LT      : '<'  ;
LE      : '<=' ;
GT      : '>'  ;
GE      : '>=' ;
NE      : '~=' ;

// Brackets and parentheses
LBRACK  : '{';
RBRACK  : '}';
LPAR    : '(';
RPAR    : ')';
LSQBR   : '[';
RSQBR   : ']';

// Data types
INT       : 'int'     ;
DOUBLE    : 'double'  ;
CHARACTER : 'char'    ;
BOOLEAN   : 'pulp'    ;
STRING    : 'string'  ;

// Data values
NUM   : '0' | DIGIT19 DIGIT09*          ;
BOOL  : TRUE | FALSE                    ;
CHAR  : SQUOTE LETTER SQUOTE            ;
DEC   : DIGIT09* DOT DIGIT09+           ;
STR   : DQUOTE (~["\\] | '\\'.)* DQUOTE ;
TRUE  : 'sweet'                         ;
FALSE : 'sour'                          ;

// Keywords
EPIC    : 'epicarp' ; //Main function
IF      : 'if'      ;
ELSE    : 'else'    ;
FOR     : 'force'   ;
WHILE   : 'while'   ;
FORK    : 'branch'  ;
JOIN    : 'join'    ;
OUT     : 'drop'    ;

// Fragments
fragment LETTER  : [a-zA-Z] ;
fragment DIGIT09 : [0-9]    ;
fragment DIGIT19 : [1-9]    ;

// Useful character compositions for identifiers (variables)
ID        : LETTER (LETTER | DIGIT09)*  ;

// Comments and whitespaces are skipped
COMMENTBLOCK    : '>~' .*? '~<' -> skip ;
COMMENTLINE     : '>>' ~[\r\n]* -> skip ;
WS              : [ \t\r\n]+    -> skip ;