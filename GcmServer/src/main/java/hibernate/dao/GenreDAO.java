package main.java.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.Genre;
import main.java.hibernate.model.Member;
import main.java.hibernate.utils.SessionUtil;

public class GenreDAO {
	

	public static void addGenre(Genre bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();		
		 
		session.persist(bean);    // Dafür die add genre nicht mehr aufrufen, da direkt im bean gespeichert wird.
		tx.commit();
		session.close();
	}
	
	public static Genre getGenre(int id) {
		   Session session = SessionUtil.getSession();
			Transaction tx = session.beginTransaction();
		
			Genre genre = session.get(Genre.class, id);
			
			return genre;
	}


	public static List<Genre> getGenres(){
		Session session = SessionUtil.getSession();  
		String hql = "from Genre";
		Query query = session.createQuery(hql);
		List<Genre> genres =  query.list();		
		session.close();		
		return genres;
	}

	public static void deleteGenre(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Genre genre = session.find(Genre.class, id);
		session.remove(genre);
		tx.commit();
		session.close();
		
	}

	public static void updateGenre(int id, Genre genre){
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Genre old = session.find(Genre.class, id);
		
		old.setGenreTitle(genre.getGenreTitle());
		//old.setGames(genre.getGames());			
		
		session.saveOrUpdate(old);
		session.flush();
		tx.commit();
		session.close();	
	}

	

}
