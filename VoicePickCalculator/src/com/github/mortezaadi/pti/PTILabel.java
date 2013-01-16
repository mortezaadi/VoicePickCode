package com.github.mortezaadi.pti;

import java.io.Serializable;

import com.github.mortezaadi.crc.CRC16;

public class PTILabel implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String gtin;
	private final String lot;
	private String date = "";
	private VoicePickCode voicePickCode;

	/**
	 * 
	 * @param GTIN
	 *            14 digit GTIN Do not include application identifier, prefixes
	 *            or parentheses
	 * @param Lot
	 *            Lot number Do not include application identifier, prefixes or
	 *            parentheses
	 */
	public PTILabel(String GTIN, String Lot) {
		assert (GTIN.matches("\\d+") && GTIN.length() == 14);
		assert (!Lot.contains("("));
		this.gtin = GTIN;
		this.lot = Lot;
	}

	/**
	 * 
	 * @param GTIN
	 *            14 digit GTIN Do not include application identifier, prefixes
	 *            or parentheses
	 * @param Lot
	 *            Lot number Do not include application identifier, prefixes or
	 *            parentheses
	 * @param DateString
	 *            String of Date with format YYDDMM (optional)
	 */
	public PTILabel(String GTIN, String Lot, String DateString) {
		this(GTIN, Lot);
		this.date = DateString;
	}

	/**
	 * calculates Voice pick code from 14 digit GTIN, Lot and Date if presented
	 * 
	 * @return VoicePickCose class representing Voice pick code of the current
	 *         PTILabel
	 */
	public VoicePickCode getVoicePickCode() {
		if (voicePickCode == null)
			calculateVoicePickCode();
		return voicePickCode;
	}

	
	private void calculateVoicePickCode() {
		String plainText = gtin + lot + date;
		int hashValue = new CRC16().getCRC16(plainText);
		assert (hashValue > 999);
		int large = hashValue % 100;
		int small = (hashValue / 100) % 100;
		voicePickCode = new VoicePickCode(small, large);
	}

	@Override
	public String toString() {
		return "PTILabel [GTIN=" + gtin + ", lot=" + lot + ", date=" + date
				+ ", VoicePickCode=" + getVoicePickCode() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gtin == null) ? 0 : gtin.hashCode());
		result = prime * result + ((lot == null) ? 0 : lot.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PTILabel other = (PTILabel) obj;
		if (gtin == null) {
			if (other.gtin != null)
				return false;
		} else if (!gtin.equals(other.gtin))
			return false;
		if (lot == null) {
			if (other.lot != null)
				return false;
		} else if (!lot.equals(other.lot))
			return false;
		return true;
	}

	public String getGtin() {
		return gtin;
	}

	public String getLot() {
		return lot;
	}

	public String getDate() {
		return date;
	}

}
