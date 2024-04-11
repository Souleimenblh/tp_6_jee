package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import aeroport.entities.Type;
import util.JPAutil;
public class TypeDaoImpl implements ITypeDao {
// TP6_JEE à replacer par votre persistence unit, consultez votre
//fichier persistence.xml <persistence-unit name="TP6_JEE">
private EntityManager entityManager=JPAutil.getEntityManager("TP5_JEE2");
@Override
public Type save(Type type ) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(type);
tx.commit();
return type;
}
@Override
public Type getType(Long id) {
 return entityManager.find(Type.class, id);
}
@Override
public Type updateType(Type type) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.merge(type);
tx.commit();
return type;
}
@Override
public void deleteType(Long id) {
Type type = entityManager.find(Type.class, id);
entityManager.getTransaction().begin();
entityManager.remove(type);
entityManager.getTransaction().commit();
}
@Override
public List<Type> getAllTypes() {
List<Type> types =
entityManager.createQuery("select c from Type c").getResultList();
return types;
}
}
