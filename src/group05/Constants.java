package group05;
/* These values are(Except Fares) based on realistic values in Royal Mail and can found in this 
 *link :  https://www.shipbob.com/uk/blog/royal-mail-parcel-size  */

// All Fares are in GBP, Weight are in kg, Lengths and widths are in cm
public interface Constants {
	final int BASE_FARE = 5;
	final int SMALL_FARE = 10; 
	final int MEDIUM_FARE = 15; 
	final int LARGE_FARE = 20; 
	
	final int SMALL_WEIGHT_LIMIT= 2; 
	final int MEDIUM_WEIGHT_LIMIT = 20; 
	final int LARGE_WEIGHT_LIMIT = 30;  
	
	final int SMALL_MAX_LENGTH = 45;
	final int SMALL_MAX_WIDTH = 35;
	final int MEDIUM_MAX_LENGTH = 61;
	final int MEDIUM_MAX_WIDTH = 46;
	final int LARGE_MAX_LENGTH = 250;
	
	final int PER_DAY_RATE = 2;
}