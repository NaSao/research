package de.tuc.domain;

import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@NodeEntity
@Data
public class City extends Entity{
	private String name;
	private String geoId;
	
	
	@Relationship(type="route", direction=Relationship.INCOMING)
	private Set<ServerIPV4> server;
	@Relationship(type="in", direction=Relationship.OUTGOING)
	private Province province;
	
	
}
