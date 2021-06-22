package br.com.cea.rpo0.bff.core.application.example;

import br.com.cea.rpo0.bff.core.commons.dto.ExampleDTO;
import br.com.cea.rpo0.bff.core.ports.in.example.ExampleIn;
import br.com.cea.rpo0.bff.core.ports.out.example.ExampleOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleCore implements ExampleIn {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExampleCore.class);

	private ExampleOut out;

	@Autowired
	public ExampleCore(ExampleOut out) {
		super();
		this.out = out;
	}

	@Override
	public ExampleDTO receive(ExampleDTO dto) {
		LOGGER.info(">>> request :: {}", dto);

		dto = out.receive(dto);
		
		LOGGER.info(">>> response :: {}", dto);
		
		return dto;
	}

}
