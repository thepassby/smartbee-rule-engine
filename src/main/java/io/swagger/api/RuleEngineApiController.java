package io.swagger.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static io.swagger.Responses.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-05T13:50:22.207Z")

@RestController
public class RuleEngineApiController implements RuleEngineApi {

	public ResponseEntity<String> show() {
		// do some magic!
		return ok("this is result ...");
	}
}
