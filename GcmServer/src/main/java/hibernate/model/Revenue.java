package main.java.hibernate.model;

import java.time.LocalDate;
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
@Table(name = "revenue")
public class Revenue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "revenue_title")
	private String revenueTitle;
	
	@Column(name = "revenue_description")
	private String revenueDescription;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "partner")
	private Partner partner;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(
			name="revenue_revenue_type",
			joinColumns = @JoinColumn( name="revenue_id"),
			inverseJoinColumns = @JoinColumn( name="revenue_type_id")
			)
	List<RevenueType> revenueTypes = new ArrayList<>();

	public Revenue() {
		super();
	}

	public Revenue(String revenueTitle, String revenueDescription, double amount, LocalDate date, Partner partner,
			List<RevenueType> revenueTypes) {
		super();
		this.revenueTitle = revenueTitle;
		this.revenueDescription = revenueDescription;
		this.amount = amount;
		this.date = date;
		this.partner = partner;
		this.revenueTypes = revenueTypes;
	}

	public String getRevenueTitle() {
		return revenueTitle;
	}

	public void setRevenueTitle(String revenueTitle) {
		this.revenueTitle = revenueTitle;
	}

	public String getRevenueDescription() {
		return revenueDescription;
	}

	public void setRevenueDescription(String revenueDescription) {
		this.revenueDescription = revenueDescription;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public List<RevenueType> getRevenueTypes() {
		return revenueTypes;
	}

	public void setRevenueTypes(List<RevenueType> revenueTypes) {
		this.revenueTypes = revenueTypes;
	}

	public int getId() {
		return id;
	}
	
	

}
