package dao;

import domain.Trainer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class TrainerDao {

	@PersistenceContext
	private EntityManager em;

	public Long addTrainer(String name, String surname, String phoneNumber, String mail) {
		Trainer trainer = new Trainer();
		trainer.setName(name);
		trainer.setSurname(surname);
		trainer.setPhoneNumber(phoneNumber);
		trainer.setMail(mail);
		this.em.persist(trainer);
		return trainer.getId();
	}

	public void deleteTrainer(Long id) {
		final Trainer trainer = em.find(Trainer.class, id);
		if (trainer != null) {
			em.remove(trainer);
		}
	}

	public List<Trainer> findAll() {
		final Query query = em.createQuery("SELECT t FROM Trainer t");
		return query.getResultList();
	}
}
