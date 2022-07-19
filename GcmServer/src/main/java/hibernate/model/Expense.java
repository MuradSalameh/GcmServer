package main.java.hibernate.model;

import java.time.LocalDate;

public class Expense {
	private int id;
	private String expenseTitle;
	private String expenseDescription;
	private double amount;
	private LocalDate date;
	private String recipientName;
	private ExpenseType expenseType;
	
	public Expense(int id, String expenseTitle, String expenseDescription, double amount, LocalDate date,
			String recipientName, ExpenseType expenseType) {
		super();
		this.id = id;
		this.expenseTitle = expenseTitle;
		this.expenseDescription = expenseDescription;
		this.amount = amount;
		this.date = date;
		this.recipientName = recipientName;
		this.expenseType = expenseType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpenseTitle() {
		return expenseTitle;
	}

	public void setExpenseTitle(String expenseTitle) {
		this.expenseTitle = expenseTitle;
	}

	public String getExpenseDescription() {
		return expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
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

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public ExpenseType getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(ExpenseType expenseType) {
		this.expenseType = expenseType;
	}
	
	
	

}
