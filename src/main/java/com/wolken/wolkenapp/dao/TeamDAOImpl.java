package com.wolken.wolkenapp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import com.wolken.wolkenapp.dto.TeamDTO;

@Component

public class TeamDAOImpl implements TeamDAO {

	Logger logger = Logger.getLogger("TeamDAOImpl");

	@Autowired
	LocalSessionFactoryBean bean;

	public String save(TeamDTO dto) {

		/*
		 * Configuration configuration = bean.getConfiguration();
		 * configuration.configure(); SessionFactory factory =
		 * configuration.buildSessionFactory(); Session session = factory.openSession();
		 * Transaction transaction = session.beginTransaction(); session.save(dto);
		 * transaction.commit(); session.close();
		 */
		// BasicDataSource basicDataSource = new BasicDataSource();

		logger.info("inside save");
		SessionFactory factory = bean.getObject();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(dto);
		transaction.commit();
		session.close();
		return "data added";
	}

	public List<TeamDTO> getAll() {

		logger.info("inside getall");
		SessionFactory factory = bean.getObject();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("selectAll");
		List<TeamDTO> dtos = query.list();
		//query.executeUpdate();
//		transaction.commit();
		session.close();
		return dtos;

	}

	public String updateTeamNameByHomeground(String teamName, String homeground) {

		logger.info("inside update");
		SessionFactory factory = bean.getObject();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("update");
		query.setParameter("tn", teamName);
		query.setParameter("hg", homeground);
		query.executeUpdate();
		transaction.commit();
		session.close();
		return "data updated";
	}

	public String deleteByTeamName(String teamName) {

		logger.info("inside delete");
		SessionFactory factory = bean.getObject();
		Session session = factory.openSession();
		Query query = session.createQuery("delete from TeamDTO tm where tm.teamName= ' " + teamName + " ' ");
		Transaction transaction = session.beginTransaction();
		query.executeUpdate();
		transaction.commit();
		session.close();
		return "data deleted";
	}

}
