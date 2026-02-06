package rpsls;

import java.util.List;
import java.util.Scanner;

public class InputHandler {
	public Scanner scanner = new Scanner(System.in);
	
	public void waitForInput() {
		scanner.nextLine();
	}
	
	public int prompt(String query, String[] options) {
		System.out.println(query);
		
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
	
	public Player pickPlayer(String query, PlayerRoster roster) {
		int choice = prompt(query,
				roster.getPlayerNames().toArray(new String[] {})
		);
		return roster.get(choice-1);			
	}
	
	public Player pickPlayer(String query, PlayerRoster roster, String nullOption) {
		List<String> optionList = roster.getPlayerNames();
		optionList.add(nullOption);
				
		int choice = prompt(query, optionList.toArray(new String[] {}));
		if(choice <= roster.size()) {
			return roster.get(choice-1);
		} else {
			return null;
		}
	}
}
