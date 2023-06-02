/**
 * Die Klasse Main stellt den Einstiegspunkt des Programms dar.
 * Sie enthält die main-Methode, in der die Programmausführung startet.
 */
public class Main{
  /**
   * Die main-Methode, in der die Verarbeitung von Dateien mit verschiedenen Parametern getestet wird.
   */
  public static void main(String[] args){
	
	DateiManager testManager = new DateiManager();
	// Testen der Verarbeitung mit verschiedenen Parametern
	testManager.verarbeiteDatei( "Chiffrierung", 3, 421, 54773, 259200, "Gedicht.txt","chiffriertesGedicht.txt");
	testManager.verarbeiteDatei( "Dechiffrierung", 3, 421, 54773, 259200, "dechiffriertesGedicht.txt","chiffriertesGedicht.txt");
	testManager.verarbeiteDatei( "Chiffrierung", 3, 38777, 29573, 139968, "Gedicht.txt","chiffriertesGedichtParameterZwei.txt");
	testManager.verarbeiteDatei( "Dechiffrierung", 3, 38777, 29573, 139968, "dechiffriertesGedichtParameterZwei.txt","chiffriertesGedichtParameterZwei.txt");
  }

}
