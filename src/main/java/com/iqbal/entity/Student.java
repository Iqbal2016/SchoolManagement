/**
 * 
 */
package com.iqbal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author TCS
 *
 */
@Entity
@Table(name = "student")
public class Student extends BaseEntity {

	@Column(name = "first_name")
	@NotEmpty(message = "*Please provide your name")
	String first_name;
	
	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide your name")
	String last_name;
	
	String class_name;
	
	int roll;
	
	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	String email;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [first_name=" + first_name + ", last_name=" + last_name + ", class_name=" + class_name
				+ ", roll=" + roll + ", email=" + email + "]";
	}

}
