package com.restcrud.restcrud.model;

import java.util.Date;

import java.util.*;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="users")



public class UserDTO {
	private String id;
	private String user;
	private String occupation;
	private Boolean completed;
	private Date createdAt;
	private Date updatedAt;
	public void setCreatedAt(Date date) {
		this.createdAt = date;
		
	}
	public Boolean getCompleted() {
		
		return completed;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
	
	
}
