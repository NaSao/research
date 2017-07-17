package de.tuc.convertor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import de.tuc.domain.City;
import de.tuc.domain.Country;
import de.tuc.domain.GeoPoint;
import de.tuc.domain.KML;
import de.tuc.domain.Province;
import de.tuc.domain.ServerData;
import de.tuc.domain.ServerIPV4;
import de.tuc.domain.ServerIPV6;
import de.tuc.vo.CityVO;
import de.tuc.vo.CountryVO;
import de.tuc.vo.GeoPointVO;
import de.tuc.vo.KMLVO;
import de.tuc.vo.ProvinceVO;
import de.tuc.vo.ServerVO;
@Service
public class CommonConvertor {
	
	 //private Mapper modelMapper = new DozerBeanMapper();
	public ServerVO conver4ToServerVO(ServerIPV4 server){
		ServerVO svo = new ServerVO();
		svo.setGeoId(server.getGeoId());
		svo.setNetwork(server.getNetwork());
		svo.setLatitude(server.getLatitude());
		svo.setLongitude(server.getLongitude());
		svo.setRegisteredCountryGeonameId(server.getRegisteredCountryGeonameId());
		svo.setAccuracyRadius(server.getAccuracyRadius());
		svo.setIsAnonymousProxy(server.getIsAnonymousProxy());
		svo.setIsSatelliteProvider(server.getIsSatelliteProvider());
		return svo;
	}
	
	public ServerVO conver6ToServerVO(ServerIPV6 server){
		ServerVO svo = new ServerVO();
		svo.setGeoId(server.getGeoId());
		svo.setNetwork(server.getNetwork());
		svo.setLatitude(server.getLatitude());
		svo.setLongitude(server.getLongitude());
		svo.setRegisteredCountryGeonameId(server.getRegisteredCountryGeonameId());
		svo.setAccuracyRadius(server.getAccuracyRadius());
		svo.setIsAnonymousProxy(server.getIsAnonymousProxy());
		svo.setIsSatelliteProvider(server.getIsSatelliteProvider());
		return svo;
	}
	
	
	public List<ServerVO> convert4TOServerVO(List<ServerIPV4> sList){
		List<ServerVO> pvoList = new ArrayList<ServerVO>();
		for(ServerIPV4 server : sList){
			ServerVO svo = this.conver4ToServerVO(server);
			pvoList.add(svo);
		}
		return pvoList;
	}
	
	
	public List<ServerVO> convert6TOServerVO(List<ServerIPV6> sList){
		List<ServerVO> pvoList = new ArrayList<ServerVO>();
		for(ServerIPV6 server : sList){
			ServerVO svo = this.conver6ToServerVO(server);
			pvoList.add(svo);
		}
		return pvoList;
	}
	
	public List<ServerVO> convertDataTOServerVO(List<ServerData> sList){
		List<ServerVO> pvoList = new ArrayList<ServerVO>();
		for(ServerData server : sList){
			ServerVO svo = new ServerVO();
			if(server.getServerIPV4() != null){
				svo = this.conver4ToServerVO(server.getServerIPV4());
			}else{
				svo = this.conver6ToServerVO(server.getServerIPV6());
			}
			
			svo.setCity(server.getCityName());
			svo.setProvince(server.getProvinceName());
			svo.setCountry(server.getCountryName());
			svo.setDistance(server.getDistance());
			pvoList.add(svo);
		}
		return pvoList;
	}
	
	 public CityVO convertTOCity(City city){
		 CityVO cvo = new CityVO();
		 cvo.setId(city.getId());
		 cvo.setName(city.getName());
		 cvo.setGeoId(city.getGeoId());
		 return cvo;
	 }
	 
	 
	 public List<CityVO> convertTOCityVOList(List<City> cityList){
		 List<CityVO> cityVOList = new ArrayList<CityVO>();
		 for(City city : cityList){
			 CityVO cityVO = convertTOCity(city);
			 cityVOList.add(cityVO);
		 }
		 return cityVOList;
	 }
	 
	 public ProvinceVO convertTOProvinceVO(Province province){
		 ProvinceVO pvo = new ProvinceVO();
		 pvo.setId(province.getId());
		 pvo.setName(province.getName());
		 return pvo;
	 }
	 
	 public List<ProvinceVO> convertTOProvinceVOList(List<Province> provinceList){
		 List<ProvinceVO> provinceVOList = new ArrayList<ProvinceVO>();
		 for(Province province : provinceList){
			 ProvinceVO provinceVO = convertTOProvinceVO(province);
			 provinceVOList.add(provinceVO);
		 }
		 return provinceVOList;
	 }
	 
	 public CountryVO convertTOCountryVO(Country country){
		 CountryVO cvo = new CountryVO();
		 cvo.setId(country.getId());
		 cvo.setName(country.getName());
		 cvo.setCode(country.getCode());
		 return cvo;
	 }
	 
	 public List<CountryVO> convertTOCountryVOList(List<Country> countryList){
		 List<CountryVO> countryVOList = new ArrayList<CountryVO>();
		 for(Country country : countryList){
			 CountryVO countryVO = convertTOCountryVO(country);
			 countryVOList.add(countryVO);
		 }
		 return countryVOList;
	 }
	 
	 public KMLVO convertTOKMLVO(KML kml){
		 KMLVO kmlvo = new KMLVO();
		 kmlvo.setId(kml.getId());
		 kmlvo.setKml(kml.getKml());
		 return kmlvo;
	 }
	 
	 public List<KMLVO> convertTOKMLVOList(List<KML> kmls){
		 List<KMLVO> kmlVOs = new ArrayList<KMLVO>();
		 for(KML kml : kmls){
			 KMLVO kmlvo = convertTOKMLVO(kml);
			 kmlVOs.add(kmlvo);
		 }
		 return kmlVOs;
	 }
	 
	 public GeoPointVO convertTOGPVO(GeoPoint gp){
		 GeoPointVO gpvo = new GeoPointVO();
		 gpvo.setId(gp.getId());
		 System.out.println(gpvo.getId());
		 gpvo.setLat(gp.getLat());
		 gpvo.setLon(gp.getLon());
		 return gpvo;
	 }
	 
	 public List<GeoPointVO> convertTOGPVOList(List<GeoPoint> gplist){
		 List<GeoPointVO> gpvolist = new ArrayList<GeoPointVO>();
		 for(GeoPoint gp :gplist){
			 GeoPointVO gpvo = convertTOGPVO(gp);
			 gpvolist.add(gpvo);
		 }
		 return gpvolist;
	 }

}
