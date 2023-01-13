package fr.isep.game7WonderArch.domain;

import lombok.Builder;

@Builder
public class Toto {

	private final int x;
	private final int y;
	
	
	public static void test() {
		Toto t = Toto.builder().x(10).y(15).build();
	}
}
