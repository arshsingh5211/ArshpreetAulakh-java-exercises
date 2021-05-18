package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.PackageDelivery.SPU;

public class SPUTest {
	
	@Test
	public void getNameSPU4DayTest() {
		SPU spu4 = new SPU("four-day ground");
		
		assertEquals("SPU (four-day ground)", spu4.getName());
	}
	
	@Test
	public void getNameSPU2DayTest() {
		SPU spu2 = new SPU("two-day business");
		
		assertEquals("SPU (two-day business)", spu2.getName());
	}
	
	@Test
	public void getNameSPUNextDayTest() {
		SPU spu1 = new SPU("next-day");
		
		assertEquals("SPU (next-day)", spu1.getName());
	}
	
	@Test
	public void getShipTypeSPU4DayTest() {
		SPU spu4 = new SPU("four-day ground");
		
		assertEquals("four-day ground", spu4.getShipType());
	}
	
	@Test
	public void getShipTypeSPU2DayTest() {
		SPU spu2 = new SPU("two-day business");
		
		assertEquals("two-day business", spu2.getShipType());
	}
	
	@Test
	public void getShipTypeSPUNextDayTest() {
		SPU spu1 = new SPU("next-day");
		
		assertEquals("next-day", spu1.getShipType());
	}

	@Test
    public void calculateRateTestSPUFourDayGround() {
		
        SPU spuFourDay = new SPU("four-day ground");

        assertEquals(.0050, spuFourDay.calculateRate(1, 15), 0.01);
        assertEquals(.0100, spuFourDay.calculateRate(1, 17), 0.01);
        assertEquals(5.55, spuFourDay.calculateRate(370, 37), 0.01);
        assertEquals(4.44, spuFourDay.calculateRate(37, 370), 0.01);
    }
	
	@Test
    public void calculateRateTestSPUTwoDayBusiness() {
		
        SPU spuTwoDayBusiness = new SPU("two-day business");

        assertEquals(0.050, spuTwoDayBusiness.calculateRate(1, 15), 0.01);
        assertEquals(.100, spuTwoDayBusiness.calculateRate(1, 17), 0.01);
        assertEquals(455.00, spuTwoDayBusiness.calculateRate(700, 200), 0.01);

    }
	
	@Test
    public void calculateRateTestSPUNextDayGround() {
		
        SPU spuNextDay = new SPU("next-day");

        assertEquals(0.075, spuNextDay.calculateRate(1, 15), 0.01);
        assertEquals(.150, spuNextDay.calculateRate(1, 17), 0.01);
        assertEquals(3.75, spuNextDay.calculateRate(25, 25), 0.01);

    }

}
