package com.github.mortezaadi.demo;

import java.io.File;

import com.github.mortezaadi.io.VoicePickImage;
import com.github.mortezaadi.io.VoicePickImageFile;
import com.github.mortezaadi.pti.PTILabel;
import com.github.mortezaadi.pti.VoicePickCode;

public class CalculatorApp {
    public static void main(String[] args) {
    	
    	// create PtiLabel from GTIN and Lot
    	PTILabel ptiLabel = new PTILabel("10850510002011", "46587443HG234");
    	// get voice pick code
        VoicePickCode voicePickCode = ptiLabel.getVoicePickCode();
        System.out.println(voicePickCode);
        
        // get voice pick Image
        VoicePickImage voicePickImage = new VoicePickImage(voicePickCode);
        
        // save voice pick image to the file
        VoicePickImageFile mfile = new VoicePickImageFile(voicePickImage);
        mfile.writeTo(new File("voicePick.jpg"));
        
    }
}
