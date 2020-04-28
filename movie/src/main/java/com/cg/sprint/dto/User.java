package com.cg.sprint.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="userdetails")
public class User 
{
    @Id
    @Column(name="user_id")
   /* @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="MYSEQ")
    @SequenceGenerator(name="MYSEQ",sequenceName="myseq",allocationSize=1)*/
    String userId;
    String password;
    String name;
    @Column(name="email_id")
    String emailId;
    long phone;
    public User() { }
	public User(String userId, String password, String name, String emailId, long phone)
	{
		this.userId = userId;		this.password = password;		this.name = name;
		this.emailId = emailId;		this.phone = phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
}
