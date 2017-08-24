package jwd.pivara.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.pivara.model.Pivo;
import jwd.pivara.service.PivoService;
import jwd.pivara.support.PivoDTOToPivo;
import jwd.pivara.support.PivoToPivoDTO;
import jwd.pivara.web.dto.PivoDTO;

@RestController
@RequestMapping("/api/piva")
public class ApiPivoController {
	@Autowired
	private PivoService pivoService;
	@Autowired
	private PivoToPivoDTO toDTO;
	@Autowired
	private PivoDTOToPivo toPivo;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PivoDTO>> get(
			@RequestParam(required=false) String naziv,
			@RequestParam(required=false) Double minIbu,
			@RequestParam(required=false) Double maxIbu,
			@RequestParam(defaultValue="0") int pageNum){
		
		Page<Pivo> piva;
		
		if(naziv != null || minIbu != null || maxIbu != null ) {
			piva = pivoService.pretraga(naziv, minIbu, maxIbu, pageNum);
		}else{
			piva = pivoService.findAll(pageNum);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(piva.getTotalPages()) );
		return  new ResponseEntity<>(
				toDTO.convert(piva.getContent()),
				headers,
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,
					value="/{id}")
	public ResponseEntity<PivoDTO> get(
			@PathVariable Long id){
		Pivo stand = pivoService.findOne(id);
		
		if(stand==null){
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDTO.convert(stand),
				HttpStatus.OK);	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<PivoDTO> add(
			@RequestBody PivoDTO noviFestival){
		
		Pivo pivo = toPivo.convert(noviFestival); 
		pivoService.save(pivo);
		
		return new ResponseEntity<>(toDTO.convert(pivo),
				HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}")
	public ResponseEntity<PivoDTO> edit(
			@PathVariable Long id,
			@RequestBody PivoDTO izmenjen){
		
		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Pivo pivo = toPivo.convert(izmenjen); 
		pivoService.save(pivo);
		
		return new ResponseEntity<>(toDTO.convert(pivo),
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,
			value="/{id}")
	public ResponseEntity<PivoDTO> delete(@PathVariable Long id){
		pivoService.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
