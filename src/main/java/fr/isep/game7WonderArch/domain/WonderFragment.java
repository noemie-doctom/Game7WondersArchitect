package fr.isep.game7WonderArch.domain;

public class WonderFragment {
	public final String imageResource;
	public final int materialCounter;
	public final boolean sameMaterial;
	public final boolean triggerEffect;
	public final int trophyCount;
	public final int heightLevel;
	
	public WonderFragment(String imageResource, int materialCounter, boolean sameMaterial, boolean triggerEffect,
			int trophyCount, int heightLevel) {
		super();
		this.imageResource = imageResource;
		this.materialCounter = materialCounter;
		this.sameMaterial = sameMaterial;
		this.triggerEffect = triggerEffect;
		this.trophyCount = trophyCount;
		this.heightLevel = heightLevel;
	}
public boolean getSameMaterial() {
	return sameMaterial;
}
}
