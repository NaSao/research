package de.tuc.domain;

import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@NodeEntity
@Data
public class Province extends Entity{
	private String name;
	
	@Relationship(type="in", direction=Relationship.INCOMING)
	private City city;
	@Relationship(type="in", direction=Relationship.OUTGOING)
	private Country country;
	@Relationship(type="shape", direction=Relationship.OUTGOING)
	private KML kml;
}
