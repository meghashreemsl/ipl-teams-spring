package com.wolken.wolkenapp.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wolken.wolkenapp.dao.TeamDAO;
import com.wolken.wolkenapp.dto.TeamDTO;
import com.wolken.wolkenapp.service.TeamService;

@Component
@RequestMapping("/")
public class IplController {

	@Autowired
	TeamService teamService;

	@RequestMapping("/team.meg")
	public String save(@ModelAttribute TeamDTO dto, HttpServletRequest req) {
		String msg = teamService.validateAndSave(dto);
		System.out.println("inside save ");
		// String msg = dao.save(dto);
		req.setAttribute("msg", msg);
		return "home.jsp";
	}

	@RequestMapping("/getall.meg")
	public String getAll(HttpServletRequest req) {
		List<TeamDTO> teamList = teamService.validateAndGetAll();
		/* List<TeamDTO> teamList = dao.getAll(); */
		for (TeamDTO teamDTO : teamList) {
			System.out.println(teamDTO);
		}

		req.setAttribute("teamList", teamList);
		return "getall.jsp";
	}

	@RequestMapping("/update.meg")

	public String updateTeamNameByHomeground(HttpServletRequest req) {
		String teamName =req.getParameter("teamName");
		String homeground=req.getParameter("homeGround");
		String msg2 = teamService.validateAndUpdate(teamName, homeground);
		// String msg = dao.updateTeamNameByHomeground(teamName, homeground);
		req.setAttribute("msg", msg2);
		return "home.jsp";
	}

	@RequestMapping("/delete.meg")
	public String deleteByTeamName(HttpServletRequest req) {
		
		String teamName = req.getParameter("teamName");
		String msg3 = teamService.validateAndDelete(teamName);
		req.setAttribute("msg", msg3);
		return "home.jsp";
	}

}
