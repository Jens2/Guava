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
CHARACTER : 'char'    ;
BOOLEAN   : 'pulp'    ;

// Data values
NUM   : '0' | DIGIT19 DIGIT09*           ;
BOOL  : TRUE | FALSE                     ;
CHAR  : SQUOTE (LETTER | DIGIT09) SQUOTE ;
TRUE  : 'sweet'                          ;
FALSE : 'sour'                           ;

// Keywords
EPIC    : 'epicarp'   ; //Main function
IF      : 'if'        ;
ELSE    : 'else'      ;
FOR     : 'for'       ;
WHILE   : 'while'     ;
BRANCH  : 'branch'    ;
OUT     : 'drop'      ;
GLOBAL  : 'universal' ;
LOCK    : 'lock'      ;
UNLOCK  : 'unlock'    ;

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