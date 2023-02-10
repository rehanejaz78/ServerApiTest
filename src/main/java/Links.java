import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Links {


    public ArrayList<String> AddUrls() throws IOException, CsvValidationException {


        CSVReader reader = new CSVReader(new FileReader("Csv data/urls.csv"));
        //reading data of the csv file

        StringBuffer buffer = new StringBuffer();
        String  links[];
        ArrayList<String> mylist =  new ArrayList<String>();

       while ((links= reader.readNext()) !=null )
        {
            for (int i = 0; i < links.length; i++) {
                mylist.add(links[i]);
            }

        }

        return mylist;

    }


}
