package vo;

public class KidsVO {
	private String sex;
	private String name;
	private int ranking;
	private long nameCount;
	
	public KidsVO() {;}

	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public long getNameCount() {
		return nameCount;
	}

	public void setNameCount(long nameCount) {
		this.nameCount = nameCount;
	}

	@Override
	public String toString() {
		String str = sex + "\t" + name + "\t" + ranking + "\t" + nameCount;
		return str;
	}
}
