package de.tuc.domain;

import org.springframework.data.neo4j.annotation.QueryResult;

import lombok.Data;

@QueryResult
@Data
public class ServerData {
	private ServerIPV4 serverIPV4;
	private ServerIPV6 serverIPV6;
	private String cityName;
	private String provinceName;
	private String countryName;
	private float distance;
}
