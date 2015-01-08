package day8.bookshop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Stock {
	private List<LinkedList<Goods>> arrayOfList;

	public Stock() {
		arrayOfList = new ArrayList<LinkedList<Goods>>();
	}

	public void add(Goods g) {
		if (arrayOfList.isEmpty()) {
			arrayOfList.add(new LinkedList<Goods>());
			arrayOfList.get(0).push(g);// Input if the stock is empty
		} else {
			for (int i = 0; i < arrayOfList.size(); i++) {
				if (arrayOfList.get(i).peek().equals(g)) {
					arrayOfList.get(i).push(g); // Input if the equal was found
					return;
				}
			} // First input to the new list
			arrayOfList.add(new LinkedList<Goods>());
			arrayOfList.get(arrayOfList.size() - 1).push(g);
		}
	}

	public int getNumberTypesOnStock() {
		return arrayOfList.size();
	}

	public String getName(int index) {
		return arrayOfList.get(index).get(0).getName();
	}

	public String getAttribute(int index) {
		String result = null;
		if (arrayOfList.get(index).get(0) instanceof Book) {
			result = ((Book) arrayOfList.get(index).get(0)).getAuthor();
		}
		if (arrayOfList.get(index).get(0) instanceof Magazine) {
			result = ((Magazine) arrayOfList.get(index).get(0))
					.getIssueNumber();
		}
		return result;
	}

	public int getQuantity(int index) {
		return arrayOfList.get(index).size();
	}

	public int getPrice(int index) {
		return arrayOfList.get(index).get(0).getPrice();
	}

	public boolean remove(int index, int quantity) {
		if (quantity <= arrayOfList.get(index).size()) {
			for (int i = 0; i < quantity; i++) {
				arrayOfList.get(index).pop();
			}
			if (arrayOfList.get(index).isEmpty()) {
				arrayOfList.remove(index);
			}
			return true;
		} else {
			return false;
		}

	}
}
