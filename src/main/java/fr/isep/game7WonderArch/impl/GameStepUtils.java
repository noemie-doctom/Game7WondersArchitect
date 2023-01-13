package fr.isep.game7WonderArch.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import fr.isep.game7WonderArch.domain.GameMove.BuildWonderFragUsingCardsGameMode;
import fr.isep.game7WonderArch.domain.ImmutableMaterialCardByTypeCounts;
import fr.isep.game7WonderArch.domain.Material;
import fr.isep.game7WonderArch.domain.WonderFragment;
import lombok.val;

public class GameStepUtils {

	private static final ImmutableList<Material> materialExceptGolds = Material.allExceptGolds();

//	public static List<BuildWonderFragUsingCardsGameMode> listMoveBuildWonderFragment(
//			PlayerStateInternal p) {
//		
//	}
	
	public static List<BuildWonderFragUsingCardsGameMode> listMoveBuildWonderFragment(
			PlayerStateInternal p, WonderFragment frag) {
		val res = new ArrayList<BuildWonderFragUsingCardsGameMode>();
		val fragNeedSameMaterial = frag.isSameMaterial();
		val requiredCount = frag.materialRequiredCount;
		
		// available material card counts
		val availableMaterialCardCounts = p.getAvailableMaterialCardCounts();
		
		if (availableMaterialCardCounts.getTotalCount() < requiredCount) {
			return res;
		}
		
		if (fragNeedSameMaterial) {
			listMoveBuildWonderFragment_similarMaterial(frag, res, requiredCount, availableMaterialCardCounts);
		} else {
			val currUsedCounts = ImmutableMaterialCardByTypeCounts.builder();
			recursiveListMoveBuildWonderFragment_differentMaterials(res, frag, 0, // currMaterialIndex
					currUsedCounts, requiredCount, availableMaterialCardCounts);
		}
		return res;
	}

	private static void listMoveBuildWonderFragment_similarMaterial(WonderFragment frag,
			final List<BuildWonderFragUsingCardsGameMode> res,
			final int requiredCount,
			final ImmutableMaterialCardByTypeCounts availableMaterialCardCounts) {
		val goldCount = availableMaterialCardCounts.goldCount;
		for(val material: materialExceptGolds) {
			val count = availableMaterialCardCounts.get(material);
			if (count > 0) {
				if (count >= requiredCount) {
					// enough similar cards to build fragment
					val usedCards = ImmutableMaterialCardByTypeCounts.builder().with(material, requiredCount).build();
					res.add(new BuildWonderFragUsingCardsGameMode(frag, usedCards));
				} else if (count + goldCount >= requiredCount) {
					// complete with some joker Gold(s)
					val usedCards = ImmutableMaterialCardByTypeCounts.builder()
							.with(material, count)
							.with(Material.Gold, requiredCount-count)
							.build();
					res.add(new BuildWonderFragUsingCardsGameMode(frag, usedCards));
				}
			}
		}
		// special case for gold only ..
		if (goldCount >= requiredCount) {
			val usedCards = ImmutableMaterialCardByTypeCounts.builder().with(Material.Gold, requiredCount).build();
			res.add(new BuildWonderFragUsingCardsGameMode(frag, usedCards));
		}
	}

	private static void recursiveListMoveBuildWonderFragment_differentMaterials(
			List<BuildWonderFragUsingCardsGameMode> res, //
			WonderFragment frag,
			int currMaterialIndex, //
			ImmutableMaterialCardByTypeCounts.Builder currUsedCounts,
			int remainingRequiredTypeCount, // 
			ImmutableMaterialCardByTypeCounts materialCardCounts) {
		val material = materialExceptGolds.get(currMaterialIndex);
		val count = materialCardCounts.get(material);
		if (count > 0) {
			// selecting 1 card of this material
			val nextUsedCounts = currUsedCounts.cloneBuilderWithSelect(material);
			val nextRemainingRequiredTypes = remainingRequiredTypeCount - 1;
			if (nextRemainingRequiredTypes == 0) {
				// no need to recurse
				val usedCards = nextUsedCounts.build();
				res.add(new BuildWonderFragUsingCardsGameMode(frag, usedCards));
			} else {
				val nextIndex = currMaterialIndex + 1;
				if (nextIndex < materialExceptGolds.size()) {
					// recurse
					recursiveListMoveBuildWonderFragment_differentMaterials(res, frag,
							nextIndex, nextUsedCounts, nextRemainingRequiredTypes, materialCardCounts);
				}
				
			}
		} 
		// recurse when not selecting this material
		val nextIndex = currMaterialIndex + 1;
		if (nextIndex < materialExceptGolds.size()) {
			// recurse
			recursiveListMoveBuildWonderFragment_differentMaterials(res, frag,
					nextIndex, currUsedCounts, remainingRequiredTypeCount, materialCardCounts);
		}		
	}

}
