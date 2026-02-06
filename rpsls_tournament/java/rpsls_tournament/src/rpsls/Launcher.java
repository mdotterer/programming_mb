package rpsls;

import java.util.ArrayList;
import java.util.List;

public class Launcher {
	
	public static final int bestOf = 101;
		
	public static void main(String[] args) throws InterruptedException {
		InputHandler input = new InputHandler();
				
		PlayerRoster roster = new PlayerRoster(new PlayerRoster.Category[] {
				PlayerRoster.Category.Current,
				PlayerRoster.Category.Stock,
//				PlayerRoster.Category.Example
		});

		Runner runner;
		
		int choice;
		
		choice = input.prompt("What do you want to run?", new String[] {
				"A Face Off between two teams",
				"A Tournament"
		});
		
		if(choice == 1) {
			Player playerA = input.pickPlayer("Pick Player 1:", roster);
			Player playerB = input.pickPlayer("Pick Player 2:", roster);
			 
			runner = new MatchRunner(new Match(playerA, playerB, bestOf));
		} else {
			List<Player> players = new ArrayList<Player>();
			while(players.size() < roster.size()) {
				players.add(input.pickPlayer(
						"Who gets seed #" + String.valueOf(players.size()+1) + "?",
						roster.unusedRoster(players)));
			}	
			
			runner = new BracketRunner(new Bracket(players.toArray(new Player[] {}), bestOf, true));

		}
		runner.run(input);
	}
}
