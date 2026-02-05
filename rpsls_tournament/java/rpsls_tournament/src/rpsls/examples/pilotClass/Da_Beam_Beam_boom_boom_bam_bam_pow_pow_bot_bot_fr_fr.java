package rpsls.examples.pilotClass;
import java.util.Random;

import rpsls.Player;
import rpsls.Round;
import rpsls.Throw;
public class Da_Beam_Beam_boom_boom_bam_bam_pow_pow_bot_bot_fr_fr implements Player {
	private Throw lastthrow;
	private Random rand=new Random();
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Da beam bot fr fr :]";
	}

	@Override
	public Throw chooseThrow() {
		{
			int r = rand.nextInt(5);
			if (r==0) {return Throw.spock();}
			if (r==1) {return Throw.lizard();}
			if (r==2) {return Throw.scissors();}
			if (r==3) {return Throw.rock();}
			return Throw.paper();
			} 
		}

	@Override
	public void roundOver(Round round) {
		lastthrow=round.throwB;
	}

}
