package com.tarena.poll.biz.impl;

import java.util.List;

import com.tarena.poll.biz.BizException;
import com.tarena.poll.biz.IPollBiz;
import com.tarena.poll.dao.IPollDao;
import com.tarena.poll.dao.impl.PollDaoImpl2;
import com.tarena.poll.entity.Statistics;
import com.tarena.poll.entity.TPoll;
import com.tarena.poll.entity.TPollLine;
import com.tarena.poll.entity.TUser;

public class PollBizImpl implements IPollBiz {

	public void deletePoll(int id) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		ipd.deletePoll(id);
		
	}

	public void modifyOverDate(int pollId) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		ipd.modifyOverDate(pollId);
	}

	public void modifyPollStatus(char newStatus, int id) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		ipd.modifyPollStatus(newStatus, id);
	}

	public void savePoll(TPoll poll) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		ipd.savePoll(poll);
	}

	public void savePollLine(TPollLine pollLine) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		ipd.savePollLine(pollLine);
	}

	public List selectPollLineByPollId(int pollId) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		List pollLines = ipd.selectPollLineByPollId(pollId);
		return pollLines;
	}

	public List selectPollsByDate(java.util.Date begin, java.util.Date end) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		List polls = ipd.selectPollsByDate(begin, end);
		return polls;
	}

	public List selectPollsByInfo(int classId, int userId, java.util.Date start, java.util.Date end) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		List polls = ipd.selectPollsByInfo(classId, userId, start, end);
		return polls;
	}

	public List selectPollsByStatus(char status) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		List polls = ipd.selectPollsByStatus(status);
		return polls;
	}

	public void updatePoll(TPoll poll) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		ipd.updatePoll(poll);
	}

	public TPoll selectPollById(int id) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		return ipd.selectPollById(id);
	}

	public Statistics selectStatisticsById(int id) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		return ipd.selectStatisticsById(id);
	}

	public TPollLine selectPollLineById(int id) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		return ipd.selectPollLineById(id);
	}

	public List selectStatisticsByUserName(String name) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		return ipd.selectStatisticsByUserName(name);
	}

	@Override
	public void deleteLastPoll() throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		ipd.deleteLastPoll();
	}

	@Override
	public TPoll getLastPoll() throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		ipd.getLastPoll();
		return ipd.getLastPoll();
	}

	@Override
	public List<TPollLine> selectPollLineByPoll(TPoll poll) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		return ipd.selectPollLineByPoll(poll);
	}

	@Override
	public void delectPollBystatus(Character status) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		ipd.delectPollBystatus(status);
	}

	@Override
	public void delectPollByUser(TUser user) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		ipd.delectPollByUser(user);
		
	}

	@Override
	public void delectLineByPoll(TPoll poll) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		ipd.delectLineByPoll(poll);
	}

	@Override
	public List<TPoll> selectPollsByUser(TUser user) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		return ipd.selectPollsByUser(user);
	}

	@Override
	public List<TPoll> selectPollsByYear(int year) throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		return ipd.selectPollsByYear(year);
	}

	@Override
	public List<TPoll> selectPollsByYearAndMonth(int year, int month)
			throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		return ipd.selectPollsByYearAndMonth(year, month);
	}

	@Override
	public List<TPoll> selectPollsByYearAndQuarter(int year, int quarter)
			throws BizException {
		IPollDao ipd = new PollDaoImpl2();
		return ipd.selectPollsByYearAndQuarter(year, quarter);
	}

}
