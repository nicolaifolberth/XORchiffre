import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Die Klasse DateiManager verwaltet die Verarbeitung von Dateien
 * basierend auf dem gewählten Modus (Chiffrierung oder Dechiffrierung).
 * Sie liest eine Eingabedatei, wendet die Kodierung auf die Bytes an
 * und schreibt das Ergebnis in eine Ausgabedatei.
 */
public class DateiManager{
    /**
	 * Verarbeitet eine Datei basierend auf dem angegebenen Modus,
	 * Schlüssel und den Parametern für die VerschluesselungsSequenz.
	 * @param art Der Modus der Verarbeitung (Chiffrierung oder Dechiffrierung).
	 * @param schluessel Der Schlüssel für die Initialisierung der VerschluesselungsSequenz.
	 * @param a Die Multiplikationskonstante für den linearen Kongruenzgenerator.
	 * @param b Die Additionskonstante für den linearen Kongruenzgenerator.
	 * @param m Das Modul für den linearen Kongruenzgenerator.
	 * @param klartext Der Pfad zur Eingabedatei im Chiffrierungsmodus.
	 * @param geheimtext Der Pfad zur Eingabedatei im Dechiffrierungsmodus.
	 */
	public void verarbeiteDatei(String art, int schluessel, int a, int b, int m, String klartext, String geheimtext){
		try {
		  FileInputStream input = new FileInputStream(bestimmeInputDatei(art, klartext, geheimtext));
		  FileOutputStream output = new FileOutputStream(bestimmeOutputDatei(art, klartext, geheimtext));
		  Kodierung kodierung = new Kodierung(a, b, m, schluessel);
		  int byteValue;
		  
		  while ((byteValue = input.read()) != -1){
		    
		    byte kodiertesByte = kodierung.kodiere((byte) byteValue);
		    output.write(kodiertesByte);
		  
		  }

		  input.close();
		  output.close();

		  System.out.println("Die Datei wurde erfolgreich verarbeitet.");
		} catch (IOException e) {
		  System.out.println("Fehler beim Verarbeiten der Datei: " + e.getMessage());
		}
	}
	/**
   	 * Bestimmt den Dateinamen der Eingabedatei basierend auf dem Modus und den angegebenen Dateipfaden.
   	 * @param art Der Modus der Verarbeitung (Chiffrierung oder Dechiffrierung).
   	 * @param klartext Der Pfad zur Eingabedatei im Chiffrierungsmodus.
   	 * @param geheimtext Der Pfad zur Eingabedatei im Dechiffrierungsmodus.
   	 * @return Der Dateiname der Eingabedatei.
   	 */
 	private String bestimmeInputDatei(String art, String klartext, String geheimtext){
    
		String inputDatei;
		
		if (art.equals("Chiffrierung")){
		  inputDatei = klartext;
		}
		else if(art.equals("Dechiffrierung")){
		  inputDatei = geheimtext;
		}
		else{
		  throw new IllegalArgumentException("Nur {Chiffrierung/Dechiffrierung} möglich.");
		}
		
		return inputDatei;
    
	}
	/**
	 * Bestimmt den Dateinamen der Ausgabedatei basierend auf dem Modus und den angegebenen Dateipfaden.
	 * @param art Der Modus der Verarbeitung (Chiffrierung oder Dechiffrierung).
	 * @param klartext Der Pfad zur Eingabedatei im Chiffrierungsmodus.
	 * @param geheimtext Der Pfad zur Eingabedatei im Dechiffrierungsmodus.
	 * @return Der Dateiname der Ausgabedatei.
	 */
	private String bestimmeOutputDatei(String art, String klartext, String geheimtext){
	    String outputDatei;
	    if(art.equals("Chiffrierung")){
	      outputDatei = geheimtext;
	    }
	    else if(art.equals("Dechiffrierung")){
	      outputDatei = klartext;
	    }
	    else{
	      throw new IllegalArgumentException("Nur {Chiffrierung/Dechiffrierung} möglich.");
	    }
	    return outputDatei;

	}
}
