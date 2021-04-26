package com.wolken.wolkenapp.dao;

import java.util.List;

import com.wolken.wolkenapp.dto.TeamDTO;


public interface TeamDAO {
	
	public String save(TeamDTO dto);
	 public  List<TeamDTO> getAll();
	 public String updateTeamNameByHomeground(String teamName, String homeground);
	public String deleteByTeamName(String teamName);	

}
