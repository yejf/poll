package com.tarena.poll.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**************************
 * 调查详情
 * @author yejf
 *
 */
@Entity
@Table(name="TBL_TPOLLLINE")
public class TPollLine  implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* 主键 */
	private Integer id;
	/* 分数集 */ 
	private String scores;
	
	/* Document me */
	private float avgScore;
	 
	private String q1;
	
	private String q2;
	
	/* Y有效  N无效 */
	private char isValid;
	 
	/* 所属的调查 */
	private TPoll poll;
	

	public TPollLine() {
	}
	
	@Column
	public String getQ1() {
		return q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}
	@Column
	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column
	public String getScores() {
		return scores;
	}

	public void setScores(String scores) {
		this.scores = scores;
	}

	@Column
	public float getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(float avgScore) {
		this.avgScore = avgScore;
	}
	@Column
	public char getIsValid() {
		return isValid;
	}
	
	public void setIsValid(char isValid) {
		this.isValid = isValid;
	}
	@ManyToOne
	@JoinColumn(name="poll_id",nullable=false)
	public TPoll getPoll() {
		return poll;
	}

	public void setPoll(TPoll poll) {
		this.poll = poll;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TPollLine [id=");
		builder.append(id);
		builder.append(", scores=");
		builder.append(scores);
		builder.append(", avgScore=");
		builder.append(avgScore);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append(", poll=");
		builder.append(poll);
		builder.append("]");
		return builder.toString();
	}


	
	
	
	
}