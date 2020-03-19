package Semaine6;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonneTest {

    ArrayList<String> list = new ArrayList<>();
    Personne p1;
    Personne p2;

    @BeforeEach
    public void setUp() throws Exception
    {
        list.add("Valentin");
        list.add("Cedric");

        p1 = new Personne("BLOCH", "Valentin", LocalDate.of(2000,10,10));
        p2 = new Personne("COUCOU", list, LocalDate.of(2000,10,10));
    }

    @Test
    void getNom() {
        assertEquals("BLOCH", p1.getNom());
        assertEquals("COUCOU", p2.getNom());
    }

    @Test
    void getPrenom() {
        assertEquals("Valentin", p1.getPrenom());
    }

    @Test
    void getPrenoms() {
        assertEquals("Valentin", p1.getPrenom(0)); // NON CONFORME A LA SPECIFICATION DE LA CLASSE PERSONNE
        assertEquals("Cedric", p2.getPrenom(1)); // NON CONFORME A LA SPECIFICATION DE LA CLASSE PERSONNE
    }

    @Test
    void getNbPrenoms() {
        assertEquals(1, p1.getNbPrenoms());
        assertEquals(2, p2.getNbPrenoms());
    }

    @Test
    void testGetPrenoms() {
        assertEquals("Valentin ", p1.getPrenoms());
        assertEquals("Valentin Cedric ", p2.getPrenoms()); // CELA SENT LE TEST A POSTERIORI SINON, POURQUOI METTRE UN ESPACE EN FIN DE LIGNE ?
    }

    @Test
    void getListeDesPrenoms() {
        ArrayList exepted = new ArrayList(Arrays.asList("Valentin", "Cedric"));
        equals(exepted.equals(p2.getListeDesPrenoms())); // ??????????????????
    }

    @Test
    void getDateNaissance() {
        assertEquals(LocalDate.of(2000,10,10), p1.getDateNaissance(), " la date de naisance n'est pas corect");
    }

    @Test
    void getAge() {
        assertEquals(20, p1.getAge()); // DOIT ECHOUER CAR p1 A 19 ANS ...
    }

    @Test
    void testGetAge() {
        assertEquals(20, p1.getAge(LocalDate.now())); // MEME TEST QUE LE PRECEDENT
    }

    @Test
    void testToString() {
        assertEquals("BLOCH Valentin 2000-10-10", p1.toString()); // NON CONFORME A LA SPECIFICATION DE LA CLASSE PERSONNE
    }
        assertEquals("COUCOU Valentin Cedric 2000-10-10", p2.toString()); // NON CONFORME A LA SPECIFICATION DE LA CLASSE PERSONNE
    }
    }

}
