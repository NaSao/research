package de.tuc.repository.neo4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import de.tuc.domain.Country;
import de.tuc.domain.Province;

public interface ProvinceRepository extends GraphRepository<Province>{
	Logger logger = LogManager.getLogger();
	@Query("MATCH (p:Province)-[:in]->(co:Country) WHERE co.name = {coName} RETURN p")
	Iterable<Province> findProvincesUsingCountry(@Param("coName") String coName);
}
