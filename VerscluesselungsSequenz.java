public class VerscluesselungsSequenz {
    private int a;
    private int b;
    private int m;
    public VerscluesselungsSequenz(int a, int b, int m){
        this.a = a;
        this.b = b;
        this.m = m;
    }
    public int generiereNaechsteZufallszahl(int aktuelleZufallszahl){
        int naechsteZufallszahl = (a * aktuelleZufallszahl + b) % m;

        return naechsteZufallszahl;
    }
}

