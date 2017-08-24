package jwd.pivara.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.pivara.model.Pivo;

@Repository
public interface PivoRepository 
	extends JpaRepository<Pivo, Long> {

	Page<Pivo> findByPivaraId(Long pivaraId, Pageable pageRequest);


	@Query("SELECT f FROM Pivo f WHERE "
			+ "(:naziv IS NULL or f.naziv like :naziv ) AND "
			+ "(:minIbu IS NULL or f.ibu > :minIbu ) AND "
			+ "(:maxIbu IS NULL OR f.ibu <= :maxIbu)  "
			)
	Page<Pivo> pretraga(
			@Param("naziv") String naziv, 
			@Param("minIbu") Double minIbu, 
			@Param("maxIbu") Double maxIbu,
			
			Pageable pageRequest);

}
