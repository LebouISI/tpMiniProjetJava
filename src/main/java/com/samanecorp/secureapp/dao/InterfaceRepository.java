package com.samanecorp.secureapp.dao;

import java.util.List;

public interface InterfaceRepository<T> {
	
	public boolean save(T t);
	public boolean delete(long id,T t);
	public boolean update(T t);
	public List<T> list(T t);
	public T get(long id,T t);

}
