package tests;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import main.java.hibernate.dao.RevenueTypeDAO;
import main.java.hibernate.model.RevenueType;
import main.java.hibernate.utils.SessionUtil;

public class RevenueTypeDAOTest {

	public static void main(String[] args) {

		Session session = SessionUtil.getSession();
		int id = 2;
		int id2 = 5;
		int id3 = 5;

		//--------- addRevenueType() Test -----------//

//		addTestRevenueType();
//		addTestRevenueType();
//		addTestRevenueType();
//		addTestRevenueType();
		
		
		//--------- getRevenueTypes() Test to get a List of all revenueTypes in database-----------//

//		getRevenueTypeList();


		
		//--------- deleteRevenueType() Test -----------//

//		deleteRevenueTypeTest(id);


		
		//--------- getRevenueType() Test to get one specific revenueType by id -----------//

		//getRevenueTypeTest(id);



		//--------- updateRevenueType() Test -----------//

//		String s = "BOBO Product Placement";
//		updateRevenueTypeTest(id,s);



	}
	
	

	public static void addTestRevenueType() {
		RevenueType test = new RevenueType(
				"test", 					// title
				"ttttt", 					// desc
				null);						// revenues

		RevenueTypeDAO.addRevenueType(test);			
	}


	public static void updateRevenueTypeTest(int id, String s) {
		Session session = SessionUtil.getSession();

		//Vorhandenen RevenueType anhand id aus DB holen
		RevenueType m = session.get(RevenueType.class, id);

		// RevenueType m ClanName wert neu setzen
		m.setRevenueTypeTitle(s);

		//RevenueType m  in Datenbank updaten
		RevenueTypeDAO.updateRevenueType(id, m);

		System.out.println(m);
	}

	public static void deleteRevenueTypeTest(int id) {
		RevenueTypeDAO.deleteRevenueType(id);

		RevenueType revenueType = RevenueTypeDAO.getRevenueType(id);
		System.out.println(revenueType);

	}

	public static void getRevenueTypeTest(int id) {
		System.out.println(RevenueTypeDAO.getRevenueType(id)); 
	}

	public static void getRevenueTypeList() {
		List<RevenueType> revenueTypes = RevenueTypeDAO.getRevenueTypes();
		ArrayList<RevenueType> ol = new ArrayList<RevenueType>();
	
		for(RevenueType m : revenueTypes) {
			  ol.add(m);
			  System.out.println(m);
		}
	}



}
