package ueb10.bremsen;

public class Cantileverbremse extends Bremse {
	private static final int MAX_BELAG = 5;
	private static final int MIN_BELAG = 1;

	private int belagLinks;
	private int belagRechts;

	public Cantileverbremse() {
		super("Meh", "123");
		this.belagLinks = this.belagRechts = MAX_BELAG;
	}

	public void bremsen() {
		System.out.println("Cantileverbremse bremst!");
	}

	public boolean brauchtService() {
		return belagLinks > MIN_BELAG && belagRechts > MIN_BELAG;
	}

	public String toString() {
		return "Cantileverbremse";
	}
}
