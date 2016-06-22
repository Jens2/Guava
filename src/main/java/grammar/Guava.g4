grammar Guava;

import GuavaVocabulary;

// The program begins with epicarp
program : EPIC body;

// Body of the program
body    : LBRACK stat* RBRACK;

// All possible statements in the language
stat    : type ID (ASSIGN expr)? SEMI                       #varDeclStat
        | type LSQBR NUM RSQBR ID (ASSIGN expr)? SEMI       #arrayDeclStat
        | ID ASSIGN expr SEMI                               #assignStat
        | IF LPAR expr RPAR stat (ELSE stat)?               #ifStat
        | LBRACK stat* RBRACK                               #blockStat
        | WHILE LPAR expr RPAR stat                         #whileStat
        | FOR LPAR forAss SEMI
                   expr SEMI
                   (ID ASSIGN expr |
                    ID PLUS PLUS |
                    ID MINUS MINUS) RPAR stat               #forStat
        | OUT LPAR STR (COMMA ID)* RPAR SEMI                #printStat
        | FORK stat*                                        #forkStat
        | JOIN SEMI                                         #joinStat
        ;

// All possible expressions in the language
expr    : prfOp expr                        #prfExpr
        | expr multOp expr                  #multExpr
        | expr plusOp expr                  #plusExpr
        | expr boolOp expr                  #boolExpr
        | expr compOp expr                  #compExpr
        | LPAR expr RPAR                    #parExpr
        | LSQBR (expr (COMMA expr)*)? RSQBR #arrayExpr
        | (NUM | BOOL | CHAR | DEC | STR)   #constExpr
        | ID LSQBR NUM RSQBR                #getArrayExpr
        | ID                                #idExpr
        ;

forAss  : type ID (ASSIGN expr) #forDecl
        | ID                    #forExisting
        ;

prfOp   : MINUS | NOT ;

multOp  : MULT | DIV | POWER ;

plusOp  : PLUS | MINUS ;

boolOp  : AND | OR ;

compOp  : LE | LT | GE | GT | EQ | NE ;

// The basic types
type    : INT           #intType
        | BOOLEAN       #boolType
        | DOUBLE        #doubleType
        | CHARACTER     #charType
        | STRING        #stringType
        ;