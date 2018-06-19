package ueb10.formen;

public class Quader extends Volumen {
	double a, b;

	public Quader(double a, double b, double h) {
		super(h);
		this.a = a;
		this.b = b;
	}

	public double grundflaeche() {
		return a * b;
	}
}
