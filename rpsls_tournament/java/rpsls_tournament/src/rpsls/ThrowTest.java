package rpsls;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ThrowTest {
	
	void assertTies(Throw throwA, Throw throwB) {
		assertTrue(throwA.equals(throwB));
		assertFalse(throwA.beats(throwB));		
	}
	
	void assertLoses(Throw throwA, Throw throwB) {
		assertFalse(throwA.equals(throwB));
		assertFalse(throwA.beats(throwB));		
	}
	
	void assertBeats(Throw throwA, Throw throwB) {
		assertFalse(throwA.equals(throwB));
		assertTrue(throwA.beats(throwB));		
	}

	@Test
	void testRockVRock() {
		assertTies(Throw.rock(), Throw.rock());
	}
	
	@Test
	void testRockVPaper() {
		assertLoses(Throw.rock(), Throw.paper());
	}
	
	@Test
	void testRockVScissors() {
		assertBeats(Throw.rock(), Throw.scissors());
	}
	
	@Test
	void testRockVLizard() {
		assertBeats(Throw.rock(), Throw.lizard());
	}
	
	@Test
	void testRockVSpock() {
		assertLoses(Throw.rock(), Throw.spock());
	}

	@Test
	void testPaperVRock() {
		assertBeats(Throw.paper(), Throw.rock());
	}
	
	@Test
	void testPaperVPaper() {
		assertTies(Throw.paper(), Throw.paper());
	}
	
	@Test
	void testPaperVScissors() {
		assertLoses(Throw.paper(), Throw.scissors());
	}
	
	@Test
	void testPaperVLizard() {
		assertLoses(Throw.paper(), Throw.lizard());
	}
	
	@Test
	void testPaperVSpock() {
		assertBeats(Throw.paper(), Throw.spock());
	}
	
	@Test
	void testScissorsVRock() {
		assertLoses(Throw.scissors(), Throw.rock());
	}
	
	@Test
	void testScissorsVPaper() {
		assertBeats(Throw.scissors(), Throw.paper());
	}
	
	@Test
	void testScissorsVScissors() {
		assertTies(Throw.scissors(), Throw.scissors());
	}
	
	@Test
	void testScissorsVLizard() {
		assertBeats(Throw.scissors(), Throw.lizard());
	}
	
	@Test
	void testScissorsVSpock() {
		assertLoses(Throw.scissors(), Throw.spock());
	}

	@Test
	void testLizardVRock() {
		assertLoses(Throw.lizard(), Throw.rock());
	}
	
	@Test
	void testLizardVPaper() {
		assertBeats(Throw.lizard(), Throw.paper());
	}
	
	@Test
	void testLizardVScissors() {
		assertLoses(Throw.lizard(), Throw.scissors());
	}
	
	@Test
	void testLizardVLizard() {
		assertTies(Throw.lizard(), Throw.lizard());
	}
	
	@Test
	void testLizardVSpock() {
		assertBeats(Throw.lizard(), Throw.spock());
	}

	@Test
	void testSpockVRock() {
		assertBeats(Throw.spock(), Throw.rock());
	}
	
	@Test
	void testSpockVPaper() {
		assertLoses(Throw.spock(), Throw.paper());
	}
	
	@Test
	void testSpockVScissors() {
		assertBeats(Throw.spock(), Throw.scissors());
	}
	
	@Test
	void testSpockVLizard() {
		assertLoses(Throw.spock(), Throw.lizard());
	}
	
	@Test
	void testSpockVSpock() {
		assertTies(Throw.spock(), Throw.spock());
	}
}
