package eogjostol.calc.soap;

import eogjostol.calc.Calculator;
import eogjostol.calc.wsdl.Add;
import eogjostol.calc.wsdl.AddResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class CalculatorClient extends WebServiceGatewaySupport implements Calculator {

    private static final String SOAP_ACTION = "http://tempuri.org/Add";
    private static final String URI = "http://www.dneonline.com/calculator.asmx";

    public int add(int a, int b) {
        final var request = new Add();
        request.setIntA(a);
        request.setIntB(b);
        final var callback = new SoapActionCallback(SOAP_ACTION);

        final var response = (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URI, request, callback);

        return response.getAddResult();
    }
}
