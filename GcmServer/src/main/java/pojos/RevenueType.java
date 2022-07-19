package main.java.pojos;

public class RevenueType {
	private int id;
	private String revenueTypeTitle;
	private String revenueTypeDescription;
	
	public RevenueType(int id, String revenueTypeTitle, String revenueTypeDescription) {
		super();
		this.id = id;
		this.revenueTypeTitle = revenueTypeTitle;
		this.revenueTypeDescription = revenueTypeDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	
}
