package com.jsp.management.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.management.dto.EventName;
import com.jsp.management.dto.User;


@Component
public class EventNameDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

//		 to save Swim
	public EventName saveEventName(EventName eventName) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(eventName!=null) {
			entityTransaction.begin();
			entityManager.persist(eventName);
			entityTransaction.commit();
			return eventName;
		}else {
				return null;
			}
			
		}

	public List<EventName> viewAllEventNames(){
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		String sql="SELECT s FROM User s";
		Query query=entityManager.createQuery(sql);
		return query.getResultList();
		
	}
	//to deleteSwim by id
	public boolean deleteEventNameById(int id) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		EventName eventName=entityManager.find(EventName.class, id);
		if(eventName!=null) {
			entityTransaction.begin();
			entityManager.remove(eventName);
			entityTransaction.commit();
			return true;
			
		}else {
			return false;
		}
	}
	//to updateSwim by id
	public EventName updateEventNameById(int id, EventName eventName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EventName eventName2 = entityManager.find(EventName.class, id);
		if (eventName2!= null) {
			entityTransaction.begin();
			entityManager.merge(eventName);
			entityTransaction.commit();
			return eventName;
		} else {
			return null;
		}
	}
//	to get EventName by id
	public EventName getEventNameById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EventName u = entityManager.find(EventName.class, id);
		return u;
	}

}
