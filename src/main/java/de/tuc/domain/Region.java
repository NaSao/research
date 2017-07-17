package de.tuc.domain;

import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@NodeEntity
@Data
public class Region extends Entity{
	private String name;
	private String code;
	
	@Relationship(type="in", direction=Relationship.INCOMING)
	private Country country;
}
