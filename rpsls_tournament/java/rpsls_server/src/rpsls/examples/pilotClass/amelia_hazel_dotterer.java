package rpsls.examples.pilotClass;

import rpsls.Player;
import rpsls.Round;
import rpsls.Throw;

public class amelia_hazel_dotterer implements Player {
	private Throw lastThrow;
	@Override
	public String name() {
		return "amelia :b";
	}

	@Override
	public Throw chooseThrow() {
		if(lastThrow == null) {
			return Throw.scissors();
		}
		if (lastThrow.equals(Throw.rock())){
			return Throw.spock();
		}
		if (lastThrow.equals(Throw.lizard())){
		 	return Throw.scissors();
		}
		if (lastThrow.equals(Throw.spock())){
			return Throw.paper();
		 }
		if (lastThrow.equals(Throw.scissors())){
			return Throw.rock();
			 }
		// if (lastThrow.equals(Throw.paper())){
		return Throw.lizard();
	}
	public void roundOver(Round round) {
	lastThrow=round.throwB;

	}

}
