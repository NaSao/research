package de.tuc.repository.neo4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import de.tuc.domain.Country;

public interface CountryRepository extends GraphRepository<Country>{
	Logger logger = LogManager.getLogger();
	
	@Query("MATCH (co:Country)-[:in]->(r:Region) WHERE r.name = {rName} RETURN co")
	Iterable<Country> findCountryUsingRegion(@Param("rName") String rName);
	
}
