package de.tuc.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@NodeEntity
@Data
public class GeoPoint extends Entity{
	private float lat;
	private float lon;
	@Relationship(type="shape", direction=Relationship.INCOMING)
	private Province province;
}
