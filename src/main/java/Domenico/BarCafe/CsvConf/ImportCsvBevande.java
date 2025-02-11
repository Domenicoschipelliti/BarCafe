package Domenico.BarCafe.CsvConf;

import Domenico.BarCafe.Enteties.Bevande;
import Domenico.BarCafe.Service.BevandeService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

@Component
public class ImportCsvBevande {
    private final BevandeService bevandeService;

    @Autowired
    public ImportCsvBevande(BevandeService bevandeService) {
        this.bevandeService = bevandeService;
    }

    public void importCsvFromBevande(String file){
        try(FileReader reader=new FileReader(file); CSVParser csvParser= CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader().parse(reader)){
            for (CSVRecord csvRecord:csvParser){
                String nomeProdotto=csvRecord.get("nomeProdotto");
                String descrizione=csvRecord.get("descrizione");
                String immagine=csvRecord.get("immagine");
                double costo=Double.parseDouble(csvRecord.get("costo"));


                Bevande bevande=new Bevande();

                bevande.setNomeProdotto(nomeProdotto);
                bevande.setDescrizione(descrizione);
                bevande.setImmagine(immagine);
                bevande.setCosto(costo);


                System.out.println(bevande);
                bevandeService.bevandeSave(bevande);

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
