package group05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParcelCollectionTest {

    @Test
    
    //add a parcel with this information and read it successful ,it have problem cause of p1 not a normal id
    void testAddParcel() {
        ParcelCollection pc = new ParcelCollection();
        Parcel parcel = new Parcel("P1", 10, 10, 10, 1, 1);
        pc.addParcel(parcel);
        assertEquals(1, pc.getParcelCount());
        assertEquals(parcel, pc.getParcel("P1"));
    }
    
    @Test
    void testGetParcel_NotFound() {
        ParcelCollection pc = new ParcelCollection();
        assertNull(pc.getParcel("nonexistent"));
    }


    @Test
    void testRemoveParcel() {
        ParcelCollection pc = new ParcelCollection();
        Parcel parcel1 = new Parcel("P1", 10, 10, 10, 1, 1);
        Parcel parcel2 = new Parcel("C62", 20, 20, 20, 2, 2);
        pc.addParcel(parcel1);
        pc.addParcel(parcel2);

        pc.removeParcel("P1");

        assertEquals(1, pc.getParcelCount());
        assertEquals(parcel2, pc.getParcel("C62"));
        assertNull(pc.getParcel("P1")); // Verify removed parcel is not found
    }

    @Test
    void testUpdateParcel() {
        ParcelCollection pc = new ParcelCollection();
        Parcel originalParcel = new Parcel("C53", 10, 10, 10, 1, 1);
        pc.addParcel(originalParcel);

        Parcel updatedParcel = new Parcel("C53", 20, 20, 20, 3, 2);
        pc.updateParcel("C53", updatedParcel);

        assertEquals(1, pc.getParcelCount());
        assertEquals(updatedParcel, pc.getParcel("C53"));
        assertNotEquals(originalParcel, pc.getParcel("C53")); // Verify the parcel was updated
    }

    @Test
    void testIsEmpty() {
        ParcelCollection pc = new ParcelCollection();
        assertTrue(pc.isEmpty());

        pc.addParcel(new Parcel("P1", 10, 10, 10, 1, 1));
        assertFalse(pc.isEmpty());
    }

    @Test
    void testClearParcels() {
        ParcelCollection pc = new ParcelCollection();
        pc.addParcel(new Parcel("P1", 10, 10, 10, 1, 1));
        pc.addParcel(new Parcel("C62", 20, 20, 20, 2, 2));

        pc.clearParcels();

        assertEquals(0, pc.getParcelCount());
        assertTrue(pc.isEmpty());
    
}
}