package rpsls;

public class Throw {
	int throwId;
	
	public Throw(int newThrowId) {
		throwId = newThrowId;
	}
	
	public static final String[] throwLabels = {"Rock", "Scissors", "Lizard", "Paper", "Spock"};
	
	public static Throw rock() {
		return new Throw(0);
	}

	public static Throw paper() {
		return new Throw(3);
	}

	public static Throw scissors() {
		return new Throw(1);
	}

	public static Throw lizard() {
		return new Throw(2);
	}

	public static Throw spock() {
		return new Throw(4);
	}
	
	@Override
	public boolean equals(Object otherThrow) {
		if(!(otherThrow instanceof Throw)) { return false; }
		return this.throwId == ((Throw)otherThrow).throwId;
	}
	
	public boolean beats(Throw otherThrow) {
		if(otherThrow == null) {
			return true;
		}
		return !equals(otherThrow) && 
				(((5 + otherThrow.throwId - this.throwId) % 5) <= 2);
	}
	
	public String toString() {
		return throwLabels[throwId];
	}
}
