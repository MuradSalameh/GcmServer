package main.java.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import jakarta.xml.bind.annotation.XmlElement;

@XmlRootElement
@Entity
@Table(name = "expense_type")
public class ExpenseType  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "expense_title")
	private String expenseTitle;
	
	@Column(name = "expense_description")
	private String expenseDescription;	
	

	public ExpenseType() {
		super();
	}


	public ExpenseType(String expenseTitle, String expenseDescription) {
		super();
		this.expenseTitle = expenseTitle;
		this.expenseDescription = expenseDescription;
	}

	@XmlElement(name="ExpenseTitle")
	public String getExpenseTitle() {
		return expenseTitle;
	}


	public void setExpenseTitle(String expenseTitle) {
		this.expenseTitle = expenseTitle;
	}


	@XmlElement(name="ExpenseDescription")
	public String getExpenseDescription() {
		return expenseDescription;
	}


	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}
	
	@XmlElement(name="ID",required=true)
	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "\nExpenseType id=" + id 
				+ "\nexpenseTitle=" + expenseTitle 
				+ "\nexpenseDescription=" + expenseDescription
				+ "\n----------------------------------"
				+ "\n";
				
	}
	
	
	
	
	
}
