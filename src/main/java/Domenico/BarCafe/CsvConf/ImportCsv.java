package Domenico.BarCafe.CsvConf;

import Domenico.BarCafe.Enteties.Cibo;
import Domenico.BarCafe.Service.CiboService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
public class ImportCsv {
    private final CiboService ciboService;

    @Autowired
    public ImportCsv(CiboService ciboService) {
        this.ciboService = ciboService;
    }

    public void imporFromtCsv(String file){

        try(FileReader reader=new FileReader(file);CSVParser csvParser= CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader().parse(reader)) {
            for (CSVRecord csvRecord: csvParser){
               String nomeProdotto=csvRecord.get("nomeProdotto");
               String descrizione=csvRecord.get("descrizione");
               String immagine=csvRecord.get("immagine");
               double costo=Double.parseDouble(csvRecord.get("costo"));

                Cibo cibo=new Cibo();

                cibo.setNomeProdotto(nomeProdotto);
                cibo.setCosto(costo);
                cibo.setDescrizione(descrizione);
                cibo.setImmagine(immagine);

                System.out.println(cibo);
                ciboService.ciboSave(cibo);




            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
