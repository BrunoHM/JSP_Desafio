#Readme

#####Instalar e configurar Java 13

#####Instalar e configurar apache maven 3.6.3

#####Instalar apache tomcat 8.5.57

#####Instalar e configurar mysql 8

1 - Fazer download do projeto da branch master.

#####Prepara��o do banco de dados

2 - Executar arquivo "%desafio%/script.sql" no banco de dados mysql

#####Prepara��o da aplica��o

2 - Editar conex�o, usu�rio e senha com banco de dados mysql no arquivo "%desafio%/src/utils/DtbUtil.java"

3 - Atrav�s da linha de comando, navegar at� a pasta do projeto

4 - Executar comando "mvn install" na linha de comando

5 - Navegar at� a pasta "target"

6 - Copiar pasta "Desafio-1.0" para dentro de "%Apache-tomcat%/webapps"

7 - Renomear pasta para "desafio"

8 - Atrav�s da linha de comando navegue at� a pasta "%Apache-tomcat%/bin"

9 - Executar comando "startup"

10 - Abra a url "http://localhost:8080/Desafio/index.jsp" em um navegador.
