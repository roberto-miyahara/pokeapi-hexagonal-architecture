package br.com.cea.rpo0.bff.core.ports.out.example;

import br.com.cea.rpo0.bff.core.commons.dto.ExampleDTO;

public interface ExampleOut {

	ExampleDTO receive(ExampleDTO dto);
	
}
