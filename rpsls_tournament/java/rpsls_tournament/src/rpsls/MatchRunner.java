package rpsls;

public class MatchRunner implements Runner {
	private Match match;

	public MatchRunner(Match match) {
		this.match = match;
	}
	
	public void run(InputHandler input) throws InterruptedException {
		System.out.println(match.player1.name() + " vs. " + match.player2.name());
		input.waitForInput();
		for(int j=0; j<match.getRoundCount(); j++) {
			System.out.println(match.getRound(j).toString());
			Thread.sleep(Math.round(1000.0/(Math.pow(j+1,2))));
		}
		if(match.wasTie()) {
			System.out.println("Tie! Coin flip will decide the winner...");
			Thread.sleep(2000);
		}
		System.out.println(match.winner().name() + " wins!");		
	}
}
