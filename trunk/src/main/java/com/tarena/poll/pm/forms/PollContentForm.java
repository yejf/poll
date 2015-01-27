package com.tarena.poll.pm.forms;

import org.apache.struts.action.ActionForm;

import com.tarena.poll.entity.TPoll;
import com.tarena.poll.entity.TPollLine;
/**
 * 用来封装pm考评页面的信息
 * @author zhengxh
 *
 */
public class PollContentForm extends ActionForm {
//	private TPollLine pollline;
//
//	public TPollLine getPollline() {
//		return pollline;
//	}
//
//	public void setPollline(TPollLine pollline) {
//		this.pollline = pollline;
//	}
	
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 5110201062902810870L;

	/* 主键 */
	private Integer id;
	 
	/* Document me */
	private int c1;
	 
	/* Document me */
	private int c2;
	 
	/* Document me */
	private int c3;
	
	/* Document me */ 
	private int c4;
	 
	/* Document me */
	private int c5;
	 
	/* Document me */
	private int c6;
	 
	/* Document me */
	private int c7;
	 
	/* Document me */
	private int c8;
	 
	/* Document me */
	private int c9;
	 
	/* Document me */
	private int c10;
	
	/* Document me */ 
	private int c11;
	 
	/* Document me */
	private int c12;
	 
	/* Document me */
	private String q1;
	 
	/* Document me */
	private String q2;
	 
	/* Document me */
	private float avgScore;
	 
	/* Document me */
	private char isValid;
	 
	/* 所属的调查 */
	private TPoll poll;


	/*********************
	 * 第二部份
	 */
	/* Document me */
	private int s1;
	/* Document me */
	private int s2;
	/* Document me */
	private int s3;
	/* Document me */
	private int s4;
	/* Document me */
	private int s5;
	/* Document me */
	private int s6;
	/* Document me */
	private int s7;
	/* Document me */
	private int s8;
	/* Document me */
	private int s9;
	/* Document me */
	private int s10;
	
	
	/**
	 * @return the avgScore
	 */
	public float getAvgScore() {
		return avgScore;
	}

	/**
	 * @param avgScore the avgScore to set
	 */
	public void setAvgScore(float avgScore) {
		this.avgScore = avgScore;
	}

	/**
	 * @return the c1
	 */
	public int getC1() {
		return c1;
	}

	/**
	 * @param c1 the c1 to set
	 */
	public void setC1(int c1) {
		this.c1 = c1;
	}

	/**
	 * @return the c10
	 */
	public int getC10() {
		return c10;
	}

	/**
	 * @param c10 the c10 to set
	 */
	public void setC10(int c10) {
		this.c10 = c10;
	}

	/**
	 * @return the c11
	 */
	public int getC11() {
		return c11;
	}

	/**
	 * @param c11 the c11 to set
	 */
	public void setC11(int c11) {
		this.c11 = c11;
	}

	/**
	 * @return the c12
	 */
	public int getC12() {
		return c12;
	}

	/**
	 * @param c12 the c12 to set
	 */
	public void setC12(int c12) {
		this.c12 = c12;
	}

	/**
	 * @return the c2
	 */
	public int getC2() {
		return c2;
	}

	/**
	 * @param c2 the c2 to set
	 */
	public void setC2(int c2) {
		this.c2 = c2;
	}

	/**
	 * @return the c3
	 */
	public int getC3() {
		return c3;
	}

	/**
	 * @param c3 the c3 to set
	 */
	public void setC3(int c3) {
		this.c3 = c3;
	}

	/**
	 * @return the c4
	 */
	public int getC4() {
		return c4;
	}

	/**
	 * @param c4 the c4 to set
	 */
	public void setC4(int c4) {
		this.c4 = c4;
	}

	/**
	 * @return the c5
	 */
	public int getC5() {
		return c5;
	}

	/**
	 * @param c5 the c5 to set
	 */
	public void setC5(int c5) {
		this.c5 = c5;
	}

