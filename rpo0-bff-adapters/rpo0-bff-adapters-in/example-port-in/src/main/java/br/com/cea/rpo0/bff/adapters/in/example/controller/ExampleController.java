package br.com.cea.rpo0.bff.adapters.in.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.cea.rpo0.bff.core.commons.dto.ExampleDTO;
import br.com.cea.rpo0.bff.core.ports.in.example.ExampleIn;

@RestController
public class ExampleController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExampleController.class);

	private ExampleIn in;

	@Autowired
	public ExampleController(ExampleIn in) {
		super();
		this.in = in;
	}

	@PostMapping
	public @ResponseBody ResponseEntity<ExampleDTO> post(@RequestBody ExampleDTO dto) {
		LOGGER.info(">>> request :: {}", dto);

		dto = in.receive(dto);
		
		LOGGER.info(">>> response :: {}", dto);
		
		return new ResponseEntity<ExampleDTO>(dto, HttpStatus.CREATED);
	}
	
	@GetMapping
	public String get() {
		return "Hello...";
	}

}
