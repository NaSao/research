package de.tuc.vo;

import org.neo4j.ogm.annotation.Relationship;

import de.tuc.domain.City;
import lombok.Data;

@Data
public class ServerVO {
	
	private String geoId;
	private String network;
	private float latitude;
	private float longitude;
	private float isSatelliteProvider;
	private String registeredCountryGeonameId;
	private float isAnonymousProxy;
	private float accuracyRadius;
	private String city;
	private String province;
	private String country;
	private float distance;
}
