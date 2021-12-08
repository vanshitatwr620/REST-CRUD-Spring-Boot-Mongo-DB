package com.restcrud.restcrud.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;
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


//@EntityScan
public class UserDTO implements Serializable {
	private String id;
	
	@NotNull(message = "user cannot be null")
	private String user;
	
	@NotNull(message = "occupation cannot be null")
	private String occupation;
	
	@NotNull(message = "completed cannot be null")
	private Boolean completed;
	
	private Date createdAt;
	private Date updatedAt;
	public UserDTO(String user, String occupation, Boolean completed) {
		this.user = user;
		this.occupation = occupation;
		this.completed = completed;
	}
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
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", user=" + user + ", occupation=" + occupation + ", completed=" + completed
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
	
	
	
}
