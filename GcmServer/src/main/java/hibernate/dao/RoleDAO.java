package main.java.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.Member;
import main.java.hibernate.model.MemberRoles;
import main.java.hibernate.model.Role;
import main.java.hibernate.utils.SessionUtil;

public class RoleDAO {

    // database access methods
    	// add role 
	public static void addRole(Role bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.persist(bean);
		tx.commit();
		session.close();
	}

	
	// assign role to member in MemberRoles table
	public static void addRoleToMember(int memberID, int roleID) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Member m = session.get(Member.class, memberID);
		Role r = session.get(Role.class, roleID);

		MemberRoles mr = new MemberRoles();
		mr.setMember(m);
		mr.setRole(r);

		session.save(mr);
		tx.commit();
		session.close();
	}

	
	// get role
	public static Role getRole(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Role r = session.get(Role.class, id);

		return r;
	}

	
	// get role with highest id
	public static Role getRoleWithHighestId() {
		Session session = SessionUtil.getSession();
		// String hql = "select max(id) from Role";
		Integer maxId = (Integer) session.createNativeQuery("select max(id) from Role").getSingleResult();

		Role role = session.get(Role.class, maxId);

		return role;
	}

	
	// get list of all roles
	public static List<Role> getRoles() {
		Session session = SessionUtil.getSession();
		String hql = "from Role";
		Query query = session.createQuery(hql);
		List<Role> roles = query.list();
		session.close();
		return roles;
	}

	
	// get roles by member id from MemberRoles table
	public static List<Role> getRolesByMemberId(int id) {

		// SELECT * FROM gcm.member_socials where member_id= '3'

		Session session = SessionUtil.getSession();
		String hql = "from MemberRoles role_id where member_id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<MemberRoles> rolesMember = query.list();
		List<Role> filteredRolesList = new ArrayList<>();

		for (MemberRoles m : rolesMember) {
			int sId = m.getRole().getId();
			Role s = session.get(Role.class, sId);
			filteredRolesList.add(s);

		}

		session.close();
		return filteredRolesList;
	}

	// delete role from specific member in MemberRoles table
	public static void deleteRoleFromMember(int roleid, int memberid) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "delete from MemberRoles id where role_id= :roleid and member_id= :memberid";
		Query query = session.createQuery(hql);
		query.setParameter("roleid", roleid);
		query.setParameter("memberid", memberid);

		int count = query.executeUpdate();
		System.out.println(count + " Record(s) Deleted.");

		tx.commit();
		session.clear();
		session.close();
	}

	
	// delete role
	public static void deleteRole(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Role role = session.get(Role.class, id);
		session.remove(role);
		tx.commit();
		session.close();

	}

	
	// update role
	public static void updateRole(int id, Role role) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Role old = session.get(Role.class, id);

		old.setRoleName(role.getRoleName());
		old.setRoleDescription(role.getRoleDescription());

		session.saveOrUpdate(old);
		session.flush();
		tx.commit();
		session.close();
	}
}
