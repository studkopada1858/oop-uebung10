package ueb10.bremsen;

public abstract class Bremse {
	private String hersteller;
	private String seriennummer;

	public Bremse(String hersteller, String seriennummer) {
		this.hersteller = hersteller;
		this.seriennummer = seriennummer;
	}

	public String getHersteller() {
		return hersteller;
	}

	public String getSeriennummer() {
		return seriennummer;
	}

	public abstract void bremsen();
	public abstract boolean brauchtService();
}
