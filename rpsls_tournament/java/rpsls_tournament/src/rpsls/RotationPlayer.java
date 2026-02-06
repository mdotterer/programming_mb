package rpsls;

public class RotationPlayer implements Player {
	private String myName;
	private int index;
	private Throw[] rotation;
	
	public RotationPlayer(String myName, Throw[] rotation) {
		this.myName = myName;
		this.rotation = rotation;
		index = 0;
	}

	@Override
	public String name() {
		return myName;
	}

	@Override
	public Throw chooseThrow() {
		return rotation[index++ % rotation.length];
	}

	@Override
	public void roundOver(Round round) {
		// TODO Auto-generated method stub

	}

	@Override
	public void matchStarted(String opponentName) {
		// TODO Auto-generated method stub
		
	}
	

}
