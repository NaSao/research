package de.tuc.repository.neo4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import de.tuc.domain.Country;
import de.tuc.domain.KML;

public interface KMLRepository extends GraphRepository<KML> {
	Logger logger = LogManager.getLogger();
	
	@Query("match (k:KML)-[]-(p:Province)-[]-(co:Country) where co.name = {cName} return k")
	Iterable<KML> findProvinceKMLsUsingCountry(@Param("cName") String cName);
}
