public class Kodierung{
  private int aktuelleZufallszahl;
  private VerscluesselungsSequenz verschluesselungssequenz;
  public Kodierung(int a, int b, int m, int schluessel){
   verschluesselungssequenz = new VerscluesselungsSequenz(a, b, m);
   aktuelleZufallszahl = verschluesselungssequenz.generiereNaechsteZufallszahl(schluessel);

  }
  public byte kodiere(byte eingabe){
    byte schluesselByte = (byte)verschluesselungssequenz.generiereNaechsteZufallszahl(aktuelleZufallszahl);
    byte kodiertesByte = (byte)(eingabe ^ schluesselByte);

   return kodiertesByte;
  }

}
