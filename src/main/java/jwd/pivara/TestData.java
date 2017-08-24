package jwd.pivara;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import jwd.pivara.service.PivoService;
import jwd.pivara.service.PivaraService;

@Component
public class TestData {
	@Autowired
	private PivaraService pivaraService;
	@Autowired
	private PivoService pivoService;

	
}