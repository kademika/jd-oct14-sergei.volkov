package day8.bookshop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Shop {
		
	private List <Transaction> register;
	Customer customer;
	Date dateRef;
	Stock stock;
	
	public Shop(Date dateRef, Stock stock){
		this.stock = stock;
		this.dateRef = dateRef;
		register = new ArrayList<>();
	}
	
	public void buy(Customer customer, int indexOfGoods, int quantityToBuy){
	  String goodsName = stock.getName(indexOfGoods);
	  int price = stock.getPrice(indexOfGoods);
	  
	  if(stock.remove(indexOfGoods, quantityToBuy)){
		  register.add(new Transaction(dateRef.currentData,customer.getLogin(),goodsName,price,quantityToBuy));
		  System.out.println(register.get(register.size()-1).toString());
	  }else{
		  System.out.println("Not enough goods. Try less.");
	  }
		 
	}

	
	/*public void todayTransactions(){
		int number = 1;
		int incom = 0;
		int totalIncom = 0;
		int totalQuantity = 0;
		System.out.println();
		System.out.println(" Transactions of "+dateRef.currentData);
		System.out.println();
		System.out.println("           #  Client   Title of the Book           Price, USD     Quantity   Incom,USD");
		System.out.println("------------------------------------------------------------------------------------------");
		for (int i=0;i<transactionMarker;i++){
			if (register[i][0]==dateRef.currentData){
			    incom = 0;
				System.out.print("           "+number);
				System.out.print("  "+register[i][1]);
			    System.out.print("      "+register[i][2]);
			    System.out.print("                       "+register[i][3]);
			    System.out.print("              "+register[i][4]);
			    incom=Integer.parseInt(register[i][3])*Integer.parseInt(register[i][4]);
			    System.out.println("       "+incom);
			    totalQuantity+=Integer.parseInt(register[i][4]);
			    number++;
			}
			totalIncom+=incom;
		 }
		System.out.println("------------------------------------------------------------------------------------------");
	    System.out.print("In total:  "+(number-1)+" purchase(s)");
	    System.out.print("                                             "+totalQuantity);
	    System.out.println("       "+totalIncom);
	}
	
	public void weekTransactions(){
		String[] weekDates = dateRef.weekDates();
		int transCounter = 0;
		
		System.out.println();
		System.out.println("              List of transactions during last week. ");
		System.out.println("---------------------------------------------------------------------------");
		for (int i=0; i<7; i++){
		  for (int j=0; j<transactionMarker;j++){	
			if (weekDates[i].equalsIgnoreCase(register[j][0])){
			   	transCounter++;
			}
		  }
		  System.out.println(" Number of the transactions during "+weekDates[i]+"  ---  "+transCounter);
		  transCounter = 0;
		}
	}*/
/*	
	public void showPrices() {
				
		System.out.println();
		System.out.println("--- PRICES ----");
		System.out.println();
		System.out.println("Title of the book         Price, USD ");
		for (int i = 0; i < firstFreePlace; i++) {
			System.out.println("    " + shop[i][0].getName() + "                  " + shop[i][0].getPrice());
		}
	}
	*/
	/*
	public void showStock() {
		int quantity = 0;
		
		System.out.println();
		System.out.println("--- STOCK ----");
		System.out.println();
		System.out.println("Name of the element         Quantity ");
		for (int i = 0; i < firstFreePlace; i++) {
			quantity = countQuantity(shop[i]);
			System.out.println("    " + shop[i][0].getName() + "                  " + quantity);
			quantity = 0;
		}
	}
	*/
	/*
	
	public void showCatalog(){
		
		for (int i = 0; i < firstFreePlace; i++) {
			catalog[i] = shop[i][0];
		}
		sortCatalog();
		for(Jenre j : Jenre.values()){
			System.out.println();
			System.out.println("Catalog by "+j+" category");
			System.out.println("------------------------------------------------------------------------");
			System.out.println(" Name of the element      Author             IssueNumber  ");
			System.out.println("------------------------------------------------------------------------");
			for (int i = 0; i < firstFreePlace; i++) {
				 if(catalog[i] instanceof Book){
				    if(j== ((Book)catalog[i]).getJenre()){
				      System.out.println("Book:  " + catalog[i].getName()+"            "
				      		+ "  "+((Book)catalog[i]).getAuthor());
				    }
				  }else{
					   if(catalog[i] instanceof Magazine){
					     if(j==((Magazine)catalog[i]).getJenre()){
				           System.out.println("Magazine:  " + catalog[i].getName()+"                        "
				      		+ "  "+((Magazine)catalog[i]).getIssueNumber());
				         }
					   }	
				  }
			}
		}
	}
	*/
/*	private void sortCatalog() {
		boolean swaped = true;
		int finish = firstFreePlace - 1;
		Goods tmp;

		for (int i = 0; (i < (firstFreePlace - 1) && swaped); i++) {
			swaped = false;
			for (int k = 0; k < finish; k++) {
				if (catalog[k].getName().compareTo(
						catalog[k + 1].getName()) != 0) {
					if (catalog[k].getName().compareTo(
							catalog[k + 1].getName()) > 0) {
						tmp = catalog[k];// swap
						catalog[k] = catalog[k + 1];
						catalog[k + 1] = tmp;
						swaped = true;
					}
				}
			}
			finish--;
		}
	}
*/

	public void setCurrentData(String currentData) {
		this.dateRef.currentData = currentData;
	}
	


}
