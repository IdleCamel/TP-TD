package semaine5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HeureTest2
{

    @Test
    void testGetHeures()
    {
        assertEquals(0, HeureV3.MINUIT.getHeures());
        assertEquals(12, HeureV3.MIDI.getHeures());
    }

    @Test
    void testGetMinutes()
    {
        assertEquals(0, HeureV3.MINUIT.getMinutes());
        assertEquals(0, HeureV3.MIDI.getMinutes());
    }

    @Test
    void testGetSecondes()
    {
        assertEquals(0, HeureV3.MINUIT.getSecondes());
        assertEquals(0, HeureV3.MIDI.getSecondes());
    }

    @Test
    void testEnSecondes()
    {
        assertEquals(0, HeureV3.MINUIT.enSecondes());
        assertEquals(12 * 3600, HeureV3.MIDI.enSecondes());
    }

    @Test
    void testCompareTo()
    {
        assertEquals(0, HeureV3.MINUIT.compareTo(HeureV3.MINUIT));
        assertEquals(0, HeureV3.MINUIT.compareTo(new HeureV3(0)));

        assertTrue(HeureV3.MINUIT.compareTo(HeureV3.MIDI) < 0);
        assertTrue(HeureV3.MIDI.compareTo(HeureV3.MINUIT) > 0);

    }

    @Test
    void testAjouter()
    {
        HeureV3 h = new HeureV3(23, 59, 59);
        assertEquals(0, h.compareTo(HeureV3.MINUIT.ajouter(-1)));
        assertEquals(0, h.ajouter(1).compareTo(HeureV3.MINUIT));
        assertEquals(0, HeureV3.MINUIT.ajouter(12*3600).compareTo(HeureV3.MIDI));
        assertEquals(0, HeureV3.MIDI.ajouter(12*3600).compareTo(HeureV3.MINUIT));
    }

    @Test
    void testToString()
    {
        assertEquals("00:00:00", HeureV3.MINUIT.toString());
        assertEquals("12:00:00", HeureV3.MIDI.toString());
    }


    @Test
    void testEnHeureV3()
    {
        HeureV3 h = HeureV3.enHeure(0);
        assertEquals(0, h.compareTo(HeureV3.MINUIT));

        h = HeureV3.enHeure(12 * 3600);
        assertEquals(0, h.compareTo(HeureV3.MIDI));
        
        h = HeureV3.enHeure(24 * 3600);
        assertEquals(0, h.compareTo(HeureV3.MINUIT));

        h = HeureV3.enHeure(36 * 3600);
        assertEquals(0, h.compareTo(HeureV3.MIDI));
        
        h = HeureV3.enHeure(-12 * 3600);
        assertEquals(0, h.compareTo(HeureV3.MIDI));

        h = HeureV3.enHeure(-24 * 3600);
        assertEquals(0, h.compareTo(HeureV3.MINUIT));

        h = HeureV3.enHeure(-36 * 3600);
        assertEquals(0, h.compareTo(HeureV3.MIDI));    
    }

}

