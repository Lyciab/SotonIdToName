import java.io.BufferedReader;
import java.net.*;
import java.io.*;

public class SotonIdToName{
    public static void main(String[] args) throws Exception{

        
        System.out.print("Enter email id: "); //INPUT - user id
        BufferedReader idReader = new BufferedReader(new InputStreamReader(System.in)); //Create BufferedReader for user input
        String idInput = idReader.readLine(); //Read user id input;
        
        URL people = new URL("https://www.ecs.soton.ac.uk/people/" + idInput); //Asign URL to read from + compile with inputted id
        BufferedReader reader = new BufferedReader(new InputStreamReader(people.openStream())); //Create BufferedReader for URL

        String inputLine; //what reader reads
        String idToName = null; //name to be asigned

        while ((inputLine = reader.readLine()) != null) //Loop to read page line by line
            if (inputLine.contains("\"name\"")){ //Detect part of webpage that contains the name
                idToName = inputLine.substring(inputLine.indexOf("\"name\"") +7, inputLine.indexOf("<em property")); //Get the name from the webpage
                break;
            }
        reader.close(); //end reader

        if(idToName == null)
            System.out.println("Invalid id"); //error message
        else
            System.out.println("Name: " + idToName); //OUTPUT - name
        
    }
}