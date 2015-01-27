package com.tarena.poll.dao;

import java.util.List;

import com.tarena.poll.entity.TPollTemplate;

/**
 *本来用来演示
 *author datong
 */
public interface IpollTemplateDao {
	void saveTemplate(TPollTemplate template);
	List<TPollTemplate> selectTemplateByType(int type);
	List<TPollTemplate> selectAll();
	void modifyAllClose();
	void modifyByIdAndType(int id,int type);
	TPollTemplate selectById(int id);
}
