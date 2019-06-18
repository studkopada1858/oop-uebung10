package ueb10.formen;

public class ZylindrischesRohr extends Volumen {
	double r1;
	double r2;

	@Override
	public double grundflaeche() {
		return Math.PI*r1*r1-Math.PI*r2*r2;
	}

	public ZylindrischesRohr(double r1, double r2, double h) {
	this.r1=r1;
	this.r2=r2;
	super.hoehe=h;
	}
}
