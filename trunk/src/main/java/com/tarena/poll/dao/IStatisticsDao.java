package com.tarena.poll.dao;

import java.util.List;

import com.tarena.poll.entity.Statistics;

/***************************
 * 调查统计 接口
 * @author yejf [Tarena Technology ltd ...]
 * 引用： 以下是MYSQL数据库 有关 DATE_FORMAT函数的用法
<pre>
  DATE_FORMAT(date,format) 
	根据format字符串格式化date值。下列修饰符可以被用在format字符串中： 
	%M 月名字(January……December) 
	%W 星期名字(Sunday……Saturday) 
	%D 有英语前缀的月份的日期(1st, 2nd, 3rd, 等等。） 
	%Y 年, 数字, 4 位 
	%y 年, 数字, 2 位 
	%a 缩写的星期名字(Sun……Sat) 
	%d 月份中的天数, 数字(00……31) 
	%e 月份中的天数, 数字(0……31) 
	%m 月, 数字(01……12) 
	%c 月, 数字(1……12) 
	%b 缩写的月份名字(Jan……Dec) 
	%j 一年中的天数(001……366) 
	%H 小时(00……23) 
	%k 小时(0……23) 
	%h 小时(01……12) 
	%I 小时(01……12) 
	%l 小时(1……12) 
	%i 分钟, 数字(00……59) 
	%r 时间,12 小时(hh:mm:ss [AP]M) 
	%T 时间,24 小时(hh:mm:ss) 
	%S 秒(00……59) 
	%s 秒(00……59) 
	%p AM或PM 
	%w 一个星期中的天数(0=Sunday ……6=Saturday ） 
	%U 星期(0……52), 这里星期天是星期的第一天 
	%u 星期(0……52), 这里星期一是星期的第一天 
	%% 一个文字“%”。 
	
	所有的其他字符不做解释被复制到结果中。
	
	如：select date_format(now(), '%Y'),date_format(now(),'%c') from poll_table;
	
</pre>

 */
public interface IStatisticsDao {
 
	/***************************************
	 * 完成调查统计
	 * @param year  年份
	 * @param startM  
	 * @param endM
	 * @return
	 * @throws DaoException
	 * sql = "select u.real_name,c.class_name,p.amount,p.valid_amount,p.avg_score,
	  		  p.created_date,p.over_date,p.checked_date,u.user_type,c.class_type,p.id from user_table u,class_table c,poll_table p 
	  		  where u.id = p.user_id and c.id = p.class_id and 
	  		  date_format(p.created_date,'%Y') = '2009' and 
	      	  date_format(p.created_date,'%c') >= '2' and 
	      	  date_format(p.created_date,'%c') <= '2'"
	 */
	public abstract List<Statistics> selectPollByCreatedYM(
							String year, 
							String startM, 
							String endM) throws DaoException ;
	
}















 
