package br.com.cea.rpo0.bff.adapters.out.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import br.com.cea.rpo0.bff.core.commons.dto.ExampleDTO;
import br.com.cea.rpo0.bff.core.ports.out.example.ExampleOut;

@Service
public class ExampleOutImpl implements ExampleOut {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExampleOutImpl.class);

	@Override
	public ExampleDTO receive(ExampleDTO dto) {
		LOGGER.info(">>> request :: {}", dto);

		String value = dto.getValue() + " :: Pass Out";
		
		dto.setValue(value);
		
		LOGGER.info(">>> response :: {}", dto);
		
		return dto;
	}

}
