package com.github.mortezaadi.io;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.github.mortezaadi.pti.VoicePickCode;

public class VoicePickImage {

	private static final int IMAGE_WIDTH = 70;
	private static final int IMAGE_HEIGHT = 40;
	private static final double DEFAULT_RESOLUTION = 72.0;

	private VoicePickCode voicePickCode;

	public VoicePickImage(VoicePickCode voicePickCode) {
		this.voicePickCode = voicePickCode;
	}

	/**
	 * 
	 * @return BufferedImage of Voice Pick Code
	 */
	public BufferedImage getImage() {
		BufferedImage vpImage = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT,
				BufferedImage.TYPE_BYTE_GRAY);
		Graphics2D g2 = vpImage.createGraphics();
		g2.setBackground(Color.BLACK);
		g2.setColor(Color.WHITE);
		int screenRes = Toolkit.getDefaultToolkit().getScreenResolution();

		int smallFontSize = (int) Math.round(14.0 * screenRes
				/ DEFAULT_RESOLUTION);
		Font smallFont = new Font("Arial", Font.PLAIN, smallFontSize);
		g2.setFont(smallFont);
		g2.drawString(String.valueOf(voicePickCode.getSmall()), 4, 35);

		int largeFontSize = (int) Math.round(28.0 * screenRes
				/ DEFAULT_RESOLUTION);
		Font largeFont = new Font("Arial", Font.BOLD, largeFontSize);
		g2.setFont(largeFont);
		g2.drawString(String.valueOf(voicePickCode.getLarge()), 26, 35);
		return vpImage;
	}
}
