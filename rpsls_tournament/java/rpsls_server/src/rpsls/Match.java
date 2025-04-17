package rpsls;

public class Match {
	public Player player1;
	public Player player2;
	public int bestOf;
	
	private Round[] rounds;
	private int[] winCounts;
	
	public Match(Player player1, Player player2, int bestOf) {
		this.bestOf = bestOf;
		this.player1 = player1;
		this.player2 = player2;
		rounds = new Round[bestOf];
		winCounts = new int[] {0,0,0};
		
		int winsNeeded;
		
		for(int i=0; i < bestOf; i++) {
			rounds[i] = new Round(player1.chooseThrow(), player2.chooseThrow());
			player1.roundOver(rounds[i]);
			player2.roundOver(rounds[i].reverse());
			winCounts[rounds[i].winner()] += 1;
			
			if(winCounts[1] > (winCounts[2] + bestOf - i - 1) ||
					winCounts[2] > (winCounts[1] + bestOf - i - i)) {
				break;
			}
		}
	}
	
	public int tieCount() {
		return winCounts[0];
	}
	
	public int player1WinCount() {
		return winCounts[1];
	}
	
	public int player2WinCount() {
		return winCounts[2];
	}
	
	public Player winner() {
		if(player1WinCount() > player2WinCount()) {
			return player1;
		} else if(player2WinCount() > player1WinCount()) {
			return player2;
		} else {
			return null;
		}
	}
}
