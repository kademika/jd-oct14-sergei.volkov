package day5.hw3;

public class Customer {
	String login;

	Shop shop;

	public Customer() {
	}

	public Customer(Shop shop, String login) {

		this.login = login;
		this.shop = shop;
	}

	public String getLogin() {
		return login;
	}

	public void buy(String name , String author, int quantity) {

		shop.buyProcess(this, name, author, quantity);
	}
	public void buy(String name , int issueNumber, int quantity) {

		shop.buyProcess(this, name, issueNumber, quantity);
	}
}
