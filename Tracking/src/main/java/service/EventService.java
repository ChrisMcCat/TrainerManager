package service;

import dao.EventDao;
import domain.Event;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EventService {

	@Inject
	private EventDao eventDao;

	public long addEvent(String time) {
		Event event = new Event();
		event.setTime(time);
		return this.eventDao.createNew(event);
	}
}
