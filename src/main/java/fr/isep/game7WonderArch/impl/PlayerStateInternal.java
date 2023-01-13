package fr.isep.game7WonderArch.impl;

import java.util.List;

import fr.isep.game7WonderArch.domain.Card;
import fr.isep.game7WonderArch.domain.ImmutableCardByTypeCounts;
import fr.isep.game7WonderArch.domain.ImmutableMaterialCardByTypeCounts;
import fr.isep.game7WonderArch.domain.ProgressToken;
import fr.isep.game7WonderArch.domain.Wonder;
import lombok.Getter;

@Getter
// @AllArgsConstructor
public class PlayerStateInternal {
	
	public final String name;
	public final Wonder wonder;

	/** randomly shuffled order is hidden to user, accessible only by GameController */ 
	private List<Card> deckCards;
	
	// => what is accessible: 
	public ImmutableCardByTypeCounts getDeckCardCounters() {
		return new ImmutableCardByTypeCounts(deckCards);
	}
	
	private List<ProgressToken> tokens;
	private int trophyCounter;
	private List<Card> availableCards;
	
	public ImmutableCardByTypeCounts getAvailableCardCounters() {
		return new ImmutableCardByTypeCounts(availableCards);
	}
	
	public ImmutableMaterialCardByTypeCounts getAvailableMaterialCardCounts() {
		return new ImmutableMaterialCardByTypeCounts(getAvailableCardCounters());
	}
	
	// ------------------------------------------------------------------------
	
	public PlayerStateInternal(String name, Wonder wonder, List<Card> deckCards, List<ProgressToken> tokens,
			int trophyCounter, List<Card> availableCards) {
		this.name = name;
		this.wonder = wonder;
		this.deckCards = deckCards;
		this.tokens = tokens;
		this.trophyCounter = trophyCounter;
		this.availableCards = availableCards;
	}

	
	// ------------------------------------------------------------------------
	
	
}
