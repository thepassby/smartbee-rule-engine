package io.swagger.api;

import static io.swagger.Responses.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cc.nolink.rule.service.AmqpService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-05T13:50:22.207Z")

@RestController
public class RuleEngineApiController implements RuleEngineApi {
	@Autowired
	AmqpService amqpService;
	
	public ResponseEntity<String> send(String message) {
		amqpService.sendMsg(message);
		return ok(message);
	}
}