	/**
	 * @return the c6
	 */
	public int getC6() {
		return c6;
	}

	/**
	 * @param c6 the c6 to set
	 */
	public void setC6(int c6) {
		this.c6 = c6;
	}

	/**
	 * @return the c7
	 */
	public int getC7() {
		return c7;
	}

	/**
	 * @param c7 the c7 to set
	 */
	public void setC7(int c7) {
		this.c7 = c7;
	}

	/**
	 * @return the c8
	 */
	public int getC8() {
		return c8;
	}

	/**
	 * @param c8 the c8 to set
	 */
	public void setC8(int c8) {
		this.c8 = c8;
	}

	/**
	 * @return the c9
	 */
	public int getC9() {
		return c9;
	}

	/**
	 * @param c9 the c9 to set
	 */
	public void setC9(int c9) {
		this.c9 = c9;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the isValid
	 */
	public char getIsValid() {
		return isValid;
	}

	/**
	 * @param isValid the isValid to set
	 */
	public void setIsValid(char isValid) {
		this.isValid = isValid;
	}

	/**
	 * @return the poll
	 */
	public TPoll getPoll() {
		return poll;
	}

	/**
	 * @param poll the poll to set
	 */
	public void setPoll(TPoll poll) {
		this.poll = poll;
	}

	/**
	 * @return the q1
	 */
	public String getQ1() {
		return q1;
	}

	/**
	 * @param q1 the q1 to set
	 */
	public void setQ1(String q1) {
		this.q1 = q1;
	}

	/**
	 * @return the q2
	 */
	public String getQ2() {
		return q2;
	}

	/**
	 * @param q2 the q2 to set
	 */
	public void setQ2(String q2) {
		this.q2 = q2;
	}

	/**
	 * @return the s1
	 */
	public int getS1() {
		return s1;
	}

	/**
	 * @param s1 the s1 to set
	 */
	public void setS1(int s1) {
		this.s1 = s1;
	}

	/**
	 * @return the s10
	 */
	public int getS10() {
		return s10;
	}

	/**
	 * @param s10 the s10 to set
	 */
	public void setS10(int s10) {
		this.s10 = s10;
	}

	/**
	 * @return the s2
	 */
	public int getS2() {
		return s2;
	}

	/**
	 * @param s2 the s2 to set
	 */
	public void setS2(int s2) {
		this.s2 = s2;
	}

	/**
	 * @return the s3
	 */
	public int getS3() {
		return s3;
	}

	/**
	 * @param s3 the s3 to set
	 */
	public void setS3(int s3) {
		this.s3 = s3;
	}

	/**
	 * @return the s4
	 */
	public int getS4() {
		return s4;
	}

	/**
	 * @param s4 the s4 to set
	 */
	public void setS4(int s4) {
		this.s4 = s4;
	}

	/**
	 * @return the s5
	 */
	public int getS5() {
		return s5;
	}

	/**
	 * @param s5 the s5 to set
	 */
	public void setS5(int s5) {
		this.s5 = s5;
	}

	/**
	 * @return the s6
	 */
	public int getS6() {
		return s6;
	}

	/**
	 * @param s6 the s6 to set
	 */
	public void setS6(int s6) {
		this.s6 = s6;
	}

	/**
	 * @return the s7
	 */
	public int getS7() {
		return s7;
	}

	/**
	 * @param s7 the s7 to set
	 */
	public void setS7(int s7) {
		this.s7 = s7;
	}

	/**
	 * @return the s8
	 */
	public int getS8() {
		return s8;
	}

	/**
	 * @param s8 the s8 to set
	 */
	public void setS8(int s8) {
		this.s8 = s8;
	}

	/**
	 * @return the s9
	 */
	public int getS9() {
		return s9;
	}

	/**
	 * @param s9 the s9 to set
	 */
	public void setS9(int s9) {
		this.s9 = s9;
	}

	
}
