package Domenico.BarCafe;

import Domenico.BarCafe.CsvConf.RunnerCsv;
import Domenico.BarCafe.Service.CiboService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TestFunction {

    static RunnerCsv runnerCsv;
    static CiboService ciboService;








    @AfterAll
    public static void setRunnerCsv(){
        assertNull(runnerCsv);
    }

    @BeforeAll
    public static  void allFoods(){
        assertNull(ciboService);
    }





    @Test
    public void test(){

    }












   
}
