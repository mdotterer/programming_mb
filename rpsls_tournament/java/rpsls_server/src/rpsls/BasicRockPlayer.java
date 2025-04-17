package rpsls;

public class BasicRockPlayer implements Player {

	@Override
	public String name() {
		return "Earth Bender";
	}

	@Override
	public Throw chooseThrow() {
		return Throw.rock();
	}

	@Override
	public void roundOver(Round round) {
		// TODO Auto-generated method stub
	}

}
