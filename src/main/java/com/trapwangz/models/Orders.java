package com.trapwangz.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer comboChoice;
	
	private String flavorChoice;
	
	public String sideChoice;
	
	public String drinkChoice;
	
	@Size(max = 500, message = "Please limit your comments to 500 characters.")
	private String notes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public Orders() {}
	
	public Orders(Integer comboChoice, String flavorChoice, String sideChoice, String drinkChoice) {
		this.comboChoice = comboChoice;
		this.flavorChoice = flavorChoice;
		this.sideChoice = sideChoice;
		this.drinkChoice = drinkChoice;
	}
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdated() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getComboChoice() {
		return comboChoice;
	}
	
	public void setComboChoice(Integer comboChoice) {
		this.comboChoice = comboChoice;
	}
		
	public String getFlavorChoice() {
		return flavorChoice;
	}

	public void setFlavorChoice(String flavorChoice) {
		this.flavorChoice = flavorChoice;
	}	

	public String getSideChoice() {
		return sideChoice;
	}

	public void setSideChoice(String sideChoice) {
		this.sideChoice = sideChoice;
	}

	public String getDrinkChoice() {
		return drinkChoice;
	}

	public void setDrinkChoice(String drinkChoice) {
		this.drinkChoice = drinkChoice;
	}

	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}	

}
