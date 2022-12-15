package fr.isep.game7WonderArch.domain;

public enum CardBack {

	ExtraDeck(null), //
	Alexandrie(Wonder.Alexandrie), //
	Halicarnasse(Wonder.Halicarnasse),
	Ephese(Wonder.Ephese), //
	Olympie(Wonder.Olympie), //,
	Babylone(Wonder.Babylone), //
	Rhodes(Wonder.Rhodes), //
	Gizeh(Wonder.Gizeh); //
	
	public final boolean extraDeck;
	// set only when not from extraQuestionDeck
	public final Wonder wonderDeck;
	
	private CardBack(Wonder wonderDeck) {
		this.extraDeck = (wonderDeck == null);
		this.wonderDeck = wonderDeck;
	}
	
}
