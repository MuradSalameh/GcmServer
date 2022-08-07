package tests;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import main.java.hibernate.dao.ExpenseTypeDAO;
import main.java.hibernate.model.ExpenseType;
import main.java.hibernate.utils.SessionUtil;

public class ExpenseTypeDAOTest {

	public static void main(String[] args) {

		Session session = SessionUtil.getSession();
		int id = 4;

		//--------- addExpenseType() Test -----------//

		addTestExpenseType();
		addTestExpenseType();
		addTestExpenseType();
		addTestExpenseType();

		

		//--------- getExpenseTypes() Test to get a List of all expenseTypes in database-----------//

		//getExpenseTypeList();


		
		//--------- deleteExpenseType() Test -----------//

		
		//deleteExpenseTypeTest(id);


		
		//--------- getExpenseType() Test to get one specific expenseType by id -----------//

		//getExpenseTypeTest(id);

		

		//--------- updateExpenseType() Test -----------//

		String newClanNameValue = "BABA";
		updateExpenseTypeTest(id,newClanNameValue);



	}
	
	

	public static void addTestExpenseType() {
		ExpenseType test = new ExpenseType(
				"test", 					// title
				"ttttt");					// desc

		ExpenseTypeDAO.addExpenseType(test);			
	}


	public static void updateExpenseTypeTest(int id, String s) {
		Session session = SessionUtil.getSession();

		//Vorhandenen ExpenseType anhand id aus DB holen
		ExpenseType m = session.get(ExpenseType.class, id);

		// ExpenseType m ClanName wert neu setzen
		m.setExpenseTitle(s);

		//ExpenseType m  in Datenbank updaten
		ExpenseTypeDAO.updateExpenseType(id, m);

		System.out.println(m);
	}

	public static void deleteExpenseTypeTest(int id) {
		ExpenseTypeDAO.deleteExpenseType(id);

		ExpenseType expenseType = ExpenseTypeDAO.getExpenseType(id);
		System.out.println(expenseType);

	}

	public static void getExpenseTypeTest(int id) {
		System.out.println(ExpenseTypeDAO.getExpenseType(id)); 
	}

	public static void getExpenseTypeList() {
		List<ExpenseType> expenseTypes = ExpenseTypeDAO.getExpenseTypes();
		ArrayList<ExpenseType> ol = new ArrayList<ExpenseType>();
	
		for(ExpenseType m : expenseTypes) {
			  ol.add(m);
			  System.out.println(m);
		}
	}



}
