package pojos;

public class Genre {
	private int id;
	private String genreTitle;

	public Genre(int id, String genreTitle) {
		super();
		this.id = id;
		this.genreTitle = genreTitle;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenreTitle() {
		return genreTitle;
	}

	public void setGenreTitle(String genreTitle) {
		this.genreTitle = genreTitle;
	}
	
	

}
