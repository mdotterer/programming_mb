package rpsls;

public interface Player {
	public String name();
	
	public Throw chooseThrow();
	
	public void roundOver(Round round);
}
