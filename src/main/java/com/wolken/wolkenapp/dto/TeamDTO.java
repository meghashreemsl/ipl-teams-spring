package com.wolken.wolkenapp.dto;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NamedQuery(name="selectAll", query="from TeamDTO tm")
@NamedQuery(name="update", query="update TeamDTO tm set tm.teamName=:tn where tm.homeGround=:hg")

		
@Entity
@Getter 
@Setter
@ToString
@Component
@Table(name="ipl_table")
public class TeamDTO {
	
	@Id
	@Column(name="team_id")
	private Integer teamId;
	@Column(name="team_name")
	private String teamName;
	@Column(name="team_homeground")
	private String homeGround;
	@Column(name="team_captain")
	private String captain;

}
