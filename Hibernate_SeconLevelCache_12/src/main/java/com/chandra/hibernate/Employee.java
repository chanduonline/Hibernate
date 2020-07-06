package com.chandra.hibernate;  
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Table(name="EMPLOYEE_CACHE")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Employee {  
	@Id
private int id;  
private String name;  
private float salary;  
  
public Employee() {}  
public Employee(String name, float salary) {  
    super();  
    this.name = name;  
    this.salary = salary;  
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}  
}  