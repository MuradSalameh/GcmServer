package tests;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import main.java.hibernate.dao.GenreDAO;
import main.java.hibernate.model.Genre;
import main.java.hibernate.utils.SessionUtil;

public class GenreDAOTest {

	public static void main(String[] args) {

		Session session = SessionUtil.getSession();
		int id = 5;
		

		//--------- addGenre() Test -----------//

//		addTestGenre();
//		addTestGenre();
//		addTestGenre();
//		addTestGenre();
		
		
		//--------- getGenres() Test to get a List of all genres in database-----------//

		getGenreList();


		
		//--------- deleteGenre() Test -----------//

//		deleteGenreTest(id);
		


		
		//--------- getGenre() Test to get one specific genre by id -----------//

//		getGenreTest(id);



		//--------- updateGenre() Test -----------//

//		String s = "BOBO genre";
//		updateGenreTest(id,s);



	}
	
	

	public static void addTestGenre() {
		Genre test = new Genre(
				"test", 					// title
				null);						// games

		GenreDAO.addGenre(test);			
	}


	public static void updateGenreTest(int id, String s) {
		Session session = SessionUtil.getSession();

		//Vorhandenen Genre anhand id aus DB holen
		Genre m = session.get(Genre.class, id);

		// Genre m ClanName wert neu setzen
		m.setGenreTitle(s);

		//Genre m  in Datenbank updaten
		GenreDAO.updateGenre(id, m);

		System.out.println(m);
	}

	public static void deleteGenreTest(int id) {
		GenreDAO.deleteGenre(id);

		Genre genre = GenreDAO.getGenre(id);
		System.out.println(genre);

	}

	public static void getGenreTest(int id) {
		System.out.println(GenreDAO.getGenre(id)); 
	}

	public static void getGenreList() {
		List<Genre> genres = GenreDAO.getGenres();
		ArrayList<Genre> ol = new ArrayList<Genre>();
	
		for(Genre m : genres) {
			  ol.add(m);
			  System.out.println(m);
		}
	}



}
