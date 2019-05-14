package eogjostol.calc.soap;

import eogjostol.calc.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CalculatorConfig {

    // Must match the package in the <generatePackage> specified in pom.xml
    private static final String CONTEXT_PATH = "eogjostol.calc.wsdl";

    @Bean
    public Jaxb2Marshaller marshaller() {
        final var marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(CONTEXT_PATH);
        return marshaller;
    }

    @Bean
    public Calculator calculatorClient(Jaxb2Marshaller marshaller) {
        final var client = new CalculatorClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
