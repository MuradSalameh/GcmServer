package main.java.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import main.java.hibernate.model.Member;
import main.java.hibernate.model.MemberSocials;
import main.java.hibernate.model.Social;
import main.java.hibernate.utils.SessionUtil;

public class SocialDAO {
	

	public static void addSocial(Social bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();		
		 
		session.persist(bean);  
		tx.commit();
		session.close();
	}
	
	public static void addSocialToMember(int memberID, int socialID){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();
		
		Member m = session.get(Member.class, memberID);
		Social s = session.get(Social.class, socialID);
		
		MemberSocials ms = new MemberSocials();
		ms.setMember(m);
		ms.setSocial(s);
		
		session.save(ms);  
		tx.commit();
		session.close();
	}
	
	public static Social getSocial(int id) {
		   Session session = SessionUtil.getSession();
			Transaction tx = session.beginTransaction();	
			Social s = session.get(Social.class, id);			
			return s;
	}
	
	public static Social getSocialWithHighestId() {
		Session session = SessionUtil.getSession();
		//String hql = "select max(id) from Social";
		Integer maxId = (Integer) session.createNativeQuery("select max(id) from Social").getSingleResult();
		
		System.out.println(maxId);
		
		
		Social social = session.get(Social.class, maxId);
		
		return social;
	}
	


	public static List<Social> getSocials(){
		Session session = SessionUtil.getSession();  
		String hql = "from Social";
		Query query = session.createQuery(hql);
		List<Social> socials =  query.list();		
		session.close();		
		return socials;
	}
	
	public static List<Social> getSocialsByMemberId(int id){		
		//SQL: SELECT * FROM gcm.member_socials where member_id= '3'

		Session session = SessionUtil.getSession(); 			
		String hql = "from MemberSocials social_id where member_id= :id";		
		Query query = session.createQuery(hql);
        query.setParameter("id", id);
		List<MemberSocials> socialsMember =  query.list();	
		List<Social> filteredSocialsList =  new ArrayList<>();	
		
		for(MemberSocials m : socialsMember) {
			int sId = m.getSocial().getId();
			Social s = session.get(Social.class, sId);
			filteredSocialsList.add(s);
			System.out.println(s);
		}
						
		session.close();		
		return filteredSocialsList;		
	}
	
	
	public static void deleteSocialFromMember(int id){		
		Session session = SessionUtil.getSession(); 
		Transaction tx = session.beginTransaction();
		
		// Delete connection from MemberSocials Table
		String hql = "delete from MemberSocials id where social_id= :id";		
		Query query = session.createQuery(hql);		
        query.setParameter("id", id);
        
        int count = query.executeUpdate();
        System.out.println(count + " Record(s) Deleted.");
        
        // Remove from Social Table
    	Social social = session.get(Social.class, id);
		session.remove(social);

        tx.commit();
        session.clear();
        session.close();
	}
	
	
	
	public static void deleteSocial(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Social social = session.get(Social.class, id);
		session.remove(social);
		tx.commit();
		session.close();
		
	}

	
	
	public static void updateSocial(int id, Social social){
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Social old = session.get(Social.class, id);
		
		old.setSocialPlatform(social.getSocialPlatform());
		old.setSocialUsername(social.getSocialUsername());
		old.setSocialLink(social.getSocialLink());
		old.setSocialNotes(social.getSocialNotes());
			
		session.saveOrUpdate(old);
		session.flush();
		tx.commit();
		session.close();		
	}


}
