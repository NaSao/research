package de.tuc.service.impl.neo4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.tuc.convertor.CommonConvertor;
import de.tuc.domain.City;
import de.tuc.domain.Country;
import de.tuc.domain.GeoPoint;
import de.tuc.domain.KML;
import de.tuc.domain.Province;
import de.tuc.domain.ServerData;
import de.tuc.domain.ServerIPV4;
import de.tuc.domain.ServerIPV6;
import de.tuc.repository.neo4j.CityRepository;
import de.tuc.repository.neo4j.CountryRepository;
import de.tuc.repository.neo4j.GeoPointRepository;
import de.tuc.repository.neo4j.KMLRepository;
import de.tuc.repository.neo4j.ProvinceRepository;
import de.tuc.repository.neo4j.ServerIPV4Repository;
import de.tuc.repository.neo4j.ServerIPV6Repository;
import de.tuc.service.neo4j.Neo4jService;
import de.tuc.vo.CityVO;
import de.tuc.vo.CountryVO;
import de.tuc.vo.GeoPointVO;
import de.tuc.vo.IndexVO;
import de.tuc.vo.KMLVO;
import de.tuc.vo.ProvinceVO;
import de.tuc.vo.ServerVO;

@Service
@Transactional
public class Neo4jServiceImpl implements Neo4jService{
	
	private final static String IPV4 = "IPV4";
	private final static String IPV6 = "IPV6";

	@Autowired
	CommonConvertor convert;
	@Autowired
	Neo4jOperations nt;
	@Autowired
	CountryRepository cor;
	@Autowired
	ServerIPV4Repository sr4;
	@Autowired
	ServerIPV6Repository sr6;
	@Autowired
	CityRepository cr;
	@Autowired
	ProvinceRepository pr;
	@Autowired
	Neo4jOperations neo4joper;
	@Autowired
	KMLRepository kmlRepository;
	
	@Autowired
	GeoPointRepository gpRepository;
	
	@Override
	public IndexVO getIndexInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<CountryVO> getCountryBySubRegion(String srName) {
		// TODO Auto-generated method stub
		Iterable<Country> ci = cor.findCountryUsingRegion(srName);
		Iterator<Country> cior= ci.iterator();
		List<Country> countryList = new ArrayList<Country>();
		while(cior.hasNext()){
			countryList.add(cior.next());
		}
		return convert.convertTOCountryVOList(countryList);
	}
	
	@Override
	public List<ProvinceVO> getProvinceByCountry(String countryName) {
		Iterable<Province> pi = pr.findProvincesUsingCountry(countryName);
		Iterator<Province> pior= pi.iterator();
		List<Province> provinceList = new ArrayList<Province>();
		while(pior.hasNext()){
			provinceList.add(pior.next());
		}
		return convert.convertTOProvinceVOList(provinceList);
	}

	@Override
	public List<CityVO> getCityByProvince(String provinceName) {
		provinceName= provinceName+".*";
		Iterable<City> ci = cr.findCityUsingProvince(provinceName);
		Iterator<City> cior= ci.iterator();
		List<City> cityList = new ArrayList<City>();
		while(cior.hasNext()){
			cityList.add(cior.next());
		}
		return convert.convertTOCityVOList(cityList);
	}

