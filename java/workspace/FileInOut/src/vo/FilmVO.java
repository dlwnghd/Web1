package vo;

public class FilmVO {
	private int ranking;
	private String name;
	private String releaseDate;
	private long income;
	private int audience;
	private int screenCount;
	
	public FilmVO() {;}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public int getAudience() {
		return audience;
	}

	public void setAudience(int audience) {
		this.audience = audience;
	}

	public int getScreenCount() {
		return screenCount;
	}

	public void setScreenCount(int screenCount) {
		this.screenCount = screenCount;
	}
	
	@Override
	public String toString() {
		String str = ranking + "\t" + name + "\t" + releaseDate + "\t";
		str += income + "\t" + audience + "\t" + screenCount;
		return str;
	}
}















