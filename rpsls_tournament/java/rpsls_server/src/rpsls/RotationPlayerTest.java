package rpsls;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RotationPlayerTest {

	@Test
	void test() {
		Player player = new RotationPlayer("Classic", new Throw[] {Throw.rock(), Throw.paper(), Throw.scissors()});

		assertEquals("Classic", player.name());
		assertEquals(Throw.rock(), player.chooseThrow());
		assertEquals(Throw.paper(), player.chooseThrow());
		assertEquals(Throw.scissors(), player.chooseThrow());
		assertEquals(Throw.rock(), player.chooseThrow());
		assertEquals(Throw.paper(), player.chooseThrow());
		assertEquals(Throw.scissors(), player.chooseThrow());
		assertEquals(Throw.rock(), player.chooseThrow());
		assertEquals(Throw.paper(), player.chooseThrow());
		assertEquals(Throw.scissors(), player.chooseThrow());
	}

}
