package main.java.hibernate.utils;

import java.util.ArrayList;
import java.util.List;


import main.java.hibernate.dao.MemberDAO;
import main.java.hibernate.dao.RoleDAO;
import main.java.hibernate.model.Member;
import main.java.hibernate.model.Role;


public class HibernateTests {

	public static void main(String[] args) {
		HibernateUtil.startSession();
		
		
		/*
		Role a = new Role("A", "AAAAAA");
		HibernateUtil.getSession().persist(a);

		Role b = new Role("B", "BBBBB");
		HibernateUtil.getSession().persist(b);
		 */
		Role rA = new Role();
		Role rB = new Role();
		
		rA = RoleDAO.getRole(9);
		rB = RoleDAO.getRole(10);
		
		Member member = new Member();
		member = MemberDAO.getMember(2);	
		System.out.println(member);
		

		List<Role> roles = new ArrayList<Role>();
		roles.add(rA);
		roles.add(rB);	

		member.setRoles(roles);
		HibernateUtil.getSession().merge(member);
		
		HibernateUtil.sessionCommit();
		
	}
	
	public static void test() {
		

	}

}
