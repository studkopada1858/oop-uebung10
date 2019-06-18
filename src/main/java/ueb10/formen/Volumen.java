package ueb10.formen;

public abstract class Volumen {

    public double hoehe;
    public double volumen(){
        return grundflaeche()*hoehe;
    }
    public abstract double grundflaeche();

}
