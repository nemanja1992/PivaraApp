package jwd.pivara.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.pivara.model.Pivara;
import jwd.pivara.web.dto.PivaraDTO;

@Component
public class PivaraToPivaraDTO 
	implements Converter<Pivara, PivaraDTO> {

	@Override
	public PivaraDTO convert(Pivara pivara) {
		PivaraDTO pivaraDTO = new PivaraDTO();
		pivaraDTO.setId(pivara.getId());
		pivaraDTO.setNaziv(pivara.getNaziv());
		pivaraDTO.setPib(pivara.getPib());
		pivaraDTO.setDrzava(pivara.getDrzava());
		return pivaraDTO;
	}

	public List<PivaraDTO> convert(List<Pivara> pivara) {
		List<PivaraDTO> ret = new ArrayList<>();
		
		for(Pivara m: pivara){
			ret.add(convert(m));
		}
		
		return ret;
	}
}
