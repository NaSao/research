package de.tuc.repository.neo4j;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import de.tuc.domain.ServerData;
import de.tuc.domain.ServerIPV4;

public interface ServerIPV4Repository extends GraphRepository<ServerIPV4>  {
	@Query("MATCH (s:ServerIPV4) return s")
	Iterable<ServerIPV4> findAll();
	
//	@Query("MATCH (s:ServerIPV4) return s")
//	Iterable<Map<String,Object>> findAllTest();
	
	@Query("MATCH (s:ServerIPV4) where s.latitude<{northEastLat} AND s.latitude> {southWestLat} AND s.longitude <{northEastLon} AND s.longitude > {southWestLon} RETURN s")
	Iterable<ServerIPV4> findServerByGeoRect(@Param("northEastLat") float northEastLat, @Param("northEastLon") float northEastLon, @Param("southWestLat") float southWestLat, @Param("southWestLon") float southWestLon);
	
	@Query("MATCH (s:ServerIPV4)-[:route]-(c:City)-[:in]-(p:Province)-[:in]-(co:Country) where s.latitude<{northEastLat} AND s.latitude> {southWestLat} AND s.longitude <{northEastLon} AND s.longitude > {southWestLon} RETURN s AS serverIPV4,c.name AS cityName,p.name AS provinceName,co.name AS countryName")
	Iterable<ServerData> findServerRefByGeoRect(@Param("northEastLat") float northEastLat, @Param("northEastLon") float northEastLon, @Param("southWestLat") float southWestLat, @Param("southWestLon") float southWestLon);
	
	@Query("MATCH (s:ServerIPV4)-[:route]-(c:City)-[:in]-(p:Province)-[:in]-(co:Country) with s,c,p,co,distance(point(s),point({latitude:{latitude}, longitude:{longitude}})) AS dis where dis < {distance} RETURN s AS serverIPV4,c.name AS cityName,p.name AS provinceName,co.name AS countryName,dis AS distance order by dis ")
	Iterable<ServerData> findServerCircleByGeoRect(@Param("latitude") float latitude, @Param("longitude") float longitude,@Param("distance") float distance);
}
