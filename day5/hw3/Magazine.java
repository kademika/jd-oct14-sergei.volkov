package day5.hw3;

public class Magazine extends Goods {
	protected int issueNumber;
	Jenre jenre;

	public Magazine() {
	}

	public Magazine(String title, int issueNumber, Jenre jenre, int price) {
		this.name = title;
		this.issueNumber = issueNumber;
		this.jenre = jenre;
		this.price = price;
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}

	public Jenre getJenre() {
		return jenre;
	}

	public void setJenre(Jenre jenre) {
		this.jenre = jenre;
	}
}
