package fr.isep.game7WonderArch.impl;

import java.util.ArrayList;
import java.util.List;

import fr.isep.game7WonderArch.domain.Card;

public class GameStateInternal {
	
	private int currentPlayerIndex;
	private int subPhaseIndex;  // 0: choose card in decks,   1: choose combination of cards to buid wonder fragment, ...
	
  private List<PlayerStateInternal> playerStates = new ArrayList();
  private List<Card> centerCards = new ArrayList();
  private int warHornCounter = 0;
  
  
  
}
