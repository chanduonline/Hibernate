package com.chandra.hibernate.pojo;

import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTION_LIST")
public class Question {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	private String qname;
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "ANSWERS_LIST", joinColumns = @JoinColumn(name = "A_ID"))
	private List<String> answers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	
	
	
}
