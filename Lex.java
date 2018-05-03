// Faisal Shaikh
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class Lex
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0])); // First file reader to count lines
        int lines = 0;
        int i = 0;
        while (reader.readLine() != null)
        {
            lines++;
        }
        reader.close();

        String[] array = new String[lines];
        String hold = null;
        BufferedReader readIntoArray = new BufferedReader (new FileReader(args[0])); // Read into the array

        while((hold = readIntoArray.readLine()) != null)
        {
            array[i] = hold;
            i++;
        }
        readIntoArray.close();
        List list = new List();
        sort(array, list);
        list.moveFront();

        BufferedWriter writeToFile = new BufferedWriter( new FileWriter(args[1])); // Write into file
        while(list.index() != -1)
        {
            writeToFile.write(array[list.get()]);
            writeToFile.newLine();
            list.moveNext();
        }
        writeToFile.close();
    }

    //sort stores the sorted order of indexes from String[] array into List list
    public static void sort(String[] array, List list)
    {
        list.append(0); // Starting point to compare to before sorting
        for(int i = 1; i < array.length; i++)
        {
            list.moveFront();
            while(list.index() != -1)
            {
                if(array[list.get()].compareTo(array[i]) > 0)
                {
                    list.insertBefore(i);
                    break;
                }
                else
                {
                    list.moveNext();
                }
            }
            if(list.index() == -1)
            {
                list.append(i);
            }
        }
    }
}
