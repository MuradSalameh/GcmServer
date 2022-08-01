package main.java.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "revenue_type")
public class RevenueType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "revenue_type_title")
	private String revenueTypeTitle;
	
	@Column(name = "revenue_type_description")
	private String revenueTypeDescription;
	
	//join table for revenue
		@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
		@JoinTable(
				name="revenueType_revenue",
				joinColumns = @JoinColumn( name="revenueType_id"),
				inverseJoinColumns = @JoinColumn( name="revenue_id")
				)
		List<Revenue> revenues = new ArrayList<>();

	public RevenueType() {
		super();
	}

	public RevenueType(String revenueTypeTitle, String revenueTypeDescription, List<Revenue> revenues) {
		super();
		this.revenueTypeTitle = revenueTypeTitle;
		this.revenueTypeDescription = revenueTypeDescription;
		this.revenues = revenues;
	}

	public String getRevenueTypeTitle() {
		return revenueTypeTitle;
	}

	public void setRevenueTypeTitle(String revenueTypeTitle) {
		this.revenueTypeTitle = revenueTypeTitle;
	}

	public String getRevenueTypeDescription() {
		return revenueTypeDescription;
	}

	public void setRevenueTypeDescription(String revenueTypeDescription) {
		this.revenueTypeDescription = revenueTypeDescription;
	}

	public List<Revenue> getRevenues() {
		return revenues;
	}

	public void setRevenues(List<Revenue> revenues) {
		this.revenues = revenues;
	}

	public int getId() {
		return id;
	}

	
	
}
