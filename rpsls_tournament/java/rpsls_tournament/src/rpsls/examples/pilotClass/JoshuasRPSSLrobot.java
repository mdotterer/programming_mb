package rpsls.examples.pilotClass;

import rpsls.Player;
import rpsls.Round;
import rpsls.Throw;

public class JoshuasRPSSLrobot implements Player {

	private int count=0;
	
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Josh's grillcheese turkey hot pocket bannnnnnannnnnnnnna banana win win win win win win win win win win win win win win win win win niw nwi inw RPSSL robot";
	}

	@Override
	public Throw chooseThrow() {
		if(count % 2 ==0) {
			return Throw.rock();
		} else {
			return Throw.spock();
		}
	
	}

	@Override
	public void roundOver(Round round) {
		// TODO Auto-generated method stub
count ++;
	}

}
