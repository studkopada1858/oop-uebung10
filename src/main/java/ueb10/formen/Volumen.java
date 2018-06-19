package ueb10.formen;

public abstract class Volumen {
	private double h;

	public Volumen(double h) {
		this.h = h;
	}

	public double volumen() {
		return grundflaeche() * h;
	}

	public abstract double grundflaeche();
}
