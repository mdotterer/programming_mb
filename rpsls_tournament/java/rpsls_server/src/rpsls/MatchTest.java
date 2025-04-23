package rpsls;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatchTest {

	@Test
	void testBasicRockBasicSpock() {
		Player rockPlayer = new BasicPlayer(Throw.rock());
		Player spockPlayer = new BasicPlayer(Throw.spock());
		Match match = new Match(rockPlayer, spockPlayer, 3);
		
		assertEquals(spockPlayer, match.winner());
		assertEquals(0, match.player1WinCount());
		assertEquals(2, match.player2WinCount());
	}

}
