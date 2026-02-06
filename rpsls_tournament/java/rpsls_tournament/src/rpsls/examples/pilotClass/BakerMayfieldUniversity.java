package rpsls.examples.pilotClass;

import rpsls.Player;
import rpsls.Round;
import rpsls.Throw;

public class BakerMayfieldUniversity implements Player {

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Nathan's scissorsy Team";
	}

	@Override
	public Throw chooseThrow() {
		// TODO Auto-generated method stub
		return Throw.scissors();
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
