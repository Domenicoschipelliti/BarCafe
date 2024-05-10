package Domenico.BarCafe;

import Domenico.BarCafe.CsvConf.RunnerCsv;
import Domenico.BarCafe.Enteties.Cibo;
import Domenico.BarCafe.Enteties.Utente;
import Domenico.BarCafe.Exceptions.Handler;
import Domenico.BarCafe.Service.CiboService;
import Domenico.BarCafe.Service.UtenteService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CiboTest {

    static RunnerCsv runnerCsv;
    Handler handler;





    @AfterAll
    public static void setRunnerCsv(){
        assertNull(runnerCsv);
    }


    @Test
    public void verificationPhrase(){
        String message=handler.accessDenied().message();
        assertNotEquals("non puoi usare questa cosa per via del tuo ruolo",message);
    }


    @Test
    public void ciboTest(){

        String email="ciao@gmail.com";
        assertEquals("ciao@gmail.com",email);

    }
}
