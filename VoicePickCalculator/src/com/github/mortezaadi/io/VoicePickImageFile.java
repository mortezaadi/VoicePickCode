package com.github.mortezaadi.io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class VoicePickImageFile {

	private static final String FILE_TYPE = "jpg";
	private final BufferedImage bf;

	
	public VoicePickImageFile(VoicePickImage voicePickImage) {
		this.bf = voicePickImage.getImage();
	}

	/**
	 * 
	 * @param file containing Voice Pick code Image
	 */
	public void writeTo(File file) {
		try {
			ImageIO.write(bf, FILE_TYPE, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
