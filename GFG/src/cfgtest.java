import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class cfgtest {
	public static String word; 
	public static char[][] grid;
	public static String fileName;
	public static String file;
	public static String input;
	public static StringBuilder sb = new StringBuilder();
	
	@Test
	public void test() {
		
		for(int i=10; i<=40;i++){
            input = ""+i+".txt";
            fileName = "C:/Users/rgven/workspace/GFG/src/boundary/i"+input;
            file = "C:/Users/rgven/workspace/GFG/src/outputs/"+i+".out";
        try {
            readInputs(fileName);
            readOutputs(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		GFG.patternSearch(grid, word);
		assertEquals(outContent.toString(),sb.toString());
        
        
        }
		assertEquals(true,true);
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
