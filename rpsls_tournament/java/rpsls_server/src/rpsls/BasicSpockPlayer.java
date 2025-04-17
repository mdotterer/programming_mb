package rpsls;

public class BasicSpockPlayer implements Player {

	@Override
	public String name() {
		return "I <3 Spock";
	}

	@Override
	public Throw chooseThrow() {
		return Throw.spock();
	}

	@Override
	public void roundOver(Round round) {
	}
}
