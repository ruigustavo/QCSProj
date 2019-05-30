import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

//import org.junit.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PartitioningTest {

	public static String word; 
	public static char[][] grid;
	public static String fileName;
	public static String file;
	public static String input;
	public static StringBuilder sb = new StringBuilder();
	
	@Test(dataProvider = "provideFilenames")
	public void test(String fileName) {
		//diretoria dos inputs para boundary inputs
		String dirIn = "C:/Users/rgven/workspace/GFG/src/partitioning/";
		//diretoria dos outputs do oracle
        String dirOut = "C:/Users/rgven/workspace/GFG/src/outputs/";
		try {
			//Leitura do ficheiro de input
            readInputs(dirIn+"i"+fileName+".txt");
          //Leitura do ficheiro de output
            readOutputs(dirOut+""+fileName+".out");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		GFG.patternSearch(grid, word);
		assertEquals(outContent.toString(), sb.toString());
		
		//fail("Not yet implemented");
	}
	
	@DataProvider(name = "provideFilenames")
    public String[] provideData() {
        return new String[] { 
            "1", "1", "2","3", "4", "5", "6", "7","8","9"
        };
    }
	
	public static void readInputs(String fileName) throws IOException{
        FileInputStream input = new FileInputStream(fileName);
        Scanner scanner = new Scanner(input);
        while(scanner.hasNextLine()) {
            //String name = scanner.next();
            GFG.R = scanner.nextInt();
            GFG.C = scanner.nextInt();
            grid = new char [GFG.R][GFG.C];
            for(int i=0;i < GFG.R ;i++){
                scanner.nextLine(); // clears newlines from the buffer
                String name = scanner.next();
                for(int j=0;j < name.length(); j++){
                    grid[i][j] = name.charAt(j);
                }
            }
            scanner.nextLine(); // clears newlines from the buffer
            word = scanner.next();
        }

    }
	
	public static void readOutputs(String file) throws IOException{
		 FileInputStream input = new FileInputStream(file);
		 sb = new StringBuilder();
	        Scanner scanner = new Scanner(input);
	        while(scanner.hasNextLine()) {
	            //String name = scanner.next();
	            int posX = scanner.nextInt();
	            int posY= scanner.nextInt();
	            scanner.nextLine();
	            sb.append(posX+ " " + posY);
	        }
	 }

}
