package rpsls;

public class ConstantPlayer implements Player {

	private Throw myFavoriteThrow;
	
	private static int nextThrow = 0;
	
	private static String[] names = {"The Boulder", "Fiskars", "Dinosaur", "Dunder Mifflin", "Leanord Nimoy"};
		
	public ConstantPlayer() {
		this(new Throw(nextThrow++ % 5));
	}
	
	public ConstantPlayer(Throw throw1) {
		myFavoriteThrow = throw1;
	}

	@Override
	public String name() {
		return names[myFavoriteThrow.throwId];
	}

	@Override
	public Throw chooseThrow() {
		return myFavoriteThrow;
	}

	@Override
	public void roundOver(Round round) {
	}
}
