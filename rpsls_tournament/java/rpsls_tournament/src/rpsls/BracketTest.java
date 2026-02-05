package rpsls;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BracketTest {

	@Test
	void testPollPositions() {
		assertEquals(0, Bracket.pollPosition(0, 2));
		assertEquals(1, Bracket.pollPosition(1, 2));

		assertEquals(0, Bracket.pollPosition(0, 4));
		assertEquals(1, Bracket.pollPosition(3, 4));
		assertEquals(2, Bracket.pollPosition(1, 4));
		assertEquals(3, Bracket.pollPosition(2, 4));

		assertEquals(0, Bracket.pollPosition(0, 8));
		assertEquals(1, Bracket.pollPosition(7, 8));
		assertEquals(2, Bracket.pollPosition(3, 8));
		assertEquals(3, Bracket.pollPosition(4, 8));
		assertEquals(4, Bracket.pollPosition(1, 8));
		assertEquals(5, Bracket.pollPosition(6, 8));
		assertEquals(6, Bracket.pollPosition(2, 8));
		assertEquals(7, Bracket.pollPosition(5, 8));

		assertEquals( 0, Bracket.pollPosition( 0, 16));
		assertEquals( 1, Bracket.pollPosition(15, 16));
		assertEquals( 2, Bracket.pollPosition( 7, 16));
		assertEquals( 3, Bracket.pollPosition( 8, 16));
		assertEquals( 4, Bracket.pollPosition( 3, 16));
		assertEquals( 5, Bracket.pollPosition(12, 16));
		assertEquals( 6, Bracket.pollPosition( 4, 16));
		assertEquals( 7, Bracket.pollPosition(11, 16));
		assertEquals( 8, Bracket.pollPosition( 1, 16));
		assertEquals( 9, Bracket.pollPosition(14, 16));
		assertEquals(10, Bracket.pollPosition( 6, 16));
		assertEquals(11, Bracket.pollPosition( 9, 16));
		assertEquals(12, Bracket.pollPosition( 2, 16));
		assertEquals(13, Bracket.pollPosition(13, 16));
		assertEquals(14, Bracket.pollPosition( 5, 16));
		assertEquals(15, Bracket.pollPosition(10, 16));

	}

}
