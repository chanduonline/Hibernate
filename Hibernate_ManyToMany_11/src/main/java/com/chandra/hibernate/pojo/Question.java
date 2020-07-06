package com.chandra.hibernate.pojo;

import java.util.List;  
import javax.persistence.*;    

@Entity  
@Table(name="QUESTION_MANY2MANY")  
public class Question {    
@Id  
@GeneratedValue(strategy=GenerationType.AUTO)  
private int id;    
private String qname;   

@ManyToMany(targetEntity = Answer.class, cascade = { CascadeType.ALL })  
@JoinTable(name = "QUESTION_ANSWER",   
        joinColumns = { @JoinColumn(name = "q_id") },   
        inverseJoinColumns = { @JoinColumn(name = "ans_id") })  
private List<Answer> answers;  

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
public List<Answer> getAnswers() {  
return answers;  
}  
public void setAnswers(List<Answer> answers) {  
this.answers = answers;  
}      
}  