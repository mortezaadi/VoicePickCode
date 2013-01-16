package com.github.mortezaadi.crc;

import static org.junit.Assert.*;

import org.junit.Test;

public class CRC16Test {

	@Test
	public void testGetCRC16() {
		CRC16 crc16 = new CRC16();
		String plainText = "1085051000201146587443HG234";
		int hash = crc16.getCRC16(plainText);
		assertEquals(26359, hash);
	}

}
