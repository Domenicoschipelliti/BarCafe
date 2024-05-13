package Domenico.BarCafe;

import Domenico.BarCafe.CsvConf.RunnerCsv;
import Domenico.BarCafe.Enteties.Cibo;
import Domenico.BarCafe.Enteties.Utente;
import Domenico.BarCafe.Exceptions.BadRequest;
import Domenico.BarCafe.Exceptions.Handler;
import Domenico.BarCafe.Exceptions.Unauthorized;
import Domenico.BarCafe.Service.CiboService;
import Domenico.BarCafe.Service.SecurityService;
import Domenico.BarCafe.Service.UtenteService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CiboTest {

    static RunnerCsv runnerCsv;
    SecurityService securityService;





    @AfterAll
    public static void setRunnerCsv(){
        assertNull(runnerCsv);
    }








   
}
