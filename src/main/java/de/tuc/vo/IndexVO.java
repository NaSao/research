package de.tuc.vo;

import java.util.List;

import lombok.Data;

@Data
public class IndexVO {
	private int serverCount;
	private int cityCount;
	private int likeCount;
	private List<ServerVO> serverVOs;
	private List<CountryVO> countryVOs;
}