	@Override
	public List<ServerVO> getServerByCity(String geoId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<ServerVO> getAllServers(String type) {
		// TODO Auto-generated method stub
		List <ServerVO> svo = null;
		if(IPV4.equals(type)){
			Iterable<ServerIPV4> is4 = sr4.findAll();
			Iterator<ServerIPV4> ios4 = is4.iterator();
			List<ServerIPV4> s4= new ArrayList<ServerIPV4>();
			while(ios4.hasNext()){
				s4.add(ios4.next());
			}
			svo = convert.convert4TOServerVO(s4);
		}else{
			Iterable<ServerIPV6> is6 = sr6.findAll();
			Iterator<ServerIPV6> ios6 = is6.iterator();
			List<ServerIPV6> s6= new ArrayList<ServerIPV6>();
			while(ios6.hasNext()){
				s6.add(ios6.next());
			}
			svo = convert.convert6TOServerVO(s6);
		}
		
		return svo;
	}



	@Override
	public List<ServerVO> getServerByGeoRect(float northEastLat, float northEastLon, float southWestLat,
			float southWestLon) {
		// TODO Auto-generated method stub
		Iterable<ServerIPV4> is4 = sr4.findServerByGeoRect(northEastLat, northEastLon, southWestLat, southWestLon);
		Iterator<ServerIPV4> ios4 = is4.iterator();
		List<ServerIPV4> s4 = new ArrayList<ServerIPV4>();
		while(ios4.hasNext()){
			s4.add(ios4.next());
		}
		List<ServerVO> svo = convert.convert4TOServerVO(s4);
		return svo;
	}

	@Override
	public List<ServerVO> getServerRefByGeoRect(float northEastLat, float northEastLon, float southWestLat,
			float southWestLon) {
		// TODO Auto-generated method stub
		Iterable<ServerData> isdata = sr4.findServerRefByGeoRect(northEastLat, northEastLon, southWestLat, southWestLon);
		Iterator<ServerData> iosdata = isdata.iterator();
		List<ServerData> s4 = new ArrayList<ServerData>();
		while(iosdata.hasNext()){
			s4.add(iosdata.next());
		}
		List<ServerVO> svo = convert.convertDataTOServerVO(s4);
		return svo;
	}



	@Override
	public List<ServerVO> getServerCircleByGeoRect(float latitude, float longitude, float distance) {
		// TODO Auto-generated method stub
		Iterable<ServerData> isdata = sr4.findServerCircleByGeoRect(latitude, longitude, distance);
		Iterator<ServerData> iosdata = isdata.iterator();
		List<ServerData> s4 = new ArrayList<ServerData>();
		while(iosdata.hasNext()){
			s4.add(iosdata.next());
		}
		List<ServerVO> svo = convert.convertDataTOServerVO(s4);
		return svo;
	}
	
	public List<KMLVO> getKMLsByCountry(String countryName){
		List<KML> kmls = new ArrayList<KML>();
		Iterable<KML> ik = kmlRepository.findProvinceKMLsUsingCountry(countryName);
		Iterator<KML> iok = ik.iterator();
		while(iok.hasNext()){
			kmls.add(iok.next());
		}
		List<KMLVO> kmlvos = convert.convertTOKMLVOList(kmls);
		return kmlvos;
	}

	public List<GeoPointVO> getGeoPointsByProvince(String provinceName){
		provinceName= provinceName+".*";
		List<GeoPoint> gplist = new ArrayList<GeoPoint>();
		Iterable<GeoPoint> igp = gpRepository.findGPUsingProvince(provinceName);
		Iterator<GeoPoint> iogp =igp.iterator();
		while(iogp.hasNext()){
			gplist.add(iogp.next());
		}
		List<GeoPointVO> gpvolist = convert.convertTOGPVOList(gplist);
		
		return gpvolist;
	}

	@Override
	public boolean pointInPolygon(float latitude, float longitude, String polygonName) {
		
		return false;
	}



	@Override
	public boolean pointInPolygon(float latitude, float longitude, List<float[]> polyCorners) {
		  boolean  oddNodes=false;
		  int j = polyCorners.size()-1;
		  for (int i=0; i<polyCorners.size(); i++) {
			  float x1 = polyCorners.get(i)[0];
			  float x2 = polyCorners.get(j)[0];
			  float y1 = polyCorners.get(i)[1];
			  float y2 = polyCorners.get(j)[1];
		    if (y1<longitude && y2>=longitude
		    ||  y2<longitude && y1>=longitude
		    &&  (x1<=latitude || x2<=latitude)) {
		      if (x1+(longitude-y1)/(y2-y1)*(x2-x1)<latitude) {
		        oddNodes=!oddNodes; 
		       }
		     }
		    j=i; 
		  }
		  return oddNodes;
	}
	


}
