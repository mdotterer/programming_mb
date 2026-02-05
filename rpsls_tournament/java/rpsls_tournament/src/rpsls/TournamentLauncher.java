package rpsls;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TournamentLauncher {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void waitForInput() {
		scanner.nextLine();
	}
	
	public static int prompt(String question, String[] options) {
		System.out.println(question);
		
		for(int i = 0; i < options.length; i++) {
			System.out.println(String.valueOf(i+1) + ") " + options[i]);
		}
		
		int choice = 0;
		
		while(choice < 1 || choice > options.length) {
			System.out.print("> ");
			choice = scanner.nextInt();
		}
		
		return choice;
	}
	
	public static String bracketName(String fullName) {
		if(fullName.length() > 16) {
			return fullName.substring(0,16);
		} else if(fullName.length() < 16) {
			return String.format("%-16s", fullName);
		} else {
			return fullName;
		}
	}
	
	public static String bracketLine(Bracket bracket, int line, int maxRound) {
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
	
	public static void displayBracketAfterRound(Bracket bracket, int round) {
		for(int l = 0; l < bracket.players.length * 2 - 1; l++) {
			System.out.println(bracketLine(bracket, l, round));
		}
	}

	public static void main(String args[]) throws InterruptedException {
		int playerChoice = prompt("What players do you want to pick from?", new String[] {
				"Current Participants Only",
				"Stock Participants Only",
				"Current & Stock Participants",
				"Example Participants Only",
				"Current & Example Participants",
				"Stock & Example Participants",
				"Current, Stock, & Example Participants"
		});
		
		List<PlayerRoster.Category> categories = new ArrayList<PlayerRoster.Category>();
		if((playerChoice & 1) > 0) { categories.add(PlayerRoster.Category.Current); } 
		if((playerChoice & 2) > 0) { categories.add(PlayerRoster.Category.Stock); }
		if((playerChoice & 4) > 0) { categories.add(PlayerRoster.Category.Example); }
		
		PlayerRoster roster = new PlayerRoster(categories.toArray(new PlayerRoster.Category[] {}));
		
		List<Player> players = new ArrayList<Player>();
				
		while(players.size() < roster.size()) {
			PlayerRoster reducedRoster = roster.unusedRoster(players);
			playerChoice = prompt("Who gets seed #" + String.valueOf(players.size()+1) + "?",
					reducedRoster.getPlayerNames().toArray(new String[] {})
			);
			players.add(reducedRoster.get(playerChoice-1));
		}
				
		
		Bracket bracket = new Bracket(players.toArray(new Player[] {}), 101, true);
		
		System.out.println("Running Tournament!");
		
		for(int i=0; i<bracket.matches.size(); i++) {
			Match match = bracket.matches.get(i);
			displayBracketAfterRound(bracket, i);
			System.out.println(String.format("Match #%d", i+1));
			System.out.println(match.player1.name() + " vs. " + match.player2.name());
			waitForInput();
			for(int j=0; j<match.getRoundCount(); j++) {
				System.out.println(match.getRound(j).toString());
				Thread.sleep(Math.round(1000.0/(Math.pow(j+1,2))));
			}
			if(match.wasTie()) {
				System.out.println("Tie! Coin flip will decide the winner...");
				Thread.sleep(2000);
			}
			System.out.println(match.winner().name() + " wins!");
			waitForInput();
		}
		
		System.out.println(bracket.getWinner().name() + " has won the tournament!");
	}
}
