package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EventDao {

	@PersistenceContext
	private EntityManager em;

	public Event getById(Long id) {
		return this.em.find(Event.class, id);
	}

	public long createNew(Event event) {
		this.em.persist(event);
		return event.getId();
	}
}
