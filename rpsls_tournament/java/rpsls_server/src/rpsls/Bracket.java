package rpsls;

public class Bracket {
	public Player[] players;
	
	public Match[] matches;
	
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
	
	public Bracket(int rounds, Player[] players) {		
		int playerCount = 2 << (rounds-1);
		
		this.players = new Player[playerCount];
		
		for(int seed=0; seed < playerCount; seed++) {
			int p = pollPosition(seed, playerCount);
			if(seed < players.length) {
				this.players[p] = players[seed];
			} else {
				this.players[p] = new ConstantPlayer();
			}
		}
		
		matches = new Match[playerCount-1];
		
		Player[] activePlayers = players;
		
		while(activePlayers.length > 1) {
			Player[] winningPlayers = new Player[activePlayers.length >> 1];
			for(int i=0; i < winningPlayers.length; i++) {
				
			}
		}
	}
}
