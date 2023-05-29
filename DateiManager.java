import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DateiManager{

  public void verarbeiteDatei(String art, int schluessel, int a, int b, int m, String klartext, String geheimtext){


    try {
      FileInputStream input = new FileInputStream(bestimmeInputDatei(art, klartext, geheimtext));

      FileOutputStream output = new FileOutputStream(bestimmeOutputDatei(art, klartext, geheimtext));

       Kodierung kodierung = new Kodierung(a, b, m, schluessel);

      int byteValue;
      while ((byteValue = input.read()) != -1) {
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

  private String bestimmeInputDatei(String art, String klartext, String geheimtext){
    String inputDatei;
    if (art.equals("Chiffrierung")){
      inputDatei = klartext;

    }else if(art.equals("Dechiffrierung")){
      inputDatei = geheimtext;
    }else{
      throw new IllegalArgumentException("Nur {Chiffrierung/Dechiffrierung} möglich.");
    }
    return inputDatei;

  }
  private String bestimmeOutputDatei(String art, String klartext, String geheimtext){
    String outputDatei;
    if (art.equals("Chiffrierung")){
      outputDatei = geheimtext;

    }else if(art.equals("Dechiffrierung")){
      outputDatei = klartext;
    }else{
      throw new IllegalArgumentException("Nur {Chiffrierung/Dechiffrierung} möglich.");
    }
    return outputDatei;
  }
}
