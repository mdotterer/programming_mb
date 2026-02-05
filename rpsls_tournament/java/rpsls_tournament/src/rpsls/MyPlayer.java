package rpsls;

public class MyPlayer implements Player {

	private Throw lastThrow;
	
	@Override
	public String name() {
		return "YOUR NAME HERE"; 
	}

	@Override
	public Throw chooseThrow() {
		return null;
	}

	@Override
	public void roundOver(Round round) {
		// TODO Auto-generated method stub
		lastThrow = round.throwB;
	}

}
