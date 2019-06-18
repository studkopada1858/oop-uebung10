package ueb10.formen;

public class Quader extends Volumen {
		public double a;
		public double b;
	public Quader(double a, double b, double h) {
		this.a=a;
		this.b=b;
		super.hoehe=h;
	}

	@Override
	public double grundflaeche() {
		return this.a*this.b;
	}
}
