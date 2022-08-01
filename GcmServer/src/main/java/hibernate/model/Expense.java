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
@Table(name = "expense")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "expense_title")
	private String expenseTitle;
	
	@Column(name = "expense_description")
	private String expenseDescription;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "recipient_name")
	private String recipientName;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(
			name="expense_expense_type",
			joinColumns = @JoinColumn( name="expense_id"),
			inverseJoinColumns = @JoinColumn( name="expense_type_id")
			)
	List<ExpenseType> expenseTypes = new ArrayList<>();

	public Expense() {
		super();
	}

	public Expense(String expenseTitle, String expenseDescription, double amount, LocalDate date, String recipientName,
			List<ExpenseType> expenseTypes) {
		super();
		this.expenseTitle = expenseTitle;
		this.expenseDescription = expenseDescription;
		this.amount = amount;
		this.date = date;
		this.recipientName = recipientName;
		this.expenseTypes = expenseTypes;
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

	public List<ExpenseType> getExpenseTypes() {
		return expenseTypes;
	}

	public void setExpenseTypes(List<ExpenseType> expenseTypes) {
		this.expenseTypes = expenseTypes;
	}

	public int getId() {
		return id;
	}
	
	
}
