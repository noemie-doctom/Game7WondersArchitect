package fr.isep.game7WonderArch.domain;

import com.google.common.collect.ImmutableList;

import lombok.AllArgsConstructor;
import lombok.val;

public enum Wonder {

	Alexandrie("Alexandrie", "Alexandrie", //
			"Prenez la première carte d'une pioche au choix, n'importe où sur la table, et posez-la devant vous", //
			ImmutableList.of(
					frag("1", 2, false, false, 4, 0), // require 2 different materials, not triggering effect, giving 4 points, at level 0
					frag("2", 3, false, false, 6, 1), //
					frag("3", 3, true, true, 5, 2), //
					frag("4", 2, true, true, 3, 3), //
					frag("5", 2, true, true, 3, 4), // TODO TOCHANGE UNKOWNN image not present
					frag("6", 4, false, false, 7, 5) // 
					)
			),
	
	Halicarnasse("Halicarnasse", "Halicarnasse", //
			"Prenez les 5 premières cartes de la pioche à votre gauche ou à votre droite, choisissez-en 1 et posez-la devant vous" //
			+ "Mélangez-les cartes restantes dans leur pioche",
			ImmutableList.of(
					frag("1", 2, false, false, 3, 0), // 
					frag("2", 2, true, true, 3, 1), // 
					frag("3", 3, true, true, 5, 2), // 
					frag("4", 3, false, false, 6, 3), // 
					frag("5", 4, false, false, 7, 4) // 
					)
			),
	
	Ephese("Ephese", "Ephèse", //
			"Prenez la première carte de la pioche centrale et posez-la devant vous", //
			ImmutableList.of(
					frag("1", 2, false, false, 3, 0), // TODO TOCHANGE UNKOWN image not present
					fragSame("2", 2, true, 3, 1), // TODO TOCHECK
					fragSame("3", 3, true, 5, 2),
					fragDiff("4", 3, true, 4, 3),
					fragDiff("5", 2, false, 4, 4),
					fragDiff("6", 4, false, 7, 5)
					)
			),
	
	Olympie("Olympie", "Olympie", //
			"Prenez la première carte de la pioche à votre cauche et de celle à votre droite, et posez-les devant vous", //
			ImmutableList.of(
					fragSame("1", 1, false, 3, 0), //
					fragSame("2", 1, false, 5, 1), //
					fragSame("3", 1, true, 2, 1), //
					fragSame("4", 1, true, 5, 2), //
					fragSame("5", 1, false, 7, 3) //
					)
			),
	
	Babylone("Babylone", "Babylone", //
			"Choisissez 1 jeton Progrès parmi les 4 disponibles, et posez-le devant vous", //
			ImmutableList.of(
					fragDiff("1", 2, false, 3, 0), //
					fragSame("2", 2, true, 0, 1), // 0 point
					fragDiff("3", 2, false, 3, 2), //
					fragDiff("4", 3, false, 5, 3), //
					fragSame("5", 3, true, 5, 4), //
					fragDiff("6", 4, false, 7, 4) 
					)
			),
	
	Rhodes("Rhodes", "Rhodes", //
			"Ajoutez 1 Bouclier à votre total de Boucliers", //
			ImmutableList.of(
					fragSame("1", 2, true, 4, 0), //
					fragDiff("2", 2, false, 4, 0), //
					fragDiff("3", 3, false, 5, 2), //
					fragSame("4", 3, true, 6, 3), //
					fragDiff("5", 4, false, 7, 4)
					)
			),
	
	Gizeh("Gizeh", "Gizeh", //
			"Cette merveille n'a pas d'effet particulier, mais rapporte plus de points de victoire que les autres Merveilles", //
			ImmutableList.of(
					fragSame("1", 2, false, 5, 0),
					fragDiff("2", 3, false, 6, 1),
					fragSame("3", 3, false, 7, 2),
					fragDiff("4", 4, false, 8, 3)
					)
			),
	;
	
	// ------------------------------------------------------------------------
	
	public final String displayName;
	
	public final String frenchName;
	
	public final String effectDescription;
	
	public final ImmutableList<WonderFragment> fragments;
	
	// ------------------------------------------------------------------------
	
	Wonder(String displayName, String frenchName, String effectDescription, ImmutableList<WonderFragmentBuilder> fragmentBuilders) {
		this.displayName = displayName;
		this.frenchName = frenchName;
		this.effectDescription = effectDescription;
		val fragList = ImmutableList.<WonderFragment>builder();
		val wonderName = this.name().toLowerCase();
		val imagesResourceDir = "images/wonders/" + wonderName;
		for(val b : fragmentBuilders) {
			val fragName = b.simpleName;
			val backImageResource = imagesResourceDir + "/piece-back-" + wonderName + "-" + fragName + ".png";
			val frontImageResource = imagesResourceDir + "/piece-front-" + wonderName +  "-" + fragName + ".png";
			val frag = new WonderFragment(this,
					backImageResource, frontImageResource, b.materialRequiredCount, b.sameMaterial,
					b.triggerEffect, b.trophyCount, b.heightLevel);
			fragList.add(frag);
		}
		this.fragments = fragList.build();
	}

	private static WonderFragmentBuilder fragSame(
			String simpleName,
			int materialRequiredCount,
			boolean triggerEffect,
			int trophyCount,
			int heightLevel) {
			return frag(simpleName, materialRequiredCount, true, triggerEffect, trophyCount, heightLevel);
	}
	private static WonderFragmentBuilder fragDiff(
			String simpleName,
			int materialRequiredCount,
			boolean triggerEffect,
			int trophyCount,
			int heightLevel) {
			return frag(simpleName, materialRequiredCount, false, triggerEffect, trophyCount, heightLevel);
	}
	
	private static WonderFragmentBuilder frag(
			String simpleName,
			int materialRequiredCount,
			boolean sameMaterial,
			boolean triggerEffect,
			int trophyCount,
			int heightLevel) {
			return new WonderFragmentBuilder(simpleName, materialRequiredCount, sameMaterial, triggerEffect, trophyCount, heightLevel);
	}

	@AllArgsConstructor
	private static class WonderFragmentBuilder {
		String simpleName;
		int materialRequiredCount;
		boolean sameMaterial;
		boolean triggerEffect;
		int trophyCount;
		int heightLevel;
	}

}
