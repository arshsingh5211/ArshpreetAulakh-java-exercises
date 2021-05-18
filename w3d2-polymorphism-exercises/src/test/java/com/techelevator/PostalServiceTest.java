package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.PackageDelivery.PostalService;

public class PostalServiceTest {
	
	private PostalService ps = new PostalService(2);
	
	@Test
	public void getNameFirstClassTest() {
		PostalService ps1 = new PostalService(1);
		
		assertEquals("Postal Service (First-Class)", ps1.getName());
	}
	
	@Test
	public void getNameSecondClassTest() {
		PostalService ps2 = new PostalService(2);
		
		assertEquals("Postal Service (Second-Class)", ps2.getName());
	}
	
	@Test
	public void getNameThirdClassTest() {
		PostalService ps3 = new PostalService(3);
		
		assertEquals("Postal Service (Third-Class)", ps3.getName());
	}

	@Test
    public void calculateRateTestPostalServiceFirstClass() {
        PostalService psfc = new PostalService(1);

        assertEquals(0.000, psfc.calculateRate(0, 0), 0.0);
        assertEquals(0.035, psfc.calculateRate(1, 1), 0.01);
        assertEquals(0.040, psfc.calculateRate(1, 5), 0.01);
        assertEquals(0.047, psfc.calculateRate(1, 14), 0.01);
        assertEquals(0.195, psfc.calculateRate(1, 36), 0.01);
        assertEquals(0.450, psfc.calculateRate(1, 62), 0.01);
        assertEquals(0.500, psfc.calculateRate(1, 144), 0.01);
        assertEquals(1606.00, psfc.calculateRate(3212, 532), 0.01);
    }
	
	@Test
    public void calculateRateTestPostalServiceSecondClass() {
        PostalService pssc = new PostalService(2);

        //assertEquals(0.0000, pssc.calculateRate(0, 0), 0.0);
        assertEquals(0.0035, pssc.calculateRate(1, 1), 0.01);
        assertEquals(0.0040, pssc.calculateRate(1, 5), 0.01);
        assertEquals(0.0047, pssc.calculateRate(1, 14), 0.01);
        assertEquals(0.0195, pssc.calculateRate(1, 36), 0.01);
        assertEquals(0.0450, pssc.calculateRate(1, 62), 0.01);
        assertEquals(0.0500, pssc.calculateRate(1, 144), 0.01);
        assertEquals(160.600, pssc.calculateRate(3212, 532), 0.01);
    }
	
	@Test
    public void calculateRateTestPostalServiceThirdClass() {
        PostalService pstc = new PostalService(3);

        //assertEquals(0.0000, pstc.calculateRate(0, 0), 0.0);
        assertEquals(0.0020, pstc.calculateRate(1, 1), 0.01);
        assertEquals(0.0022, pstc.calculateRate(1, 5), 0.01);
        assertEquals(0.0024, pstc.calculateRate(1, 14), 0.01);
        assertEquals(0.0150, pstc.calculateRate(1, 36), 0.01);
        assertEquals(0.0160, pstc.calculateRate(1, 62), 0.01);
        assertEquals(0.0170, pstc.calculateRate(1, 144), 0.01);
    }

}
