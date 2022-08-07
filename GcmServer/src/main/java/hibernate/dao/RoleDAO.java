package main.java.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.Role;
import main.java.hibernate.utils.SessionUtil;

public class RoleDAO {
	

	public static void addRole(Role bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();		
		 
		session.persist(bean);    // Dafür die add role nicht mehr aufrufen, da direkt im bean gespeichert wird.
		tx.commit();
		session.close();
	}
	
	public static Role getRole(int id) {
		   Session session = SessionUtil.getSession();
			Transaction tx = session.beginTransaction();
		
			Role r = session.get(Role.class, id);
			
			return r;
	}


	public static List<Role> getRoles(){
		Session session = SessionUtil.getSession();  
		String hql = "from Role";
		Query query = session.createQuery(hql);
		List<Role> roles =  query.list();		
		session.close();		
		return roles;
	}

	public static void deleteRole(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Role role = session.find(Role.class, id);
		session.remove(role);
		tx.commit();
		session.close();
		
	}

	public static void updateRole(int id, Role role){
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Role old = session.find(Role.class, id);
		
		old.setRoleName(role.getRoleName());
		old.setRoleDescription(role.getRoleDescription());
		
		session.saveOrUpdate(old);
		session.flush();
		tx.commit();
		session.close();			
	}


}
