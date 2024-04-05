
public class CustomerID {
	public class Customer {
	    private String name;
	    private String address;
	    private String phoneNumber;
	    private String email;
		
	    // Constructor
	    public Customer(String name, String address, String phoneNumber, String email) {
	        this.name = name;
	        this.address = address;
	        this.phoneNumber = phoneNumber;
	        this.email = email;
	    }

	    // Getters and Setters
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    // toString method for object representation
	    @Override
	    public String toString() {
	        return "Customer{" +
	                "name='" + name + '\'' +
	                ", address='" + address + '\'' +
	                ", phoneNumber='" + phoneNumber + '\'' +
	                ", email='" + email + '\'' +
	                '}';
	    }
	}



	/*Description
	•	There are private fields for name, address, phone number, and email.
	•	A constructor is defined to initialize the Customer object with the provided details.
	•	Getter and setter methods are provided for accessing and updating the fields.
	•	The toString() method is overridden to provide a string representation of the Customer object.*/


}
