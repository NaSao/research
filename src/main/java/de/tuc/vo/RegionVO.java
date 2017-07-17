package de.tuc.vo;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;


@Data
public class RegionVO{
	private Long id;
	private String name;
	private String code;
	
}
