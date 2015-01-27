package com.tarena.poll.dao;

import com.tarena.poll.biz.BizException;
import com.tarena.poll.entity.Statistics;
import com.tarena.poll.entity.TPoll;
import com.tarena.poll.entity.TUser;

import java.util.List;
import java.util.Date;
import com.tarena.poll.entity.TPollLine;

public interface IPollDao {
 
	/*******************************************
	 * 持久化 调查  [对应 激活调查]
	 * @param poll  
	 * @throws DaoException 
	 */
	public abstract void savePoll(TPoll poll) throws DaoException;
	
	/*****************************************
	 * 关闭调查时，把当前的系统时间更新到 poll表中对应
	 * 记录的 over_date 列
	 * @param pollId 关闭的调查
	 * @throws DaoException
	 */
	public abstract void modifyOverDate(int pollId) throws DaoException;
	
	/*********************************
	 * 更新调查的状态
	 * @param newStatus
	 * @param id
	 * @throws DaoException
	 */
	public abstract void modifyPollStatus(char newStatus, int id) 
													throws DaoException;
	
	/**********************************
	 * 更新调查的信息
	 * @param poll
	 */
	public abstract void updatePoll(TPoll poll) throws DaoException;
	
	/**************************************
	 * 删除调查
	 * @param id
	 * @throws DaoException
	 */
	public abstract void deletePoll(int id) throws DaoException;
	
	/********************************************
	 * 依据条件查询调查信息; [要求只查到 "审核" 过的调查]
	 * @param classId  班级ID
	 * @param userId   用户ID
	 * @param start  开始时间
	 * @param end	结束时间
	 * @return
	 * @throws DaoException
	 */
	public abstract List selectPollsByInfo(int classId, int userId, 
										Date start, Date end) 
										throws DaoException;
	
	/***************************
	 * 只依据日期来查询 调查
	 * @param begin
	 * @param end
	 * @return
	 * @throws DaoException
	 */
	public abstract List selectPollsByDate(Date begin, Date end) throws DaoException;
	
	/*************************************
	 * 根据 "状态" 来查询 调查
	 * @param status
	 * @return
	 * @throws DaoException
	 */
	public abstract List selectPollsByStatus(char status)throws DaoException;
	
	/********************************
	 * 持久化 所有的 调查项，在PMO 审核时使用
	 * @param pollLine
	 * @throws DaoException
	 */
	public abstract void savePollLine(TPollLine pollLine)throws DaoException;
	
	/***************************************
	 * 根据调查ID 来找出它的 "明细"
	 * @param pollId
	 * @return
	 * @throws DaoException
	 */
	public abstract List selectPollLineByPollId(int pollId)throws DaoException;
	/***************************************
	 * 根据调查ID 来找出TPoll
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public abstract TPoll selectPollById(int id) throws DaoException;
	/***************************************
	 * 根据调查ID 来找出Statistics,用在查看某条调查的明细
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public abstract Statistics selectStatisticsById(int id) throws DaoException;
	/***************************************
	 * 根据TPollLine的ID 来找出TPollLine，用在查看某条具体的调查
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public abstract TPollLine selectPollLineById(int id) throws DaoException;
	
	/***************************************
	 * 根据PM的user_name 来找出该PM所有的TPoll
	 * @param user_name
	 * @return
	 * @throws DaoException
	 */
	public abstract List selectStatisticsByUserName(String name) throws DaoException;
	
	/***********3.2新增*********************
	 * 删除ID最大的poll
	 * @return
	 * @throws DaoException
	 */
	public abstract void deleteLastPoll() throws DaoException;
	/***********3.2新增*********************
	 * 得到ID最大的poll
	 * @return
	 * @throws DaoException
	 */
	public abstract TPoll getLastPoll() throws DaoException;
	/***********3.2新增*********************
	 * 根据poll拿polllines
	 * @return
	 * @throws DaoException
	 */
	public abstract List<TPollLine> selectPollLineByPoll(TPoll poll) throws DaoException;
	/***********3.2新增*********************
	 * 根据status删除poll
	 * @return
	 * @throws DaoException
	 */
	public abstract void delectPollBystatus(Character status) throws DaoException;
	/***********3.2新增*********************
	 * 根据user删除poll
	 * @return
	 * @throws DaoException
	 */
	public abstract void delectPollByUser(TUser user) throws DaoException;
	/***********3.2新增*********************
	 * 根据poll删除line
	 * @return
	 * @throws DaoException
	 */
	public abstract void delectLineByPoll(TPoll poll) throws DaoException;
	/***********3.2新增*********************
	 * 根据user拿polls
	 * @return
	 * @throws DaoException
	 */
	public abstract List<TPoll> selectPollsByUser(TUser user) throws DaoException;
	/***********3.2新增*********************
	 * 根据user拿polls
	 * @return
	 * @throws DaoException
	 */
	public abstract List<TPoll> selectPollsByYear(int year) throws DaoException;

	/***********3.2新增*********************
	 * 根据year拿polls
	 * @return
	 * @throws DaoException
	 */
	public abstract List<TPoll> selectPollsByYearAndMonth(int year,int month) throws DaoException;
	/***********3.2新增*********************
	 * 根据year month拿polls
	 * @return
	 * @throws DaoException
	 */
	public abstract List<TPoll> selectPollsByYearAndQuarter(int year,int quarter) throws DaoException;
}
 
