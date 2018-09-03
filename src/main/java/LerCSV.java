import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LerCSV {

    public Map<Integer, Pessoa> lista;

    public LerCSV() throws IOException, ParseException {

        Scanner in = new Scanner(new FileReader("export.csv"));

        lista = new HashMap<>();

        while (in.hasNextLine()) {

            CSVParser p = CSVParser.parse(in.nextLine(), CSVFormat.DEFAULT);
            CSVRecord dados = p.getRecords().get(0);

            SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");


            try {
                Pessoa pessoa = new Pessoa(dados.get(0), dados.get(1), dados.get(2), formato.parse(dados.get(3)));
                lista.put(pessoa.hashCode(), pessoa);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                continue;
            }

        }

    }
}
