package ueb10.formen;

public class ZylindrischesRohr extends Volumen {
	private double r1, r2;

	public ZylindrischesRohr(double r1, double r2, double h) {
		super(h);
		this.r1 = Math.max(r1, r2);
		this.r2 = Math.min(r1, r2);
	}

	public double grundflaeche() {
		return (r1 * r1 - r2 * r2) * Math.PI;
	}
}
