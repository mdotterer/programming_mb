package rpsls;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Match {
	public Player player1;
	public Player player2;
	public int bestOf;
	
	private List<Round> rounds;
	private int[] winCounts;
	
	private Player coinFlipWinner;
	
	private static Random rand = new Random();
	
	private int bracketRound;
		
	public Match(Player player1, Player player2, int bestOf) {
		this.bestOf = bestOf;
		this.player1 = player1;
		this.player2 = player2;
		rounds = new ArrayList<Round>();
		winCounts = new int[] {0,0,0};
		
		player1.matchStarted(player2.name());
		player2.matchStarted(player1.name());
		
		while(winCounts[1] <= (bestOf / 2) && winCounts[2] <= (bestOf / 2) && rounds.size() < bestOf * 100) {
			Round newRound = new Round(player1.chooseThrow(), player2.chooseThrow()); 
			rounds.add(newRound);
			player1.roundOver(newRound);
			player2.roundOver(newRound.reverse());
			winCounts[newRound.winner()] += 1;
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
		} else if(coinFlipWinner != null){
			return coinFlipWinner;
		} else {
			coinFlipWinner = rand.nextBoolean() ? player1 : player2; 
			return coinFlipWinner;
		}
	}
	
	public boolean wasTie() {
		return (player1WinCount() == player2WinCount());
	}
	
	public int getRoundCount() {
		return rounds.size();
	}
	
	public Round getRound(int index) {
		return rounds.get(index);
	}
	
	public int getBracketRound() {
		return bracketRound;
	}
	
	public void setBracketRound(int newBracketRound) {
		bracketRound = newBracketRound;
	}
}
