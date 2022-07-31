package main.java.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.ExpenseType;
import main.java.hibernate.utils.SessionUtil;

public class ExpenseTypeDAO {
	

	public static void addExpenseType(ExpenseType bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();		
		 
		session.persist(bean);    // Dafür die add expenseType nicht mehr aufrufen, da direkt im bean gespeichert wird.
		tx.commit();
		session.close();
	}


	public static List<ExpenseType> getExpenseTypes(){
		Session session = SessionUtil.getSession();  
		String hql = "from ExpenseType";
		Query query = session.createQuery(hql);
		List<ExpenseType> expenseTypes =  query.list();		
		session.close();		
		return expenseTypes;
	}

	public static void deleteExpenseType(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		ExpenseType expenseType = session.find(ExpenseType.class, id);
		session.remove(expenseType);
		tx.commit();
		session.close();
		
	}

	public static void updateExpenseType(int id, ExpenseType expenseType){
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		ExpenseType old = session.find(ExpenseType.class, id);
		
		old.setExpenseTitle(expenseType.getExpenseTitle());
		old.setExpenseDescription(expenseType.getExpenseDescription());
		
		tx.commit();
		session.close();		
	}


}
