/**
 * 
 */
package group05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 */
class ParcelTest {

//	/**
//	 * @throws java.lang.Exception
//	 */
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@AfterEach
//	void tearDown() throws Exception {
//	}
//
//	/**
//	 * Test method for {@link group05.Parcel#parcelFee(double, double, double, int, int)}.
//	 */
@Test
public void testParcelFee() {
	// Create a Parcel object
	Parcel parcel = new Parcel("C01", 65, 50, 35, 3, 21);
	// Call the parcelFee method and check the returned value
	double fee = parcel.parcelFee(parcel.getLength(), parcel.getWidth(), parcel.getHeight(), parcel.getWeight(), parcel.getNoOfDays());
	// Assert the expected fee
	assertEquals(28.6, fee, 0.001);
}

//	@Test
//	public void testDimensionWeight() {
//		// Create a Parcel object
//		Parcel parcel = new Parcel();
//		// Call the dimensionWeight method and check the returned value
//		int weight = parcel.dimensionWeight(10, 20, 30);
//		// Assert the expected weight
//		assertEquals(6, weight);
//	}
//
//	@Test
//	public void testDiscount() {
//		// Create a Parcel object
//		Parcel parcel = new Parcel();
//		// Call the discount method and check the returned value
//		double discount = parcel.discount("LARGE", 50.0);
//		// Assert the expected discount
//		assertEquals(5.0, discount, 0.001); // Adjust delta as per your requirements
//	}
}
