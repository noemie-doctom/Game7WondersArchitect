package fr.isep.game7WonderArch.impl;

import java.util.ArrayList;
import java.util.List;

import fr.isep.game7WonderArch.domain.Card;
import fr.isep.game7WonderArch.domain.ProgressToken;
import fr.isep.game7WonderArch.domain.Wonder;

public class PlayerStateInternal {
	private List<Card> deckCards=new  ArrayList();
	private List<ProgressToken> tokens=new ArrayList();
	private int trophyCounter=0;
	private List<Card> AvailableCards=new ArrayList();
	public final String name;
	public final Wonder wonder;
	
	public PlayerStateInternal(List<Card> deckCards, List<ProgressToken> tokens, int trophyCounter,
			List<Card> availableCards, String name, Wonder wonder) {
		super();
		this.deckCards = deckCards;
		this.tokens = tokens;
		this.trophyCounter = trophyCounter;
		AvailableCards = availableCards;
		this.name = name;
		this.wonder = wonder;
	}
	
	


}
