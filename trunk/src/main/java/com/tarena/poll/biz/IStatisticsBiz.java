package com.tarena.poll.biz;

import java.util.List;

import com.tarena.poll.entity.Statistics;

public interface IStatisticsBiz {
 
	/*******************
	 * 统计 月报表
	 * @param year
	 * @param month
	 * @return
	 */
	public abstract List<Statistics> getStatisticsByYMD(String year, String month) throws BizException;
	
	/**************
	 * 统计季报
	 * @param year
	 * @param quarter
	 * @return
	 */
	public abstract List<Statistics> getStatisticsByQuarter(String year, int quarter) throws BizException;
	
	/**************
	 * 统计 年报
	 * @param year
	 * @return
	 */
	public abstract List<Statistics> getStatisticsByYear(String year) throws BizException;
}
 
