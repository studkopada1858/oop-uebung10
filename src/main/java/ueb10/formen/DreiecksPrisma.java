package ueb10.formen;

public class DreiecksPrisma extends Volumen{
	double a;
	double b;
	double c;

	@Override
	public double grundflaeche() {
		double s=(a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}

	public DreiecksPrisma(double a, double b, double c, double h) {
	this.a=a;
	this.b=b;
	this.c=c;
	super.hoehe=h;
	}
}
