package rpsls;

public class Round {
	public Throw throwA;
	public Throw throwB;
	
	public Round(Throw throwA, Throw throwB) {
		this.throwA = throwA;
		this.throwB = throwB;
	}
	
	public static final String[][] verbs = {
		//ROCK            SCISSORS             LIZARD            PAPER              SPOCK
		{"bounces off",   "crushes",           "crushes",        "is covered by",   "is vaporized by"}, // ROCK
		{"is crushed by", "clangs against",    "decapitates",    "cuts",            "is smashed by"}, // SCISSORS
		{"is crushed by", "is decapitated by", "stares at",      "eats",            "poisons"}, // LIZARD
		{"covers",        "is cut by",         "is eaten by",    "stacks with",     "disproves"}, //PAPER
		{"vaporizes",     "smashes",           "is poisoned by", "is disproved by", "waves at"} // SPOCK 
	};
	
	public boolean isTie() {
		return throwA.equals(throwB);
	}
	
	public int winner() {
		if(throwA.beats(throwB)) {
			return 1;
		} else if(throwB.beats(throwA)) {
			return 2;
		} else {
			return 0;
		}
	}
	
	public Round reverse() {
		return new Round(throwB, throwA);
	}
	
	public String toString() {
		return throwA.toString() + " " + verbs[throwA.throwId][throwB.throwId] + " " + throwB.toString();
	}
}

// Rock > Scissors, Lizard
// Scissors > Lizard, Paper
// Lizard > Paper, Spock
// Paper > Spock, Rock
// Spock > Rock, Scissors