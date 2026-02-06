package rpsls;


public class BracketRunner implements Runner {
	Bracket bracket;

	public String bracketName(String fullName) {
		if(fullName.length() > 16) {
			return fullName.substring(0,16);
		} else if(fullName.length() < 16) {
			return String.format("%-16s", fullName);
		} else {
			return fullName;
		}
	}
	
	public String bracketLine(int line, int maxRound) {
		String blankCell = "                   ";
		String result = ""; 
		int i = line;
		int remaining = bracket.players.length;
		int offset = 0;
		while(i >= 0) {
			if(i % 2 == 0) {
				int n = offset + i / 2;
				String connector = (((i >> 1) % 2) == 0 ? " \\ " : " / ");
				if(n < bracket.players.length) {
					return bracketName(bracket.players[n].name()) + connector;
				} else if(n - bracket.players.length < maxRound) {
					return result + bracketName(bracket.matches.get(n - bracket.players.length).winner().name()) + connector; 
				} else {
					return "";
				}
			} else {
				result += blankCell;
			}
			if(i == 0) {
				i = -1;
			} else {
				i >>= 1;
				offset += remaining;
				remaining >>= 1;
			}
		}
		return "";
	}
	
	public void displayBracketAfterRound(int round) {
		for(int l = 0; l < bracket.players.length * 2 - 1; l++) {
			System.out.println(bracketLine(l, round));
		}
	}

	public BracketRunner(Bracket bracket) {
		this.bracket = bracket;
	}
	
	public void run(InputHandler input) throws InterruptedException {				
		System.out.println("Running Tournament!");
		
		for(int i=0; i<bracket.matches.size(); i++) {
			Match match = bracket.matches.get(i);
			displayBracketAfterRound(i);
			System.out.println(String.format("Match #%d", i+1));
			MatchRunner runner = new MatchRunner(match);
			runner.run(input);
			input.waitForInput();
		}
		
		System.out.println(bracket.getWinner().name() + " has won the tournament!");
	}
}
