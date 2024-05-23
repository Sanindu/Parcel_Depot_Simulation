package application;

/* These weight limits are real world values used in Royal Mail and can found in this
 *link :  https://www.shipbob.com/uk/blog/royal-mail-parcel-size  */
// All Fares are in GBP, Weight are in kg, Lengths,widths and heights are in cm
public interface Constants {
	final double BASE_FARE = 5;
	final double SMALL_FARE = 10;
	final double MEDIUM_FARE = 15;
	final double LARGE_FARE = 20;
	
	final int SMALL_WEIGHT_LIMIT= 2;
	final int MEDIUM_WEIGHT_LIMIT = 20;
	final int LARGE_WEIGHT_LIMIT = 30;

	final double PER_DAY_RATE = 2;
	final double DISCOUNT_RATE = 0.12;
	final double VOLUMETRIC_FACTOR = 5000.0;
}