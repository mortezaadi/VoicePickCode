VoicePickCode Generator
=============

Voice pick code Calculator ( gets the GTIN, Lot &amp; Optional Date and generate the code)


Example usage:
-------------

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

