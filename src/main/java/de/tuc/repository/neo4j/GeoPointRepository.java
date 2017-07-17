package de.tuc.repository.neo4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import de.tuc.domain.GeoPoint;

public interface GeoPointRepository extends GraphRepository<GeoPoint>{
	Logger logger = LogManager.getLogger();
	
	@Query("MATCH (gp:GeoPoint)-[]-(p:Province) WHERE p.name =~ {pName} RETURN gp")
	Iterable<GeoPoint> findGPUsingProvince(@Param("pName") String pName);
	
}
