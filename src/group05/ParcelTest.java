/**
 * 
 */
package group05;

//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 */
/*
class ParcelTest {

@Test
public void testParcelFee() {
	// Create a Parcel object
	Parcel parcel = new Parcel("C01", 65, 50, 35, 3, 21);
	// Call the parcelFee method and check the returned value
	double fee = parcel.parcelFee(parcel.getLength(), parcel.getWidth(), parcel.getHeight(), parcel.getWeight(), parcel.getNoOfDays());
	// Assert the expected fee
	assertEquals(28.6, fee, 0.001);
}
//For Small Parcel and Correct Fee
	@Test
	void small_CorrectFee() {
		Parcel parcel = new Parcel();
		double expectedFee = Constants.BASE_FARE + Constants.SMALL_FARE;
		double actualFee = parcel.parcelFee(10, 10, 10, 1, 1);
		assertEquals(expectedFee, actualFee);
	}
	//For Medium Parcel and Correct Fee
	@Test
	void medium_CorrectFee() {
		Parcel parcel = new Parcel();
		double expectedFee = Constants.BASE_FARE + Constants.MEDIUM_FARE;
		double actualFee = parcel.parcelFee(30, 30, 30, 5, 1);
		assertEquals(expectedFee, actualFee);
	}
	//For Large Parcel and Correct Fee
	@Test
	void Large_CorrectFee() {
		Parcel parcel = new Parcel();
		double actualFee = parcel.parcelFee(50, 50, 50, 21, 2);
		assertEquals(22.6, actualFee);
	}

	@Test
	void OutOfRangeParcel_ReturnsNegativeOne() {
		Parcel parcel = new Parcel();
		double actualFee = parcel.parcelFee(200, 200, 200, 50, 1);
		assertEquals(-1, actualFee);
	}

	@Test
	void discount_LargeParcel_CorrectDiscount() {
		Parcel parcel = new Parcel();
		double expectedDiscount = Constants.DISCOUNT_RATE * Constants.LARGE_FARE;
		double actualDiscount = parcel.discount("LARGE", Constants.LARGE_FARE);
		assertEquals(expectedDiscount, actualDiscount);
	}

	@Test
	void discount_SmallParcel_NoDiscount() {
		Parcel parcel = new Parcel();
		double actualDiscount = parcel.discount("SMALL", Constants.SMALL_FARE);
		assertEquals(0, actualDiscount);
	}

	@Test
	void test_dimensionWeight() {
		Parcel parcel = new Parcel();
		int expectedWeight = 25;
		int actualWeight = parcel.dimensionWeight(50, 50, 50);
		assertEquals(expectedWeight, actualWeight);
	}
}
*/