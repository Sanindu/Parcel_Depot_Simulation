package group05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OverallTesting {

    @Test
    void testParcelFunctionality() {
        Parcel parcel = new Parcel("C01", 65, 50, 35, 3, 21);
        double fee = parcel.parcelFee(parcel.getLength(), parcel.getWidth(), parcel.getHeight(), parcel.getWeight(), parcel.getNoOfDays());
        assertEquals(28.6, fee, 0.001);

        Parcel parcelInstance = new Parcel();
        double expectedFee = Constants.BASE_FARE + Constants.SMALL_FARE;
        double actualFee = parcelInstance.parcelFee(10, 10, 10, 1, 1);
        assertEquals(expectedFee, actualFee);

        actualFee = parcelInstance.parcelFee(30, 30, 30, 5, 1);
        assertEquals(Constants.BASE_FARE + Constants.MEDIUM_FARE, actualFee);

        actualFee = parcelInstance.parcelFee(50, 50, 50, 21, 2);
        assertEquals(22.6, actualFee);

        actualFee = parcelInstance.parcelFee(200, 200, 200, 50, 1);
        assertEquals(-1, actualFee);

        double expectedDiscount = Constants.DISCOUNT_RATE * Constants.LARGE_FARE;
        double actualDiscount = parcelInstance.discount("LARGE", Constants.LARGE_FARE);
        assertEquals(expectedDiscount, actualDiscount);

        actualDiscount = parcelInstance.discount("SMALL", Constants.SMALL_FARE);
        assertEquals(0, actualDiscount);

        int expectedWeight = 25;
        int actualWeight = parcelInstance.dimensionWeight(50, 50, 50);
        assertEquals(expectedWeight, actualWeight);
    }

    @Test
    void testParcelCollectionFunctionality() {
        ParcelCollection pc = new ParcelCollection();
        Parcel parcel = new Parcel("P1", 10, 10, 10, 1, 1);
        pc.addParcel(parcel);
        assertEquals(1, pc.getParcelCount());
        assertEquals(parcel, pc.getParcel("P1"));

        assertNull(pc.getParcel("nonexistent"));

        Parcel parcel1 = new Parcel("P1", 10, 10, 10, 1, 1);
        Parcel parcel2 = new Parcel("C62", 20, 20, 20, 2, 2);
        pc.addParcel(parcel1);
        pc.addParcel(parcel2);

        pc.removeParcel("P1");

        assertEquals(1, pc.getParcelCount());
        assertEquals(parcel2, pc.getParcel("C62"));
        assertNull(pc.getParcel("P1")); 

        Parcel originalParcel = new Parcel("C53", 10, 10, 10, 1, 1);
        pc.addParcel(originalParcel);

        Parcel updatedParcel = new Parcel("C53", 20, 20, 20, 3, 2);
        pc.updateParcel("C53", updatedParcel);

        assertEquals(1, pc.getParcelCount());
        assertEquals(updatedParcel, pc.getParcel("C53"));
        assertNotEquals(originalParcel, pc.getParcel("C53")); 

        assertTrue(pc.isEmpty());

        pc.addParcel(new Parcel("P1", 10, 10, 10, 1, 1));
        assertFalse(pc.isEmpty());

        pc.clearParcels();

        assertEquals(0, pc.getParcelCount());
        assertTrue(pc.isEmpty());
    }
}

