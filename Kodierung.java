/**
 * Die Klasse Kodierung stellt einen Mechanismus zur Verschlüsselung 
 * von Bytes mithilfe einer VerschluesselungsSequenz dar.
 * Sie verwendet einen linearen Kongruenzgenerator, 
 * um eine Sequenz von Zufallszahlen zu generieren und die Eingabebytes zu kodieren.
 */
public class Kodierung{

	private int aktuelleZufallszahl;
	private VerscluesselungsSequenz verschluesselungssequenz;
	/**
	 * Konstruktor für die Kodierung-Klasse.
	 * Erzeugt eine Instanz der VerschluesselungsSequenz-Klasse
	 * und initialisiert die aktuelle Zufallszahl.
	 * @param a Die Multiplikationskonstante für den linearen Kongruenzgenerator.
	 * @param b Die Additionskonstante für den linearen Kongruenzgenerator.
	 * @param m Das Modul für den linearen Kongruenzgenerator.
	 * @param schluessel Der Ausgangsschlüssel für die Initialisierung der VerschluesselungsSequenz.
	 */
	public Kodierung(int a, int b, int m, int schluessel){
	
		verschluesselungssequenz = new VerscluesselungsSequenz(a, b, m);
		aktuelleZufallszahl = verschluesselungssequenz.generiereNaechsteZufallszahl(schluessel);

	}
	/**
	 * Kodiert ein Eingabebyte unter Verwendung der aktuellen Zufallszahl aus der Sequenz.
	 * @param eingabe Das zu kodierende Byte.
	 * @return Das kodierte Byte.
	 */
	public byte kodiere(byte eingabe){
		
		byte schluesselByte = (byte)verschluesselungssequenz.generiereNaechsteZufallszahl(aktuelleZufallszahl);
		byte kodiertesByte = (byte)(eingabe ^ schluesselByte);

		return kodiertesByte;
	}
}
