package day7.listsortBar17;

import java.util.Comparator;

public class StringsComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		if (o1 != null && o2 != null) {
			return ((String) o2).compareTo((String) o1);
		} else {
			throw new IllegalArgumentException(
					"Null arguments of the method: compare()");
		}
		//return 0;
	}

}
