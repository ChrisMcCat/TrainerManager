package dao;

import domain.Action;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ActionDao {

	@PersistenceContext
	private EntityManager em;

	public Action getById(Long id) {
		return this.em.find(Action.class, id);
	}

	public long createNew(Action action) {
		this.em.persist(action);
		return action.getId();
	}
}
