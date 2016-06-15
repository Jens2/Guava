lexer grammar GuavaVocabulary;

// Simple characters
DOT     : '.'  ;
COMMA   : ','  ;
SEMI    : ';'  ;
SQUOTE  : '\'' ;
DQUOTE  : '"'  ;

// Arithmetic operations
DIV     : '/' ;
MULT    : '*' ;
PLUS    : '+' ;
MINUS   : '-' ;
POWER   : '^' ;

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
STRING    : 'String'  ;

// Data values
CONST : NUM | BOOL | CHAR | DEC | STR   ;
NUM   : '0' | [1-9]+                    ;
BOOL  : TRUE | FALSE                    ;
CHAR  : SQUOTE LETTER SQUOTE            ;
DEC   : DIGIT* DOT DIGIT+               ;
STR   : DQUOTE (~[\\"] | '\\'.)* DQUOTE ;
TRUE  : 'sweet'                         ;
FALSE : 'sour'                          ;

// Keywords
EPIC    : 'epicarp' ; //Main function
IF      : 'if'      ;
ELSE    : 'else'    ;
FOR     : 'for'     ;
WHILE   : 'while'   ;
FORK    : 'branch'  ;
JOIN    : 'join'    ;

// Fragments
fragment LETTER : [a-zA-Z] ;
fragment DIGIT  : [0-9]    ;

// Useful character compositions for identifiers (variables)
ID        : LETTER (LETTER | DIGIT)*  ;

// Comments and whitespaces are skipped
COMMENTBLOCK    : '>~' .*? '~<' -> skip ;
COMMENTLINE     : '>>' ~[\r\n]* -> skip ;
WS              : [ \t\r\n]+    -> skip ;