package main.java.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.Partner;
import main.java.hibernate.utils.SessionUtil;

public class PartnerDAO {

	public static void addPartner(Partner bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.persist(bean); // Dafür die add partner nicht mehr aufrufen, da direkt im bean gespeichert
								// wird.
		tx.commit();
		session.close();
	}

	public static Partner getPartner(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Partner partner = session.get(Partner.class, id);

		return partner;
	}

	public static List<Partner> getPartners() {
		Session session = SessionUtil.getSession();
		String hql = "from Partner";
		Query query = session.createQuery(hql);
		List<Partner> partners = query.list();
		session.close();
		return partners;
	}

	public static void deletePartner(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Partner partner = session.get(Partner.class, id);
		session.remove(partner);
		tx.commit();
		session.close();

	}

	public static void updatePartner(int id, Partner partner) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Partner old = session.get(Partner.class, id);

		old.setCompanyName(partner.getCompanyName());
		old.setContactPersonName(partner.getContactPersonName());
		old.setContactPersonPhone(partner.getContactPersonPhone());
		old.setContactPersonMail(partner.getContactPersonMail());
		old.setFirstName(partner.getFirstName());
		old.setLastName(partner.getLastName());
		old.setAdressStreet(partner.getAdressStreet());
		old.setAdressNumber(partner.getAdressNumber());
		old.setAdressPostCode(partner.getAdressPostCode());
		old.setAdressCity(partner.getAdressCity());
		old.setCountry(partner.getCountry());
		old.setEmail(partner.getEmail());
		old.setPhoneNumber(partner.getPhoneNumber());

		session.saveOrUpdate(old);
		session.flush();
		tx.commit();
		session.close();
	}

}
