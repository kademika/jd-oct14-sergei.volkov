package day7.hashcode;

public class Address {
  String city;
  String street;
  int house;
  
  public Address(String city, String street, int house){
	  this.city=city;
	  this.street=street;
	  this.house=house;
  }
 
  public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public int getHouse() {
	return house;
}

public void setHouse(int house) {
	this.house = house;
}

@Override
	public int hashCode() {
		int result = 25;
		
		result = result*37 + city.hashCode();
		result = result*37 + street.hashCode();
		result = result*37 + ((Integer)house).hashCode();
		
		return result;
	}
 
  @Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Address){
			Address a = (Address) obj;
			if(city != null && city.equals(a.city) && street != null && street.equals(a.street) && house == a.house){
				return true;
			}
		}
		return false;
	}
}
