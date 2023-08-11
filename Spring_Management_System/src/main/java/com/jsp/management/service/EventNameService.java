package com.jsp.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.management.dao.EventNameDao;
import com.jsp.management.dto.EventName;

@Component
public class EventNameService {
	@Autowired
	EventNameDao eventNameDao;
	
	public EventName saveEventName (EventName eventName) {
		return eventNameDao.saveEventName(eventName);
	}
	public List<EventName> viewAllEventNames(){
		return eventNameDao.viewAllEventNames();
	}
public boolean deleteUserById(int id) {
	return eventNameDao.deleteEventNameById(id);
	
}
public EventName updateEventNameById(int id, EventName eventName) {
	return eventNameDao.updateEventNameById(id, eventName);
	
}
public EventName getEventNameById(int id) {
	return eventNameDao.getEventNameById(id);
}
}
