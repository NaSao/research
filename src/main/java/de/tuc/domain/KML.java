package de.tuc.domain;

import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@NodeEntity
@Data
public class KML extends Entity{
	private String kml;
	@Relationship(type="shape", direction=Relationship.INCOMING)
	private Province province;
}
