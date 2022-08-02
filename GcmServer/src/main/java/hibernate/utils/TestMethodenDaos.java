package main.java.hibernate.utils;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import main.java.hibernate.dao.MemberDAO;
import main.java.hibernate.model.Member;

public class TestMethodenDaos {
	
	public static void main(String[] args) {
		
		 Session session = SessionUtil.getSession();
	
		 //addTestMember();
		

	
		 /*
		//Member m  mit ID 2 aus Datenbank holen
		Member m = session.get(Member.class, 2);
		// Member m ClanName wert neu setzen
		m.setClanName("djdjdjdjd");
		//Member m  in Datenbank updaten
		MemberDAO.updateMember(2, m);
		
		*/
		
		
		
		
		MemberDAO.deleteMember(9);
		
		
		List<Member> members = MemberDAO.getMembers();
		members.forEach(System.out::println);
		
		
		
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
	
	
	
	

}
