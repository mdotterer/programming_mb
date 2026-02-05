package rpsls;

import java.util.ArrayList;
import java.util.List;

import rpsls.examples.pilotClass.BakerMayfieldUniversity;
import rpsls.examples.pilotClass.Da_Beam_Beam_boom_boom_bam_bam_pow_pow_bot_bot_fr_fr;
import rpsls.examples.pilotClass.JoshuasRPSSLrobot;
import rpsls.examples.pilotClass.NATHANDOTTERERALGORITHMwefbgrtgh;
import rpsls.examples.pilotClass.amelia_hazel_dotterer;

public class PlayerRoster {
	public enum Category { Current, Stock, Example }
	
	private List<Player> registeredPlayers = new ArrayList<Player>();
	
	public void register(Player newPlayer) {
		registeredPlayers.add(newPlayer);
	}
	
	public Player get(int playerIndex) {
		return registeredPlayers.get(playerIndex);
	}
	
	public List<String> getPlayerNames() {
		List<String> results = new ArrayList<String>();
		registeredPlayers.forEach(p -> results.add(p.name()));
		return results;
	}
	
	public PlayerRoster unusedRoster(List<Player> currentPlayers) {
		List<Player> results = new ArrayList<Player>();
		
		registeredPlayers.forEach(player -> {
			if(currentPlayers.indexOf(player) < 0) {
				results.add(player);
			}	
		});
		
		return new PlayerRoster(results);
	}
	
	public int size() {
		return registeredPlayers.size();
	}
	
	public PlayerRoster(Category category) {
		buildRoster(new Category[] {category});
	}
	
	public PlayerRoster(Category[] categories) {
		buildRoster(categories);
	}
	
	public PlayerRoster(List<Player> startList) {
		registeredPlayers.addAll(startList);
	}
	
	private void buildRoster(Category[] categories) {
		for(int i=0; i<categories.length; i++) {
			switch(categories[i]) {
			case Current:
				register(new MyPlayer());
			case Stock:
				register(new ConstantPlayer(Throw.rock()));
				register(new ConstantPlayer(Throw.paper()));
				register(new ConstantPlayer(Throw.scissors()));
				register(new ConstantPlayer(Throw.lizard()));
				register(new ConstantPlayer(Throw.spock()));
				register(new RotationPlayer("Alfa", new Throw[]{Throw.rock(), Throw.paper(), Throw.scissors()}));
				register(new RotationPlayer("Bravo", new Throw[]{Throw.lizard(), Throw.spock()}));
                register(new RotationPlayer("Charlie", new Throw[]{Throw.paper(), Throw.spock(), Throw.rock(), Throw.paper()}));
				register(new RotationPlayer("Delta", new Throw[]{Throw.scissors(), Throw.paper(), Throw.spock(), Throw.spock()}));
				register(new RotationPlayer("Echo", new Throw[]{Throw.lizard(),Throw.lizard(),Throw.lizard(),Throw.spock()}));
			case Example:
				register(new NATHANDOTTERERALGORITHMwefbgrtgh());
				register(new BakerMayfieldUniversity());
				register(new Da_Beam_Beam_boom_boom_bam_bam_pow_pow_bot_bot_fr_fr());
				register(new amelia_hazel_dotterer());
				register(new JoshuasRPSSLrobot());
			}
		}
	}
}
