package week4;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlus {

	@Test
	public void test() {
		BigNumber bigNumber = new BigNumber();
		assertEquals(bigNumber.multiplyMini("87143",2), "174286");
		assertEquals(bigNumber.multiplyMini("431",2), "862");
		assertEquals(bigNumber.multiplyMini("4",4), "16");
		assertEquals(bigNumber.multiplyMini("6383",6), "38298");
		assertEquals(bigNumber.multiplyMini("97233",2), "194466");
		assertEquals(bigNumber.multiplyMini("78",3), "234");
		assertEquals(bigNumber.multiplyMini("97",7), "679");
		assertEquals(bigNumber.multiplyMini("8598",4), "34392");
		assertEquals(bigNumber.multiplyMini("12",5), "60");
		assertEquals(bigNumber.multiplyMini("356",5), "1780");
		assertEquals(bigNumber.multiplyMini("17719",5), "88595");
		assertEquals(bigNumber.multiplyMini("56",2), "112");
		assertEquals(bigNumber.multiplyMini("33963",4), "135852");
		assertEquals(bigNumber.multiplyMini("4249",3), "12747");
		assertEquals(bigNumber.multiplyMini("22157",8), "177256");
		assertEquals(bigNumber.multiplyMini("22134",9), "199206");
		assertEquals(bigNumber.multiplyMini("48",2), "96");
	}

}
