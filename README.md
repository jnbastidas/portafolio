# portafolio
Simple portfolio Java web app that displays the profile image, name, some text with the experience and a 5 tweet list of the user’s Twitter timeline.

REST API with two endpoints that allows the consumer to get and modify the profile information.



<b>Running the Portfolio Java app locally:</b>

PREREQUISITES

First, download the Java 11 Development Kit: either the official Oracle JDK or Open JDK.<br />
You will also need the latest version of Maven (version 3.6.3 is recommended).


Steps

1. INSTALL Portfile Application

  a) Clone and download this repository: https://github.com/jnbastidas/portafolio.git (keep note of the location).

  b) Checkout master branch.

  c) At the command line for your operating system, change your directory to where the source was downloaded, and build the project:

      » mvn clean
      » mvn compile
      » mvn install
  
 2. START WEB MODULE (Java web app)
  <br />Now let's go into the "portfolio-web" directory from the command line and executing:
  
      » mvn spring-boot:run
      
  Once this has finished executing, you should be able to see the Porfile web aplication by going to http://localhost:8080/portfolio in your browser.
 
 3. START THE API (Java rest services)
  <br />Let's go into the "portfolio-apis" directory from the command line and executing:

      » mvn spring-boot:run
 
  Once this has finished, you can use the url http://localhost:8081/portfolio/ping (from a rest client) to verify the correct work.
 
 
 
 <b>Key Features and Technologies<b/>
  
Spring Framework: It provides numerous features, including dependency injection and transaction control.
  
Twitter Appi integration: spring-social-twitter
  
Persistence: spring-jdbc
  
Web-pages: thymeleaf-spring5
  
Modular Design: this aplication has 4 modules
      - portfolio-model: bussines entities.
      - portfolio-service: it module has 2 leyers, repository-layer to database persistence, and service-layer to declare business services
      - portfolio-web: web interfaces (html, css)
      - portfolio-apis: it complies with the REST specification to declare rest apis.
      
      
<b>Total time:</b> 16 Hours
      
      
      
      
      
      
  
    
