package br.com.cea.rpo0.bff.core.ports.in.example;

import br.com.cea.rpo0.bff.core.commons.dto.ExampleDTO;

public interface ExampleIn {

	ExampleDTO receive(ExampleDTO dto);
	
}
