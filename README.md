# SoapCalculatorClient

Demonstrates use of SOAP client in Java 11.

Adds two numbers using the calculator web service provided at `http://www.dneonline.com/calculator.asmx`.

Classes are generated based on WSDL using `maven-jaxb2-plugin` in POM.

POM includes `versions-maven-plugin` and `maven-enforcer-plugin`.

Usage:
1. Generate classes using `mvn clean install`.
2. Run `Application` class.
3. Expect numbers 5 and 7 to be added and the sum output.
