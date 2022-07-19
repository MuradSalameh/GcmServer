package pojos;

import java.time.LocalDate;

public class Revenue {
	private int id;
	private String title;
	private String description;
	private double amount;
	private LocalDate date;
	private Partner partner;
	private RevenueType reventueType;
	
	public Revenue(int id, String title, String description, double amount, LocalDate date, Partner partner,
			RevenueType reventueType) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.partner = partner;
		this.reventueType = reventueType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public RevenueType getReventueType() {
		return reventueType;
	}

	public void setReventueType(RevenueType reventueType) {
		this.reventueType = reventueType;
	}
	
	
	
	

}
