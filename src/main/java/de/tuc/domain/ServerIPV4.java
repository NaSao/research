package de.tuc.domain;

import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@NodeEntity
@Data
public class ServerIPV4 extends Entity{

	private String geoId;
	private String network;
	private float latitude;
	private float longitude;
	private float isSatelliteProvider;
	private String registeredCountryGeonameId;
	private float isAnonymousProxy;
	private float accuracyRadius;
	
	@Relationship(type="route", direction=Relationship.OUTGOING)
	private City city;
	
}
