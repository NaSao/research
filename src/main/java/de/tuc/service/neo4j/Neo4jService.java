package de.tuc.service.neo4j;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.tuc.vo.CityVO;
import de.tuc.vo.CountryVO;
import de.tuc.vo.GeoPointVO;
import de.tuc.vo.IndexVO;
import de.tuc.vo.KMLVO;
import de.tuc.vo.ProvinceVO;
import de.tuc.vo.ServerVO;

@Service
@Transactional
public interface Neo4jService {
	
	public IndexVO getIndexInfo();
	public List<CountryVO> getCountryBySubRegion(String srName);
	public List<ProvinceVO> getProvinceByCountry(String countryName);
	public List<CityVO> getCityByProvince(String provinceName);
	public List<ServerVO> getServerByCity(String geoId);
	public List<ServerVO> getAllServers(String type);
	public List<ServerVO> getServerByGeoRect(float northEastLat,float northEastLon, float southWestLat, float southWestLon);
	public List<ServerVO> getServerRefByGeoRect(float northEastLat, float northEastLon, float southWestLat,
			float southWestLon);
	public List<ServerVO> getServerCircleByGeoRect(float latitude, float longitude,float distance);
	public List<KMLVO> getKMLsByCountry(String countryName);
	public boolean pointInPolygon(float latitude,float longitude,String polygonName);
	
	public boolean pointInPolygon(float latitude,float longitude,List<float[]> polyCorners);
	public List<GeoPointVO> getGeoPointsByProvince(String provinceName);
}
