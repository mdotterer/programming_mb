package rpsls.examples.pilotClass;

import rpsls.Player;
import rpsls.Round;
import rpsls.Throw;

public class NATHANDOTTERERALGORITHMwefbgrtgh implements Player {

	int Prev=0;
	@Override
	public String name() {
		return "mun";
	}

	@Override
	public Throw chooseThrow() {
		if(Prev==0) {
			Prev=1;
			return Throw.rock();
		} else {
			Prev=0;
			return Throw.scissors();
		}
	}

	@Override
	public void roundOver(Round round) {
	}

	@Override
	public void matchStarted(String opponentName) {
		// TODO Auto-generated method stub
		
	}
}
