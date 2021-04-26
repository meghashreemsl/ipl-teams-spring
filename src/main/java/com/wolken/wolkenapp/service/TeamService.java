package com.wolken.wolkenapp.service;

import java.util.List;

import com.wolken.wolkenapp.dto.TeamDTO;

public interface TeamService {
	
public String validateAndSave(TeamDTO dto);
public List<TeamDTO> validateAndGetAll();
public String validateAndUpdate(String teamName,String homeground);
public String validateAndDelete( String teamName);

}
