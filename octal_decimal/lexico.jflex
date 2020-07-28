package octal_decimal;
import java_cup.runtime.Symbol;


%%

%{
%}

%cup
%class scanner
%public
%line
%char
%column
%full

numeroOctal=[0-7]

/*Espacios*/
Espacios   = [\ \r\t\f]
Enter   = [\ \n]

%%



<YYINITIAL> {numeroOctal}     
{ 
        return new Symbol(sym.numeroOctal, yyline, yycolumn,yytext());
}

<YYINITIAL> {Espacios}      {}
<YYINITIAL> {Enter}         {}

<YYINITIAL> [^] 
{
        String errLex = " Error léxico, caracter irreconocible: '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn;
}
