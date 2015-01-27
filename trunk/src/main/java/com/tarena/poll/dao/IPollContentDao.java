package com.tarena.poll.dao;

import java.util.List;

import com.tarena.poll.entity.TPollContent;

/**
 *本来用来演示
 *author datong
 */
public interface IPollContentDao {
	void savePollContent(TPollContent content);
	List<TPollContent> getByTypeAndStatus(String type,int status);
	List<TPollContent> getByStatus(int status);
	void modifyContentAllClose();
	void modifyContentByIdAndStatus(int id,int status);
	void modifyContentByIdAndName(int id,String name);
	List<String> selectTypes();
	List<TPollContent> getAll();
}
