package fr.isep.game7WonderArch.domain;

import lombok.AllArgsConstructor;

public abstract class GameMove {

	@AllArgsConstructor
	public static class BuildWonderFragUsingCardsGameMode extends GameMove {
		public final WonderFragment wonderFragment;
		public final ImmutableMaterialCardByTypeCounts cardsUsed;
	}
	
}
