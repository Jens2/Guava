grammar Guava;

// The program begins with epicarp
program : EPIC body;

// Body of the program
body    : LBRACK stat+ RBRACK;

// All possible statements in the language
stat    : type ID (ASSIGN expr)? SEMI                       #declStat
        | var ASSIGN expr SEMI                              #assignStat
        | IF LPAR expr RPAR stat (ELSE stat)?               #ifStat
        | LBRACK stat* RBRACK                               #blockStat
        | WHILE LPAR expr RPAR stat                         #whileStat
        | FOR LPAR forBody SEMI expr SEMI update RPAR stat  #forStat
        | var PLUS PLUS                                     #incrStat
        ;

// All possible expressions in the language
expr    : expr PLUS expr        #addExpr
        | expr MINUS expr       #minusExpr
        | expr MULT expr        #multExpr
        | expr DIV expr         #divExpr
        | expr POWER expr       #powExpr
        | expr AND expr         #andExpr
        | expr OR expr          #orExpr
        | expr EQ expr          #eqExpr
        | expr LT expr          #ltExpr
        | expr LE expr          #leExpr
        | expr GT expr          #gtExpr
        | expr GE expr          #geExpr
        | expr NE expr          #neExpr
        | LPAR expr RPAR        #parExpr
        | NOT expr              #notExpr
        | (NUM | TRUE | FALSE)  #constExpr
        | ID                    #idExpr
        ;

// Variable
var     : ID ;

// For loop
forBody : type ID (ASSIGN expr)?    #forAssign
        | var                       #forVar
        ;

// Incrementing or decrementing a variable
update  : var PLUS PLUS     #incrVar
        | var MINUS MINUS   #decrVar
        ;

// The basic types
type : INT | BOOL | DOUBLE;

// Simple characters
DOT     : '.';
COMMA   : ',';
SEMI    : ';';

// Arithmetic operations
DIV     : '/';
MULT    : '*';
PLUS    : '+';
MINUS   : '-';
POWER   : '^';

// Assign operation
ASSIGN  : '=';

// Boolean operations
NOT     : '~'   ;
OR      : '|'   ;
AND     : '&'   ;
EQ      : '=='  ;
LT      : '<'   ;
LE      : '<='  ;
GT      : '>'   ;
GE      : '>='  ;
NE      : '~='  ;

// Brackets and parentheses
LBRACK  : '{';
RBRACK  : '}';
LPAR    : '(';
RPAR    : ')';
LSQBR   : '[';
RSQBR   : ']';

// Keywords
EPIC    : 'epicarp' ; //Main function
IF      : 'if'      ;
ELSE    : 'else'    ;
FOR     : 'for'     ;
WHILE   : 'while'   ;
INT     : 'int'     ;
DOUBLE  : 'double'  ;
CHAR    : 'char'    ;
BOOL    : 'pulp'    ;
TRUE    : 'sweet'   ;
FALSE   : 'sour'    ;
FORK    : 'fork'    ;
JOIN    : 'join'    ;

// Fragments
fragment LETTER : [a-zA-Z]  ;
fragment DIGIT  : [0-9]     ;

// Useful character compositions for identifiers (variables),
// strings, and numbers.
DECIMAL : NUMERIC DOT NUMERIC       ;
NUMERIC : DIGIT+                    ;
NUM     : DECIMAL | NUMERIC         ;
ID      : LETTER (LETTER | DIGIT)*  ;
STRING  : '"' (~[\\"] | '\\'.)* '"' ;

// Comments and whitespaces are skipped
COMMENTBLOCK    : '>~' .*? '~<' -> skip ;
COMMENTLINE     : '>>' ~[\r\n]* -> skip ;
WS              : [ \t\r\n]+    -> skip ;