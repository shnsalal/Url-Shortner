package com.darkroom.main.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Url {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	
	@NotNull
	private String originalUrl;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdDate = new Date();
	
	@NotNull
	@Temporal(value = TemporalType.DATE)
	private Date expiresDate;
	
	public Url() {
		
	}

	public Url(long id, String originalUrl, Date createdDate, Date expiresDate) {
		this.id = id;
		this.originalUrl = originalUrl;
		this.createdDate = createdDate;
		this.expiresDate = expiresDate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getExpiresDate() {
		return expiresDate;
	}
	public void setExpiresDate(Date expiresDate) {
		this.expiresDate = expiresDate;
	} 
}
