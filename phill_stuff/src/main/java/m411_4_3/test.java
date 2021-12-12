package m411_4_3;

public class test {
    class Note{
        private float note;
        private float gewichtungdezimal;
    }

    class Fach{
        private String fachname;
        private Note[] noten;
    }

    class Schneehoehen{
        private float hoehe;
    }

    class Skigebiete{
        private String name;
        private Schneehoehen schneehoehen;
    }

    class Alp{
        private String alpname;
        private Skigebiete skigebiete;
    }

    class Benutzer{
        private String Name;
        private String Passwort;
    }

    class System{
        private String name;
        private Benutzer[] benutzers;
    }

    class Schueler{
        private String name;
        private String vorname;
        private String email;
    }

    class Klasse{
        private String klassennamen;
        private Schueler[] schuelers;
    }

    class Stundenplan{
        private Fach fach;
        private String Stundenbezeichnung;
        private Klasse klasse;
    }
}
