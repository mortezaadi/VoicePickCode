package com.github.mortezaadi.pti;

import static org.junit.Assert.*;

import org.junit.Test;

public class PTILabelTest {

	@Test
	public void testGetVoicePickCode() {
		PTILabel ptiLabel = new PTILabel("10850510002011", "46587443HG234");
        
		VoicePickCode voicePickCode = ptiLabel.getVoicePickCode();
        
        assertEquals(new VoicePickCode(63, 59), voicePickCode);
	}

}
