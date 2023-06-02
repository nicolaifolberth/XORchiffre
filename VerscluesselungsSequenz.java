/**
 * Die Klasse VerscluesselungsSequenz stellt einen Sequenzgenerator 
 * zur Verschlüsselung und Entschlüsselung 
 * von Zahlen mithilfe eines linearen Kongruenzgenerators dar.
 * Sie generiert eine Sequenz von Zufallszahlen basierend auf 
 * der Formel: (a * vorherigeZahl + b) % m.
 */
public class VerscluesselungsSequenz {
    private int a;
    private int b;
    private int m;
    /**
     * Konstruktor für die VerscluesselungsSequenz-Klasse.
     * @param a Die Multiplikationskonstante.
     * @param b Die Additionskonstante.
     * @param m Das Modul.
     */
    public VerscluesselungsSequenz(int a, int b, int m){
        this.a = a;
        this.b = b;
        this.m = m;
    }
    /**
     * Generiert die nächste Zufallszahl in der Sequenz
     * basierend auf der gegebenen aktuellen Zufallszahl.
     * @param aktuelleZufallszahl Die aktuelle Zufallszahl.
     * @return Die nächste Zufallszahl in der Sequenz.
     */
    public int generiereNaechsteZufallszahl(int aktuelleZufallszahl){
        int naechsteZufallszahl = (a * aktuelleZufallszahl + b) % m;

        return naechsteZufallszahl;
    }
}
