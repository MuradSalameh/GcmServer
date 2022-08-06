package tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import main.java.hibernate.dao.MemberDAO;
import main.java.hibernate.model.Member;
import main.java.hibernate.utils.SessionUtil;

public class MemberDAOTest {

	public static void main(String[] args) {

		Session session = SessionUtil.getSession();
		int id = 5;

		//--------- addMember() Test -----------//

		//addTestMember();


		//--------- getMember() Test to get one specific member by id -----------//

		//getMemberTest(id);



		//--------- getMembers() Test to get a List of all members in database-----------//

		getMemberList();



		//--------- updateMember() Test -----------//

		//String newClanNameValue = "BOBO";
		//updateMemberTest(id,newClanNameValue);


		//--------- deleteMember() Test -----------//

		//deleteMemberTest(id);


	}
	
	

	public static void addTestMember() {
		Member test = new Member(
				"test", 					// clan name
				"ttttt", 					// clan id
				"tttttt 1", 				// real name
				"44", 						// address
				"1160", 					// adress post code
				"Vienna", 					// city
				"Austria", 					// country
				"ulli@email.com", 			// mail
				"+43 677 678 643 44", 		// phone number
				null, 						// role
				null, 						// socials
				null, 						// games
				null,						// events
				LocalDate.of(1981, 4, 11), 	// birthday
				null);						// teams

		MemberDAO.addMember(test);			
	}


	public static void updateMemberTest(int id, String s) {
		Session session = SessionUtil.getSession();

		//Vorhandenen Member anhand id aus DB holen
		Member m = session.get(Member.class, id);

		// Member m ClanName wert neu setzen
		m.setClanName(s);

		//Member m  in Datenbank updaten
		MemberDAO.updateMember(id, m);

		System.out.println(m);
	}

	public static void deleteMemberTest(int id) {
		MemberDAO.deleteMember(id);

		Member member = MemberDAO.getMember(id);
		System.out.println(member);

	}

	public static void getMemberTest(int id) {
		System.out.println(MemberDAO.getMember(id)); 
	}

	public static void getMemberList() {
		List<Member> members = MemberDAO.getMembers();
		ArrayList<Member> ol = new ArrayList<Member>();
	
		for(Member m : members) {
			  ol.add(m);
			  System.out.println(m);
		}
	}



}
