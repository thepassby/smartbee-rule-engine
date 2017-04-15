package io.swagger.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-05T13:50:22.207Z")

@RequestMapping(value = "/api")
public interface RuleEngineApi {

	@RequestMapping(value = "/rule", produces = { MediaType.TEXT_HTML_VALUE }, method = RequestMethod.GET)
	@ApiOperation(value = "no", notes = "no", response = String.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "An string that", response = String.class),
			@ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Order not found") })
	public ResponseEntity<String> show() throws NotFoundException;
}
