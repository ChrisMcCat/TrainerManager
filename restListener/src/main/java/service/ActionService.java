package service;

import dao.ActionDao;
import domain.Action;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ActionService {

	@Inject
	private ActionDao actionDao;

	public long addAction(String time) {
		Action action = new Action();
		action.setTime(time);
		return this.actionDao.createNew(action);
	}
}
