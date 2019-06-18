package ueb10.formen;

import java.util.Map;

public class Zylinder extends Volumen {
	double r;


	@Override
	public double grundflaeche() {
		return Math.PI*r*r;
	}

	public Zylinder(double r, double b) {
	this.r=r;
	super.hoehe=b;
	}
}
