package jwd.pivara.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.pivara.model.Pivo;
import jwd.pivara.service.PivoService;
import jwd.pivara.service.PivaraService;
import jwd.pivara.web.dto.PivoDTO;

@Component
public class PivoDTOToPivo 
	implements Converter<PivoDTO, Pivo>{
	
	@Autowired
	private PivoService pivoService;
	@Autowired
	private PivaraService pivaraService;
	
	
	@Override
	public Pivo convert(PivoDTO source) {
		Pivo pivo;
		if(source.getId()==null){
			pivo = new Pivo();
			pivo.setPivara(
					pivaraService.findOne(
							source.getPivaraId()));
		}else{
			pivo = pivoService.findOne(source.getId());
		}
		pivo.setNaziv(source.getNaziv());
		pivo.setProcenatAlkohola(source.getProcenatAlkohola());
		pivo.setIbu(source.getIbu());
		pivo.setKolicina(source.getKolicina());
		
		return pivo;
	}

}
