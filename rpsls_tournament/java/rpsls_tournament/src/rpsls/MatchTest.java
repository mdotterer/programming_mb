package rpsls;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatchTest {

	@Test
	void testBasicRockBasicSpock() {
		Player rockPlayer = new ConstantPlayer(Throw.rock());
		Player spockPlayer = new ConstantPlayer(Throw.spock());
		Match match = new Match(rockPlayer, spockPlayer, 3);
		
		assertEquals(spockPlayer, match.winner());
		assertEquals(0, match.player1WinCount());
		assertEquals(2, match.player2WinCount());
	}
	
	@Test
	void testIdenticalStrategies() {
		Player player1 = new ConstantPlayer(Throw.lizard());
		Player player2 = new ConstantPlayer(Throw.lizard());
		Match match = new Match(player1, player2, 3);
		
		assertTrue(match.wasTie());
		assertNotNull(match.winner());		
	}
	
	@Test
	void testCommonTieStrategies() {
		Player player1 = new RotationPlayer("Classic", new Throw[] {Throw.rock(), Throw.paper(), Throw.scissors()});
		Player player2 = new RotationPlayer("Other", new Throw[] {Throw.spock(), Throw.paper(), Throw.lizard()});
		Match match = new Match(player1, player2, 3);
		
		assertEquals(player2, match.winner());
		assertEquals(1, match.player1WinCount());
		assertEquals(2, match.player2WinCount());
		assertEquals(1, match.tieCount());
	}
	
	@Test
	void testNullPlayer1() {
		Player player1 = new RotationPlayer("Broken", new Throw[] {null});
		Player player2 = new ConstantPlayer(Throw.lizard());
		Match match = new Match(player1, player2, 3);
		
		assertEquals(player2, match.winner());
		assertEquals(0, match.player1WinCount());
		assertEquals(2, match.player2WinCount());
		assertEquals(0, match.tieCount());
	}
	
	@Test
	void testNullPlayer2() {
		Player player1 = new ConstantPlayer(Throw.rock());
		Player player2 = new RotationPlayer("Broken", new Throw[] {null});
		Match match = new Match(player1, player2, 3);
		
		assertEquals(player1, match.winner());
		assertEquals(2, match.player1WinCount());
		assertEquals(0, match.player2WinCount());
		assertEquals(0, match.tieCount());
	}
	
	@Test
	void testDualNullPlayers() {
		Player player1 = new RotationPlayer("Tweedledee", new Throw[] {null});
		Player player2 = new RotationPlayer("Tweedledum", new Throw[] {null});
		Match match = new Match(player1, player2, 3);
		
		assertNotNull(match.winner());
		assertEquals(0, match.player1WinCount());
		assertEquals(0, match.player2WinCount());
		assertEquals(300, match.tieCount());
		assertTrue(match.wasTie());
	}
}
