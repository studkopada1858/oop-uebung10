package ueb10.bremsen;

public abstract class Bremse {
	private String hersteller;
	private String serienNummer;
	public abstract void bremsen();
	public abstract boolean brauchtService();

	public Bremse (String hersteller,String serienNummer) {
		this.hersteller = hersteller;
		this.serienNummer=serienNummer;
	}

}
