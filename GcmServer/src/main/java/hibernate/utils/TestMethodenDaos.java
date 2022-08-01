package main.java.hibernate.utils;

import java.time.LocalDate;
import java.util.List;

import main.java.hibernate.dao.MemberDAO;
import main.java.hibernate.model.Member;

public class TestMethodenDaos {
	
	public static void main(String[] args) {
		
		
	/*
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
		
		
		test.setClanName("UpdateTest");
		MemberDAO.updateMember(1, test);
		
		*/
		//MemberDAO.deleteMember(5);
		
		List<Member> members = MemberDAO.getMembers();
		members.forEach(System.out::println);
		
		
		
	}
	
	

}
