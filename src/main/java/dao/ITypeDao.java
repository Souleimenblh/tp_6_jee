package dao;

import java.util.List;

import aeroport.entities.Type;

public interface ITypeDao {
public Type save(Type type);
public Type getType(Long id);
public Type updateType(Type type);
public void deleteType(Long id);
public List<Type> getAllTypes();
}