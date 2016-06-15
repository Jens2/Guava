grammar Guava;

import GuavaVocabulary;

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
        | FOR LPAR type? ID (ASSIGN expr)? SEMI
                    expr SEMI
                    expr RPAR stat                          #forStat
        ;

// All possible expressions in the language
expr    : NOT expr                            #notExpr
        | expr PLUS expr                      #addExpr
        | expr MINUS expr                     #minusExpr
        | expr MULT expr                      #multExpr
        | expr DIV expr                       #divExpr
        | expr POWER expr                     #powExpr
        | expr AND expr                       #andExpr
        | expr OR expr                        #orExpr
        | expr EQ expr                        #eqExpr
        | expr LT expr                        #ltExpr
        | expr LE expr                        #leExpr
        | expr GT expr                        #gtExpr
        | expr GE expr                        #geExpr
        | expr NE expr                        #neExpr
        | var PLUS PLUS                       #preIncr
        | var MINUS MINUS                     #preDecr
        | PLUS PLUS var                       #postIncr
        | MINUS MINUS var                     #postDecr
        | LPAR expr RPAR                      #parExpr
        | (NUM | BOOL | CHAR | STR | DECIMAL) #constExpr
        | ID                                  #idExpr
        ;

// Variable
var     : ID ;

// The basic types
type : INT | BOOLEAN | DOUBLE | CHARACTER | STRING;