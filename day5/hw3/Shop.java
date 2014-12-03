package day5.hw3;


public class Shop {
	private final int SHOP_SIZE = 15;
	private final int MAX_EQUAL_GOODS = 5;
	private final int MAX_TRANSACTIONS = 50;
	
	private Goods[][] shop;
	private int firstFreePlace;
	private int transactionMarker = 0;
	
	private Goods[] catalog;
	private String[][] register;
	Customer customer;
	Date dateRef;
	
	
	public Shop(Date dateRef){
		this.firstFreePlace = 0;
		shop = new Goods[SHOP_SIZE][MAX_EQUAL_GOODS];
		initShop();
		catalog = new Goods[SHOP_SIZE];
		initArray(catalog);
		this.dateRef = dateRef;
		initRegister();
		
	}
	
	
	
	public void buyProcess(Customer customer, String name , String author, int quantityToBuy){
		int lastItemIndex = 0;
		
		for (int i = 0; i < firstFreePlace; i++) {
		  if(shop[i][0].getName() == name){
			 if(shop[i][0] instanceof Book){
				 if(((Book)shop[i][0]).getAuthor() == author){
					  if(countQuantity(shop[i]) >= quantityToBuy){
						  saveTransaction(customer.login, name, shop[i][0].getPrice(), quantityToBuy);
						  for (int j = 0;j<shop[i].length;j++){// find the last item (not null) in the array
							  lastItemIndex=j;
							  if (shop[i][j]==null){
					  		     lastItemIndex--;
								 break;
					  		  }
						  }
						 
						  for (int j = quantityToBuy-1; j>=0;j--){ // "delete" the items from the end of the array
							  shop[i][lastItemIndex] = null;
							  lastItemIndex--;
						  }
						  if (lastItemIndex == -1){
							  for (int n=i+1; n<firstFreePlace;n++){
								 shop[n-1]= shop[n]; 
							  }
							  firstFreePlace--;
						  }
						  return;
					  } else {
						  System.out.println("There aren't enough books in the shop according to Your order");
					  } 
				 }
			 }
		  }
		}
		System.out.println("There isn't the book in the shop according to Your order");
	}
	public void buyProcess(Customer customer, String name , int issueNumber, int quantityToBuy){
		int lastItemIndex = 0;
		for (int i = 0; i < firstFreePlace; i++) {
			  if(shop[i][0].getName() == name){
				 if(shop[i][0] instanceof Magazine){
					 if(((Magazine)shop[i][0]).getIssueNumber() == issueNumber){
						  if(countQuantity(shop[i]) >= quantityToBuy){
							  saveTransaction(customer.login, name, shop[i][0].getPrice(), quantityToBuy);
							  for (int j = 0;j<shop[i].length;j++){// find the last item (not null) in the array
								  lastItemIndex=j;
								  if (shop[i][j]==null){
						  		     lastItemIndex--;
									 break;
						  		  }
							  }
							 
							  for (int j = quantityToBuy-1; j>=0;j--){ // "delete" the items from the end of the array
								  shop[i][lastItemIndex] = null;
								  lastItemIndex--;
							  }
							  if (lastItemIndex == -1){
								  for (int n=i+1; n<firstFreePlace;n++){
									 shop[n-1]= shop[n]; 
								  }
								  firstFreePlace--;
							  }
							  return;
						  } else {
							  System.out.println("There aren't enough magazines in the shop according to Your order");
						  } 
					 }
				 }
			  }
			}
			System.out.println("There isn't the magazine in the shop according to Your order");	
	}
	public void saveTransaction(String clientLogin, String elementName, int price, int quantity){
		register[transactionMarker][0]=dateRef.currentData;
		register[transactionMarker][1]=clientLogin;
		register[transactionMarker][2]=elementName;
		register[transactionMarker][3]=Integer.toString(price);
		register[transactionMarker][4]=Integer.toString(quantity);
		transactionMarker++;
	}
	
	public void todayTransactions(){
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
	}
	
	public void showPrices() {
				
		System.out.println();
		System.out.println("--- PRICES ----");
		System.out.println();
		System.out.println("Title of the book         Price, USD ");
		for (int i = 0; i < firstFreePlace; i++) {
			System.out.println("    " + shop[i][0].getName() + "                  " + shop[i][0].getPrice());
		}
	}
	
	
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
	
	private int countQuantity(Goods[] element){
		int quantity = 0;
		
		for(int j=0; j<element.length;j++){ // counting the quantity of the equal elements
			  	 if (element[j]!=null){
			  		  quantity++;
			  	 }else{
			  		 break;
			  	 }
			  }
		return quantity;
	}
	
	
	public void add(Goods element){
		int i = 0;
		
		if (firstFreePlace == 0){
			firstFreePlace++;
			shop[0] = new Goods[MAX_EQUAL_GOODS];
			initArray(shop[0]);
			shop[0][0] = element;
		}else{
		  while(i<firstFreePlace) {
			 int res = checkPlace(shop[i], element);
			 if (res == -2){
				 System.out.println("Not enough space to insert book");
				 return;
			 }else{
				 if (res == -1){
					 i++;
				 }else{
					shop[i][res+1] = element;
					for (int j = res; j >= 0; j--){// correction the price of the equal books
						shop[i][j].setPrice(element.getPrice());
					}
					return;
				 }
			 }
		  }
		  if (firstFreePlace < SHOP_SIZE){
			  shop[firstFreePlace] = new Goods[MAX_EQUAL_GOODS];
			  initArray(shop[firstFreePlace]);
			  shop[firstFreePlace][0] = element;
			  firstFreePlace++; 
		  }else{
			  System.out.println("Not enough space to insert the new item, the shop is full");
		  }
		}  
	}
	
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
	
	private void sortCatalog() {
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


	private int checkPlace(Goods[] box, Goods element){
		
		int i = 0;
		
		if(box[0] == null){ //array is empty
			return 0;
		}
		if(!(box[0].getName().equalsIgnoreCase(element.getName()))){
			return -1; // not found
		}
		if(element instanceof Book){
			if(!(((Book)box[0]).getAuthor().equalsIgnoreCase(((Book)element).getAuthor()))){
			 return -1; // not found	
			}
		}
		if(element instanceof Magazine){		
			if(!((((Magazine)box[0]).getIssueNumber() == (((Magazine)element).getIssueNumber())))){
			return -1; // not found
		    }
		}
		i++;
		while(i<box.length){ // looking for the first free place in the array
		  	 if (box[i]!=null){
		  		 i++;
		  	 }else{
		  		 break;
		  	 }
		  }
		if(i==box.length){
			return -2; // array is full
		}else{
		    return i-1; // index of the last found book 
		} 
	}
	
	public void setCurrentData(String currentData) {
		this.dateRef.currentData = currentData;
	}
	
	private void initArray(Goods[] array){
		for(Goods g : array){
			g = null;
			}
	}
	
	private void initShop(){
		for(Goods[] arrayBooks : shop){
			initArray(arrayBooks);
		}
	}
	
	private void initRegister(){
		register = new String[50][];
		for (int i=0;i<MAX_TRANSACTIONS;i++){
			register[i] = new String[]{" "," "," "," "," "};
		}
	}
}
