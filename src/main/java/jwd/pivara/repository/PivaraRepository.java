package jwd.pivara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.pivara.model.Pivara;

@Repository
public interface PivaraRepository 
	extends JpaRepository<Pivara, Long> {

}
