package de.tuc.vo;

import lombok.Data;

@Data
public class CountryVO {
	private Long id;
	private String name;
	private String code;
	private String regionCode;
	private String subRegionCode;
}
