package day8.bookshop;

public class ShopLauncher {

	public static void main(String[] args) {
		
		Date date = new Date();
		Stock stock = new Stock();
		Shop bookshop = new Shop(date,stock);
		
	   
		
	    stock.add(new Book("Book #0", "Bonser W.", Jenre.HISTORY, 5));
	    stock.add(new Book("Book #1", "Ivanov D.", Jenre.FANTASY, 20));
	    stock.add(new Book("Book #2", "Gromov N.", Jenre.FICTION, 27));
	    stock.add(new Book("Book #3", "Petrov H.", Jenre.FICTION, 3));
	    stock.add(new Book("Book #4", "Petrov O.", Jenre.FOOD, 6));
	    stock.add(new Book("Book #0", "Bonser W.", Jenre.HISTORY, 5));
	    stock.add(new Book("Book #0", "Bonser W.", Jenre.HISTORY, 5));
	    stock.add(new Book("Book #0", "Bonser W.", Jenre.HISTORY, 5));
	    stock.add(new Book("Book #1", "Ivanov D.", Jenre.FANTASY, 20));
	    stock.add(new Book("Book #2", "Gromov N.", Jenre.FICTION, 27));
	    stock.add(new Book("Book #3", "Petrov H.", Jenre.FICTION, 3));
	    stock.add(new Book("Book #4", "Petrov O.", Jenre.FOOD, 6));
	    stock.add(new Book("Book #4", "Petrov O.", Jenre.FOOD, 6));
	    stock.add(new Book("Book #1", "Ivanov D.", Jenre.FANTASY, 20));
	    stock.add(new Book("Book #2", "Gromov N.", Jenre.FICTION, 27));
	    stock.add(new Book("Book #3", "Petrov H.", Jenre.FICTION, 3));
	    stock.add(new Book("Book #4", "Petrov O.", Jenre.FOOD, 6));
	    stock.add(new Book("Book #4", "Petrov O.", Jenre.FOOD, 6));
		
	    stock.add(new Magazine("SPORT", "1", Jenre.HOBBY, 5));
	    stock.add(new Magazine("SPORT", "1", Jenre.HOBBY, 5));
	    stock.add(new Magazine("FASHION", "1", Jenre.HOBBY, 2));
		
		
		ShopUI ui = new ShopUI(bookshop,stock);

	}

}
