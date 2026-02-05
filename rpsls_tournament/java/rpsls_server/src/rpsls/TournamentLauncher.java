package rpsls;

import java.io.IOException;

public class TournamentLauncher {
	public static void main(String args[]) throws InterruptedException {
		Player[] players = {
			new RotationPlayer("Alfa", new Throw[]{Throw.rock(), Throw.paper(), Throw.scissors()}),
			new RotationPlayer("Bravo", new Throw[]{Throw.lizard(), Throw.spock()}),
			new RotationPlayer("Charlie", new Throw[]{Throw.paper(), Throw.spock(), Throw.rock(), Throw.paper()}),
			new RotationPlayer("Delta", new Throw[]{Throw.scissors(), Throw.paper(), Throw.spock(), Throw.spock()}),
			new RotationPlayer("Echo", new Throw[]{Throw.lizard(),Throw.lizard(),Throw.lizard(),Throw.spock()})
		};
		
		Bracket bracket = new Bracket(3, 101, players);
		
		System.out.println("Running Tournament!");
		
		for(int i=0; i<bracket.matches.size(); i++) {
			Match match = bracket.matches.get(i);
			System.out.println(String.format("Match #%d", i+1));
			System.out.println(match.player1.name() + " vs. " + match.player2.name());
			Thread.sleep(2000);
			for(int j=0; j<match.getRoundCount(); j++) {
				Thread.sleep(100);
				System.out.println(match.getRound(j).toString());
			}
			if(match.winner() != null) {
				System.out.println(match.winner().name() + " wins!");
			} else {
				System.out.println("Tie! Coin flip will decide the winner...");
			}
			try {
				System.in.read();
			} catch (IOException e) {
				// Proceed to next match!
			}
		}
	}
}
