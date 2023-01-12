package fr.isep.game7WonderArch.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WonderFragment {
	
	public final Wonder wonder; // implicit parent
	
	// example: images/wonders/alexandrie/piece-back-alexandrie-1.png
	public final String frontImageResource;
	public final String backImageResource;
	
	public final int materialRequiredCount;
	public final boolean sameMaterial;
	public final boolean triggerEffect;
	public final int trophyCount;
	public final int heightLevel;

}
