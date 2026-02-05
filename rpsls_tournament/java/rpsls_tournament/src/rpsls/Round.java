package rpsls;

public class Round {
	public Throw throwA;
	public Throw throwB;
	
	public Round(Throw throwA, Throw throwB) {
		this.throwA = throwA;
		this.throwB = throwB;
	}
	
	public static final String[][] verbs = {
		//ROCK            SCISSORS             LIZARD            PAPER              SPOCK              NOTHING
		{"bounces off",   "crushes",           "crushes",        "is covered by",   "is vaporized by", "rocks"}, // ROCK
		{"is crushed by", "clangs against",    "decapitates",    "cuts",            "is smashed by",   "cuts"}, // SCISSORS
		{"is crushed by", "is decapitated by", "stares at",      "eats",            "poisons",         "crushes"}, // LIZARD
		{"covers",        "is cut by",         "is eaten by",    "stacks with",     "disproves",       "disproves"}, //PAPER
		{"vaporizes",     "smashes",           "is poisoned by", "is disproved by", "waves at",        "yawns at"}, // SPOCK 
		{"is rocked by",  "is cut by",         "is crushed by",  "is disproved by", "yawns at",        "bores"}, // NOTHING 
	};
	
	public boolean isTie() {
		return throwA.equals(throwB);
	}
	
	public int winner() {
		
		if(throwA != null && throwA.beats(throwB)) {
			return 1;
		} else if(throwB != null && throwB.beats(throwA)) {
			return 2;
		} else {
			return 0;
		}
	}
	
	public Round reverse() {
		return new Round(throwB, throwA);
	}
	
	public String toString() {
		String throwAString = throwA != null ? throwA.toString() : "Nothing"; 
		String throwBString = throwB != null ? throwB.toString() : "Nothing"; 
		
		int throwAId = throwA != null ? throwA.throwId : 5;
		int throwBId = throwB != null ? throwB.throwId : 5;
		

		return throwAString + " " + verbs[throwAId][throwBId] + " " + throwBString;
	}
}

// Rock > Scissors, Lizard
// Scissors > Lizard, Paper
// Lizard > Paper, Spock
// Paper > Spock, Rock
// Spock > Rock, Scissors