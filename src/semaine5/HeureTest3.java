package semaine5;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;

class HeureTest3
{
    @Test
    void testHeureIntIntInt1()
    {
        try
        {
            new HeureV3(24, 9, 0);
            fail("Ne lance pas IllegalArgumentException");
        }
        catch (IllegalArgumentException e)
        {
            // OK
        }
        catch (Exception e)
        {
            fail("Ne lance pas IllegalArgumentException");
        }
    }
    
    @Test
    void testHeureIntIntInt2()
    {
        try
        {
            new HeureV3(14, 60, 0);
            fail("Ne lance pas IllegalArgumentException");
        }
        catch (IllegalArgumentException e)
        {
            // OK
        }
        catch (Exception e)
        {
            fail("Ne lance pas IllegalArgumentException");
        }
    }
    
    @Test
    void testHeureIntIntInt3()
    {
        try
        {
            new HeureV3(14, 9, 60);
            fail("Ne lance pas IllegalArgumentException");
        }
        catch (IllegalArgumentException e)
        {
            // OK
        }
        catch (Exception e)
        {
            fail("Ne lance pas IllegalArgumentException");
        }
    }
    
    @Test
    void testHeureIntIntInt4()
    {
        try
        {
            new HeureV3(0, 0, -1);
            fail("Ne lance pas IllegalArgumentException");
        }
        catch (IllegalArgumentException e)
        {
            // OK
        }
        catch (Exception e)
        {
            fail("Ne lance pas IllegalArgumentException");
        }
    } 
    
    @Test
    void testHeureIntIntInt5()
    {
        try
        {
            new HeureV3(-1, -1, -1);
            fail("Ne lance pas IllegalArgumentException");
        }
        catch (IllegalArgumentException e)
        {
            // OK
        }
        catch (Exception e)
        {
            fail("Ne lance pas IllegalArgumentException");
        }
    }   
    
    @Test
    void testHeureIntIntInt6()
    {
        try
        {
            new HeureV3(49, -70, -122);
            fail("Ne lance pas IllegalArgumentException");
        }
        catch (IllegalArgumentException e)
        {
            // OK
        }
        catch (Exception e)
        {
            fail("Ne lance pas IllegalArgumentException");
        }
    }    

    @Test
    void testHeureIntInt1()
    {
        try
        {
            new HeureV3(12, -15);
            fail("Ne lance pas IllegalArgumentException");
        }
        catch (IllegalArgumentException e)
        {
            // OK
        }
        catch (Exception e)
        {
            fail("Ne lance pas IllegalArgumentException");
        }
    }

    @Test
    void testHeureInt1()
    {
        try
        {
            new HeureV3(-1);
            fail("Ne lance pas IllegalArgumentException");
        }
        catch (IllegalArgumentException e)
        {
            // OK
        }
        catch (Exception e)
        {
            fail("Ne lance pas IllegalArgumentException");
        }
    }

    @Test
    void testEnSecondes()
    {
        assertEquals(23*3600 + 59*60 + 59, HeureV3.MINUIT.ajouter(-1).enSecondes());
    }

    @Test
    void testAjouter()
    {
        assertEquals(0, HeureV3.MINUIT.ajouter(-1).ajouter(Integer.MAX_VALUE).compareTo(
                HeureV3.enHeure(Integer.MAX_VALUE-1)));
        assertEquals(0, HeureV3.MINUIT.ajouter(Integer.MIN_VALUE).compareTo(
                HeureV3.enHeure(Integer.MIN_VALUE)));
    }

    @Test
    void testToString()
    {
        assertEquals("23:59:59", HeureV3.MINUIT.ajouter(-1).toString());
    }

    @Test
    void testEnHeureV3()
    {
        int max = Integer.MAX_VALUE % (24* 3600);
        assertEquals(0, HeureV3.enHeure(Integer.MAX_VALUE).compareTo(
                new HeureV3( max/3600, (max%3600) / 60 , max%60)));

        int min = Integer.MIN_VALUE % (24* 3600) + (24*3600);
        assertEquals(0, HeureV3.enHeure(Integer.MIN_VALUE).compareTo(
                new HeureV3( min/3600, (min%3600) / 60 , min%60)));

    }

    @Test
    void testMaintenant()
    {
        LocalTime avant = LocalTime.now();
        HeureV3 hAvant = HeureV3.enHeure(avant.toSecondOfDay());
        HeureV3 maintenant = HeureV3.maintenant();
        LocalTime apres = LocalTime.now();
        HeureV3 hApres = HeureV3.enHeure(apres.toSecondOfDay());
        assertTrue(hAvant.compareTo(maintenant) <= 0 && maintenant.compareTo(hApres) <= 0);
    }

}
