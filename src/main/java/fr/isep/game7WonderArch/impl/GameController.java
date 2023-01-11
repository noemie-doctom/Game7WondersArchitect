package fr.isep.game7WonderArch.impl;

import fr.isep.game7WonderArch.domain.WonderFragment;

public class GameController {

	GameStateInternal gameStateInternal;
	
	public void onPlayStep(ChosenStep step) {
		
		
		int currentPlayerIndex = gameStateInternal.currentPlayerIndex;
		
		PlayerStateInternal currentPlayerState = gameStateInternal.playerStates.get(currentPlayerIndex);
		
		// TODO
		int subPhaseIndex = gameStateInternal.subPhaseIndex;
		
		if (0 == subPhaseIndex) {
			// choose card in decks,   
		} else if (1 == subPhaseIndex) {
			// 1: choose combination of cards to buid wonder fragment, ...
		}


		  gameStateInternal.currentPlayerIndex++;
		  if (gameStateInternal.currentPlayerIndex > gameStateInternal.playerStates.length()) {
			  gameStateInternal.currentPlayerIndex = 0;
		  }
	}
	
	
	public boolean canUserBuildWonderFragment(PlayerStateInternal p, WonderFragment frag ){
		boolean isSameOrDifferentMaterial = frag .getSameMaterial();
		
		if( frag.getSameMaterial()==True){
			
		}
		return false;
	}
	
}
