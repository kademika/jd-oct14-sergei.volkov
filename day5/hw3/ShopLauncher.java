package day5.hw3;

public class ShopLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Shop bookshop = new Shop(date);
		// System.out.println("OK");
	
        
		bookshop.add(new Book("Book #0", "Bonser W.", Jenre.HISTORY, 5));
		bookshop.add(new Book("Book #1", "Ivanov D.", Jenre.FANTASY, 20));
		bookshop.add(new Book("Book #2", "Gromov N.", Jenre.FICTION, 27));
		bookshop.add(new Book("Book #3", "Petrov H.", Jenre.FICTION, 3));
		bookshop.add(new Book("Book #4", "Petrov O.", Jenre.FOOD, 6));
		bookshop.add(new Book("Book #0", "Bonser W.", Jenre.HISTORY, 5));
		bookshop.add(new Book("Book #0", "Bonser W.", Jenre.HISTORY, 5));
		bookshop.add(new Book("Book #0", "Bonser W.", Jenre.HISTORY, 5));
		bookshop.add(new Book("Book #1", "Ivanov D.", Jenre.FANTASY, 20));
		bookshop.add(new Book("Book #2", "Gromov N.", Jenre.FICTION, 27));
		bookshop.add(new Book("Book #3", "Petrov H.", Jenre.FICTION, 3));
		bookshop.add(new Book("Book #4", "Petrov O.", Jenre.FOOD, 6));
		bookshop.add(new Book("Book #4", "Petrov O.", Jenre.FOOD, 6));
		bookshop.add(new Book("Book #1", "Ivanov D.", Jenre.FANTASY, 20));
		bookshop.add(new Book("Book #2", "Gromov N.", Jenre.FICTION, 27));
		bookshop.add(new Book("Book #3", "Petrov H.", Jenre.FICTION, 3));
		bookshop.add(new Book("Book #4", "Petrov O.", Jenre.FOOD, 6));
		bookshop.add(new Book("Book #4", "Petrov O.", Jenre.FOOD, 6));
		
		bookshop.add(new Magazine("SPORT", 1, Jenre.HOBBY, 5));
		bookshop.add(new Magazine("SPORT", 1, Jenre.HOBBY, 5));
		bookshop.add(new Magazine("FASHION", 1, Jenre.HOBBY, 2));
		
		bookshop.showPrices();
		bookshop.showStock();

		Customer customer1 = new Customer(bookshop, "Mike");
		Customer customer2 = new Customer(bookshop, "Juna");
		Customer customer3 = new Customer(bookshop, "Liza");

		bookshop.showCatalog();

		customer1.buy("Book #0","Bonser W.", 3);
		bookshop.showStock();
		customer2.buy("Book #1","Ivanov D.", 1);
		customer3.buy("Book #4", "Petrov O.", 1);
		customer3.buy("SPORT", 1, 1);
		bookshop.todayTransactions();
		bookshop.showStock();

		date.updateCalendar(-1);
		customer3.buy("Book #2", "Gromov N.", 1);
		customer1.buy("Book #3", "Petrov H.", 1);

		date.updateCalendar(-2);
		customer2.buy("Book #2", "Gromov N.", 1);
		bookshop.showStock();
		bookshop.weekTransactions();
	}

}
