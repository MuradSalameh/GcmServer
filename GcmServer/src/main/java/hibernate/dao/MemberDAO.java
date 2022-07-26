package main.java.hibernate.dao;

import main.java.hibernate.model.Member;
import main.java.hibernate.utils.SessionUtil;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MemberDAO {

	public void addMember(Member bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();
		addMember(session,bean);    
		tx.commit();
		session.close();
	}

	private void addMember(Session session, Member bean){
		Member Member = new Member();

		Member.setFirstName(bean.getFirstName());
		Member.setLastName(bean.getLastName());
		Member.setAddressStreet(bean.getAddressStreet());
		Member.setAddressNumber(bean.getAddressNumber());
		Member.setAddressPostCode(bean.getAddressPostCode());
		Member.setAddressCity(bean.getAddressCity());
		Member.setCountry(bean.getCountry());
		Member.setEmail(bean.getEmail());
		Member.setPhoneNumber(bean.getPhoneNumber());
		Member.setRoles(bean.getRoles());
		Member.setSocials(bean.getSocials());
		Member.setGames(bean.getGames());
		Member.setBirthday(bean.getBirthday());
		Member.setTeams(bean.getTeams());

		session.persist(Member);
	}

	public List<Member> getMembers(){
		Session session = SessionUtil.getSession();  
		String hql = "from Member";
		Query query = session.createQuery(hql);
		List<Member> Members =  query.list();
		session.close();
		return Members;
	}

	public int deleteMember(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from Member where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id",id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}

	public int updateMember(int id, Member member){
		if(id <=0)  
			return 0;  
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update Member "
				+ "set first_name = :first_name, "
				+ "last_name = :last_name, "
				+ "address_street = :address_street, "
				+ "address_number = :address_number, "
				+ "address_postcode = :address_postcode, "
				+ "address_city = :address_city, "
				+ "country = :country, "
				+ "email = :email, "
				+ "phone_number = :phone_number, "
				+ "roles = :roles, "
				+ "socials = :socials, "
				+ "games = :games, "
				+ "birtday = :birthday, "
				+ "teams = :teams "				
				+ "where id = :id";
		
		Query query = session.createQuery(hql);
		
		query.setParameter("id",id);
		query.setParameter("first_name",member.getFirstName());
		query.setParameter("last_name",member.getLastName());
		query.setParameter("address_street",member.getAddressStreet());
		query.setParameter("address_number",member.getAddressNumber());
		query.setParameter("address_postcode",member.getAddressPostCode());
		query.setParameter("address_city",member.getAddressCity());
		query.setParameter("country",member.getCountry());
		query.setParameter("email",member.getEmail());
		query.setParameter("phone_number",member.getPhoneNumber());
		query.setParameter("roles",member.getRoles());
		query.setParameter("socials",member.getSocials());
		query.setParameter("games",member.getGames());
		query.setParameter("birthday",member.getBirthday());
		query.setParameter("teams",member.getTeams());		
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}

}
