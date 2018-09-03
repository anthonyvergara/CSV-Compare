import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {
    public static void main(String args[]) throws IOException, ParseException {

        Scanner in = new Scanner(System.in);

//        ./resources/documento/demaisProdutos2.dsv
//                ./resources/documento/export3.csv

        LerCSV leitor = new LerCSV();

        while (in.hasNextLine()) {
            CSVParser p = CSVParser.parse(in.nextLine(), CSVFormat.DEFAULT);
            CSVRecord dados = p.getRecords().get(0);

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            Pessoa pessoa;
            try {
                pessoa = new Pessoa(dados.get(0), dados.get(2), dados.get(1), formato.parse(dados.get(3)));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                continue;
            }

            if(leitor.lista.get(pessoa.hashCode())!= null) {
                System.out.println(pessoa.nome +";"+ pessoa.cpf + ";" + pessoa.nome_mae + ";" + pessoa.data_nascimento);
            }
        }

    }
}
