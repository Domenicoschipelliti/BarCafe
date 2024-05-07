package Domenico.BarCafe.CsvConf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerCsv implements CommandLineRunner {

    private final ImportCsv importCsv;
    private final ImportCsvBevande importCsvBevande;
    @Autowired
    public RunnerCsv(ImportCsv importCsv, ImportCsvBevande importCsvBevande) {
        this.importCsv = importCsv;
        this.importCsvBevande = importCsvBevande;
    }

    @Override
    public void run(String... args) throws Exception {
        String ciboFile="./CSV/Cibo.csv";
        String bevandeFile="./CSV/Bevande.csv";

         importCsv.imporFromtCsv(ciboFile);
         importCsvBevande.importCsvFromBevande(bevandeFile);


    }
}
