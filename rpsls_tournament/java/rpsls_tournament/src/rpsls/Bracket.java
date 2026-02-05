package rpsls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Bracket {
	public Player[] players;
	
	public List<Match> matches;
	
	private Player winner;
	
	public static int pollPosition(int seed, int total) {
		if(total < 2) {
			return 0;
		}
		if(seed < total >> 1) {
			return pollPosition(seed, total >> 1) << 1;
		} else {
			return (pollPosition((total - seed - 1), total >> 1) << 1) + 1;
		}
	}
	
	public Bracket(Player[] players, int startRounds, boolean softStart) {
		int bracketRounds = softStart ? 1 : 0;
		int remaining = players.length;
		while(remaining > 0) {
			bracketRounds++;
			remaining >>= 1;
		}
		int playerCount = 2 << (bracketRounds-1);
		
		this.players = new Player[playerCount];
		
		for(int seed=0; seed < playerCount; seed++) {
			int p = pollPosition(seed, playerCount);
			if(seed < players.length) {
				this.players[p] = players[seed];
			} else {
				this.players[p] = new ConstantPlayer();
			}
		}
		
		matches = new ArrayList<Match>();
		
		List<Player> activePlayers = new ArrayList<Player>(Arrays.asList(this.players));
		
		int roundCount = startRounds;
		int bracketRound = 0;
		
		while(activePlayers.size() > 1) {
			List<Player> winningPlayers = new ArrayList<Player>();
			for(int i=0; i < activePlayers.size() >> 1; i++) {
				Player player1 = activePlayers.get(2*i);
				Player player2 = activePlayers.get(2*i+1);
				Match match = new Match(player1, player2, roundCount);
				match.setBracketRound(bracketRound);
				
				matches.add(match);
				
				if(match.winner() != null) {
					winningPlayers.add(match.winner());
				} else {	
					// Coin flip
					if(new Random().nextInt(2) == 0) {
						winningPlayers.add(player1);
					} else {
						winningPlayers.add(player2);
					}
				}
			}
			
			activePlayers = winningPlayers;
			roundCount = (roundCount+1) << 2  - 1;
			bracketRound++;
		}
		
		winner = activePlayers.get(0);
	}
		
	public Player getWinner() {
		return winner;
	}
}
