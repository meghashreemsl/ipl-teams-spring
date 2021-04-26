package com.wolken.wolkenapp.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.wolken.wolkenapp.dao.TeamDAO;
import com.wolken.wolkenapp.dto.TeamDTO;
import com.wolken.wolkenapp.exception.MyException;

@Component
public class TeamServiceImpl  implements TeamService{
	
	Logger logger = Logger.getLogger("TeamServiceImpl");
	
	@Autowired 
	LocalSessionFactoryBean bean;

	@Autowired
	TeamDAO dao;
	
	public String validateAndSave(TeamDTO dto) {
		
		logger.info("validate and save");
		if(dto.getTeamId()>0) {
			if(dto.getTeamName()!=null) {
				if(dto.getHomeGround()!=null) {
					if(dto.getCaptain()!=null) {
						dao.save(dto);
					}
					else {
						System.out.println("captain name is invalid ");
					}
				}
				else {
					System.out.println("home ground is invalid");
				}
			}else {
				System.out.println("team name is invalid");
			}
			
		}else {
			System.out.println("team id is invalid");
		}
		return "data saved";
	}

	public List<TeamDTO> validateAndGetAll() {
		System.out.println("inside validateAndGetAll()");
		return dao.getAll();
	}

	public String validateAndUpdate(String teamName, String homeground)  {
		
		logger.info("validate and update");
	
		if(teamName!=null) {
			if(homeground!=null) {
				dao.updateTeamNameByHomeground(teamName, homeground);
			}
			else
			{
				System.out.println("homeground is invalid");
			}
		}
		else
		{
			System.out.println("team name is invalid");
		}
		return "data updated";
	}

	public String validateAndDelete(String teamName) {
		
		logger.info("validate and delete");
		
		if(teamName!=null) {
			dao.deleteByTeamName(teamName);
		}
		else 
		{
			System.out.println("team id is invalid");
		}
		return "data deleted";
	}
}
