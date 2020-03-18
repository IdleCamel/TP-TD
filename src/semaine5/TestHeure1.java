package semaine5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestHeure1
{
    HeureV3 dm; // début des cours le matin
    HeureV3 d1; // une seconde avant le début des cours le matin
    HeureV3 d7; // 7 h

    @BeforeEach
    public void setUp() throws Exception
    {
        d7 = new HeureV3(7);
        dm = new HeureV3(8, 30);
        d1 = new HeureV3(8, 29, 59);
    }

    @Test
    void testHeureIntIntInt()
    {
        assertEquals(8, d1.getHeures());
        assertEquals(29, d1.getMinutes());
        assertEquals(59, d1.getSecondes());
    }

    @Test
    void testHeureIntInt()
    {
        assertEquals(8, dm.getHeures());
        assertEquals(30, dm.getMinutes());
        assertEquals(0, dm.getSecondes());
    }

    @Test
    void testHeureInt()
    {
        assertEquals(7, d7.getHeures());
        assertEquals(0, d7.getMinutes());
        assertEquals(0, d7.getSecondes());
    }

    @Test
    void testGetHeures()
    {
        assertEquals(8, dm.getHeures());
        assertEquals(8, d1.getHeures());
        assertEquals(7, d7.getHeures());
    }

    @Test
    void testGetMinutes()
    {
        assertEquals(30, dm.getMinutes());
        assertEquals(29, d1.getMinutes());
        assertEquals(0, d7.getMinutes());
    }

    @Test
    void testGetSecondes()
    {
        assertEquals(0, dm.getSecondes());
        assertEquals(59, d1.getSecondes());
        assertEquals(0, d7.getSecondes());    }

    @Test
    void testEnSecondes()
    {
        assertEquals(8*3600 + 30*60, dm.enSecondes());
        assertEquals(8*3600 + 29*60 + 59, d1.enSecondes());
        assertEquals(7*3600, d7.enSecondes());
    }

    @Test
    void testCompareTo()
    {
        assertEquals(0, dm.compareTo(dm));
        assertEquals(0, dm.compareTo(new HeureV3(8, 30, 0)));

        assertTrue(dm.compareTo(d1) > 0);
        assertTrue(d1.compareTo(dm) < 0);

        assertTrue(dm.compareTo(d7) > 0);
        assertTrue(d7.compareTo(dm) < 0);        }

    @Test
    void testAjouter()
    {
        HeureV3 h = d1.ajouter(1);
        assertEquals(0, h.compareTo(dm));
        h = h.ajouter(-1);
        assertEquals(0, h.compareTo(d1));

        h = d7.ajouter(3600 + 29*60 + 59);
        assertEquals(0, h.compareTo(d1));
        h = h.ajouter(-3600 - 29*60 - 59);
        assertEquals(0, h.compareTo(d7));

        h = dm.ajouter(22*3600 + 30*60);
        assertEquals(0, h.compareTo(d7));
        h = h.ajouter(-22*3600 - 30*60 -1);
        assertEquals(0, h.compareTo(d1));
    }

    @Test
    void testToString()
    {
        assertEquals("08:30:00", dm.toString());
        assertEquals("08:29:59", d1.toString());
        assertEquals("07:00:00", d7.toString());
    }

    @Test
    void testEnHeure()
    {
        HeureV3 h = HeureV3.enHeure(8*3600 + 30*60);
        assertEquals(0, h.compareTo(dm));

        h = HeureV3.enHeure(8*3600 + 30*60 -1);
        assertEquals(0, h.compareTo(d1));

        h = HeureV3.enHeure(7*3600);
        assertEquals(0, h.compareTo(d7));

        h = HeureV3.enHeure(0);
        assertEquals(0, h.compareTo(HeureV3.MINUIT));

        h = HeureV3.enHeure(12*3600);
        assertEquals(0, h.compareTo(HeureV3.MIDI));

        h = HeureV3.enHeure(-1);
        assertEquals(0, h.compareTo(new HeureV3(23, 59, 59)));

        h = HeureV3.enHeure(365*24*3600 + 8*3600 + 30*60 - 1);
        assertEquals(0, h.compareTo(d1));
    }
}
