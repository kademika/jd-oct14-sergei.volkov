package day5.hw3;

public class Book extends Goods{
	String author;
	Jenre jenre;
	        
	public Book(){
		}
	public Book(String title, String author, Jenre jenre, int price) {
		
		this.name = title;
		this.author = author;
		this.jenre = jenre;
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Jenre getJenre() {
		return jenre;
	}
	public void setJenre(Jenre jenre) {
		this.jenre = jenre;
	}
	
}
