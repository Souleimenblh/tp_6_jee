package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import aeroport.entities.Avion;
import util.JPAutil;

public class AvionDaoImpl implements IAvionDao {
private EntityManager entityManager=JPAutil.getEntityManager("TP5_JEE2");
@Override
public Avion save(Avion p) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(p);
	tx.commit();
	return p;
	}
	@Override
	public List<Avion> avionsParMC(String mc) {
	List<Avion> avios =
	 entityManager.createQuery("select a from Avion a where a.nomAvion like :mc").setParameter("mc", "%"+mc+"%").getResultList();
	 return avios;
	}
	@Override
	public Avion getAvion(Long id) {
	 return entityManager.find(Avion.class, id);
	}
	@Override
	public Avion updateAvion(Avion a) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.merge(a);
	tx.commit();
	return a;
	}
	@Override
	public void deleteAvion(Long id) {
	Avion avion = entityManager.find(Avion.class, id);
	entityManager.getTransaction().begin();
	entityManager.remove(avion);
	entityManager.getTransaction().commit();
	}
	}
