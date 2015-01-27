package com.tarena.poll.dao;

import java.util.List;

import com.tarena.poll.entity.TClassType;

/**
 *本来用来演示
 *author datong
 */
public interface IClassTypeDao {
	void SaveType(TClassType classType);
	TClassType getType(Integer id);
	TClassType getTypeByName(String name);
	List<TClassType> getTypes();
}
