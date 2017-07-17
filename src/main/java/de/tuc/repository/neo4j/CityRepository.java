package de.tuc.repository.neo4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import de.tuc.domain.City;

public interface CityRepository extends GraphRepository<City>{
	Logger logger = LogManager.getLogger();
	@Query("MATCH (c:City)-[:in]->(p:Province) WHERE p.name =~ {pName} RETURN c")
	Iterable<City> findCityUsingProvince(@Param("pName") String pName);
}
