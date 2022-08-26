package main.java.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.Expense;
import main.java.hibernate.utils.SessionUtil;

public class ExpenseDAO {
    // database access methods
    
    // add new expense
	public static void addExpense(Expense bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.persist(bean); 
		tx.commit();
		session.close();
	}

	
	// get expense
	public static Expense getExpense(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Expense expense = session.get(Expense.class, id);

		return expense;
	}

	
	// get list of all expenses
	public static List<Expense> getExpenses() {
		Session session = SessionUtil.getSession();
		String hql = "from Expense";
		Query query = session.createQuery(hql);
		List<Expense> expenses = query.list();
		session.close();
		return expenses;
	}

	
	// delete expense
	public static void deleteExpense(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Expense expense = session.get(Expense.class, id);
		session.remove(expense);
		tx.commit();
		session.close();

	}

	
	// update expense
	public static void updateExpense(int id, Expense expense) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Expense old = session.get(Expense.class, id);

		old.setExpenseTitle(expense.getExpenseTitle());
		old.setExpenseDescription(expense.getExpenseDescription());
		old.setAmount(expense.getAmount());
		old.setDate(expense.getDate());
		old.setRecipientName(expense.getRecipientName());


		session.saveOrUpdate(old);
		session.flush();
		tx.commit();
		session.close();
	}

}
