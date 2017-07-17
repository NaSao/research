package de.tuc.repository.neo4j;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import de.tuc.domain.ServerIPV6;

public interface ServerIPV6Repository extends GraphRepository<ServerIPV6>  {
	@Query("MATCH (s:ServerIPV6) return s")
	Iterable<ServerIPV6> findAll();
}
