package de.tuc;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import de.tuc.controller.Neo4jController;
import de.tuc.vo.ServerVO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ResearchApplication.class)
@WebAppConfiguration
public class ResearchApplicationTests {

	@Autowired private ApplicationContext ctx;
	@Autowired private Neo4jController nc;
	
	@Test
	public void contextLoads() {
		String applicationEnvironment = System.getProperty("application.properties");
		List<ServerVO> svo = nc.getAllServers("IPV4");
		System.out.println(svo.size());
//		List<CityVO> cVO = nc.getCitysByProvince("Hamburg");
//		System.out.println(cVO.size()+"++++++++++++");
		
		
//		List<ProvinceVO> pVO = nc.getProvincesByCountry("Germany");
//		System.out.println(pVO.size()+"++++++++++++");
		
//		List<CountryVO> coVO = ns.getCountrys("Eastern Europe");
//		System.out.println(coVO.size()+"++++++++++++");
//		
//		Log4J2Configuration log4J2PropertiesConf=new Log4J2Configuration();
//        log4J2PropertiesConf.performSomeTask();
		
//		List<ServerVO> svo = ss.getAllWeb();
//		System.out.println(svo.size()+"++++++++++++");
	}

}
