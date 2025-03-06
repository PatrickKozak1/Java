package Test2;

class Person2 {
    private static int idCounter = 0;
    private String vorname;
    private String nachname;
    private String adresse;
    private int id;
    private String typ;

    public Person2(String vorname, String nachname, String adresse, String typ) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.id = ++idCounter;
        this.typ = typ;
    }

    public String getVorname() { return vorname; }
    public String getNachname() { return nachname; }
    public String getAdresse() { return adresse; }
    public int getId() { return id; }
    public String getTyp() { return typ; }
}


// Erstelle mir eine GUI wo man 2 Sudokufelder hat eines wo man die Zahlen eingeben kann und eines wo es einen die lösung hinschreibt und das sol MVC Pattern gemacht werden


