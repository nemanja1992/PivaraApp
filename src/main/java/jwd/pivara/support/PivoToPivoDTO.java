package jwd.pivara.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.pivara.model.Pivo;
import jwd.pivara.web.dto.PivoDTO;

@Component
public class PivoToPivoDTO 
	implements Converter<Pivo, PivoDTO> {

	@Override
	public PivoDTO convert(Pivo source) {
		PivoDTO dto = new PivoDTO();
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setProcenatAlkohola(source.getProcenatAlkohola());
		dto.setIbu(source.getIbu());
		dto.setKolicina(source.getKolicina());
		dto.setPivaraId(source.getPivara().getId());
		dto.setPivaraNaziv(source.getPivara().getNaziv());
		dto.setPivaraPib(source.getPivara().getPib());
		dto.setPivaraDrzava(source.getPivara().getDrzava());
		
		return dto;
	}
	
	public List<PivoDTO> convert(List<Pivo> piva){
		List<PivoDTO> ret = new ArrayList<>();
		
		for(Pivo f : piva){
			ret.add(convert(f));
		}
		
		return ret;
	}

}
