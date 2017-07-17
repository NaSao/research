package de.tuc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.tuc.service.neo4j.Neo4jService;
import de.tuc.vo.CityVO;
import de.tuc.vo.CountryVO;
import de.tuc.vo.GeoPointVO;
import de.tuc.vo.IndexVO;
import de.tuc.vo.KMLVO;
import de.tuc.vo.ProvinceVO;
import de.tuc.vo.ServerVO;

@RestController
public class Neo4jController {
	
	@Autowired
	Neo4jService ns;
	
	@RequestMapping(value = "/indexCounts")
	public IndexVO getIndexInfos(){
		IndexVO indexVO = new IndexVO();
		
		return indexVO;
	}
	
	@RequestMapping(value = "/allServers")
	public List<ServerVO> getAllServers(String type){
		return ns.getAllServers(type);
	}
	
	@RequestMapping(value = "/getCountrysBySubRegion")
	public List<CountryVO> getCountrysBySubRegion(String subRegionName){
		List<CountryVO> coVOList = ns.getCountryBySubRegion(subRegionName);
		return coVOList;
	}
	
	@RequestMapping(value = "/getProvincesByCountry")
	public List<ProvinceVO> getProvincesByCountry(String countryName){
		List<ProvinceVO> pVOList = ns.getProvinceByCountry(countryName);
		return pVOList;
	}
	
	@RequestMapping(value = "/getCitysByProvince")
	public List<CityVO> getCitysByProvince(String provinceName){
		List<CityVO> cVOList = ns.getCityByProvince(provinceName);
		return cVOList;
	}
	
	@RequestMapping(value = "/getServersbyGeoRect")
	@ResponseBody
	public List<ServerVO> getServerByGeoRect(float northEastLat,float northEastLon, float southWestLat, float southWestLon){
		System.out.println(northEastLat+"++++++++++++++++++++++");
		//List<ServerVO> svo = ns.getServerByGeoRect(northEastLat, northEastLon, southWestLat, southWestLon);
		List<ServerVO> svo = ns.getServerRefByGeoRect(northEastLat, northEastLon, southWestLat, southWestLon);
		System.out.println(svo.size()+"========================");
		return svo;
	}
	
	@RequestMapping(value = "/getServersbyGeoCircle")
	@ResponseBody
	public List<ServerVO> getServerByGeoCircle(float latitude, float longitude, float distance){
		//List<ServerVO> svo = ns.getServerByGeoRect(northEastLat, northEastLon, southWestLat, southWestLon);
		List<ServerVO> svo = ns.getServerCircleByGeoRect(latitude, longitude, distance);
		return svo;
	}
	
	@RequestMapping(value = "/getProvinceKMLsByCountry")
	@ResponseBody
	public List<KMLVO> getProvinceKMLsByCountry(String countryName){
		//List<ServerVO> svo = ns.getServerByGeoRect(northEastLat, northEastLon, southWestLat, southWestLon);
		//String countryName = "Germany";
		List<KMLVO> kmlvos = ns.getKMLsByCountry(countryName);
		return kmlvos;
	}
	
	@RequestMapping(value = "/getProvinceGPByName")
	@ResponseBody
	public List<GeoPointVO> getProvinceGPByName(String provinceName){
		List<GeoPointVO> gpvolist = ns.getGeoPointsByProvince(provinceName);
		return gpvolist;
	}
	
	
}
