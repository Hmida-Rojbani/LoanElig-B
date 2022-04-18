package de.tekup.loan.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import de.tekup.loan.service.LoanService;
import de.tekup.loan.soap.ws.loaneligebilty.CustomerRequest;
import de.tekup.loan.soap.ws.loaneligebilty.WsResponse;
import lombok.AllArgsConstructor;

@Endpoint
@AllArgsConstructor
public class LoanEndpoint {
	
	public static final String NAME_SPACE="http://www.tekup.de/loan/soap/ws/loanEligebilty";
	private LoanService service;
	
	@PayloadRoot(namespace = NAME_SPACE,localPart = "CustomerRequest")
	@ResponsePayload
	public WsResponse checkStatus(@RequestPayload CustomerRequest request) {
		return service.getLoanStatus(request);
	}

}
