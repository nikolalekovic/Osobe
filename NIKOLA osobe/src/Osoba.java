public class Osoba {
String ime;
public String getIme() {
	return ime;
}

public void setIme(String ime) {
	this.ime = ime;
}

public String getPrezime() {
	return prezime;
}

public void setPrezime(String prezime) {
	this.prezime = prezime;
}

public int getGodiste() {
	return godiste;
}

public void setGodiste(int godiste) {
	this.godiste = godiste;
}

String prezime;
int godiste;
Osoba()
{}
Osoba(String ime, int godiste)
{
	
	this.ime=ime.substring(0,ime.lastIndexOf(" "));
	this.prezime=ime.substring(ime.lastIndexOf(" ")+1);
	this.godiste=godiste;
}
}
