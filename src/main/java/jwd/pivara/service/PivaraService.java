package jwd.pivara.service;

import java.util.List;

import jwd.pivara.model.Pivo;
import jwd.pivara.model.Pivara;


public interface PivaraService {
	List<Pivara> findAll();
	Pivara findOne(Long id);
	void save(Pivara pivara);
	void remove(Long id);

}
