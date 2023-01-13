package fr.isep.game7WonderArch.impl;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import fr.isep.game7WonderArch.domain.Card;
import fr.isep.game7WonderArch.domain.CardType;
import fr.isep.game7WonderArch.domain.Wonder;
import lombok.val;

public class GameStepUtilsTest {

	//@Test
	public void test() {
		GameStepUtils.listMoveBuildWonderFragment(null, null);
	}
	
	@Test
	public void testlistMoveBuildWonderFragment_whenNotEnoughCards() {
		//Given
		PlayerStateInternal state = new PlayerStateInternal("player0",Wonder.Alexandrie, new ArrayList(), new ArrayList(),0, new ArrayList()); 
		//When
		val res = GameStepUtils.listMoveBuildWonderFragment(state,Wonder.Alexandrie.fragments.get(0));
		//Then
		Assert.assertEquals(0, res.size());
	}
	@Test
	public void testlistMoveBuildWonderFragment_whenHavingTwoDifferentCards() {
		//Given
		val availableCards = new ArrayList <Card>();
		availableCards.add(new Card(CardType.CardMaterialBrick, null));
		availableCards.add(new Card(CardType.CardMaterialGlass, null));
		PlayerStateInternal state = new PlayerStateInternal("player0",Wonder.Alexandrie, new ArrayList(), new ArrayList(),0, availableCards); 
		//When
		val res = GameStepUtils.listMoveBuildWonderFragment(state,Wonder.Alexandrie.fragments.get(0));
		//Then
		Assert.assertEquals(1, res.size());
	}
}
