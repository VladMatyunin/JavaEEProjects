<h2>Description</h2>
Simple web application with filtering to show Part entites in web interface.

<h3>Running</h3>
**Database**<br>
Provide several configurations:
_username: postgres_ <br>
_password: sa_ <br>
_port: 5432_ <br>

Run initialization script placed in resources dir. 
<hr/>
1. Using existing .war <br>
    - copy .war file to /webapps package in tomcat, rename it to ROOT.war <br>
    - run tomcat server 
    $CATALINA_HOME\bin\startup.sh or bat file on windows environment <br>    
2. Using Maven <br>
    - mvn tomcat7:deploy
    