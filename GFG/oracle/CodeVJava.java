//https://ide.geeksforgeeks.org/aw68KG
import java.io.*;
import java.util.*;
public class CodeVJava {

	public static char[][] grid;
	public static String word; 
    public static String input;

	public static String fileName;
	static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    public static void searchGrid(char[][] grid, String word) {

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == word.charAt(0)) {
                    for (int dir = 0; dir < 8; dir++) {
                        if (searchGridUtil(grid, word, 1, dir, i, j, i, j)) break;
                    }
                }
            }
        }
    }


    public static boolean searchGridUtil(char[][] grid, String word, int pos, int dir, int i, int j, int iPos, int jPos) {
        if (pos == word.length()) {
            //System.out.printf("pattern found at %d, %d\n", iPos, jPos);
            write_output(input, iPos,jPos);
            write_output_out(iPos,jPos);
            return true;
        }
        int m = grid.length, n = grid[0].length;
        int x, y;
        if (dir == 0) {
            x = i - 1;
            y = j - 1;
        } else if (dir == 1) {
            x = i - 1;
            y = j;
        } else if (dir == 2) {
            x = i - 1;
            y = j + 1;
        } else if (dir == 3) {
            x = i;
            y = j + 1;
        } else if (dir == 4) {
            x = i + 1;
            y = j + 1;
        } else if (dir == 5) {
            x = i + 1;
            y = j;
        } else if (dir == 6) {
            x = i + 1;
            y = j - 1;
        } else {
            x = i;
            y = j - 1;
        }

        if (x < 0 || x == m || y < 0 || y == n || grid[x][y] != word.charAt(pos)) return false;
        return searchGridUtil(grid, word, pos + 1, dir, x, y, iPos, jPos);
    }
    public static void readInputs(String fileName) throws IOException{
        // The name of the file to open.
        //char[][] grid;
        //String fileName = "input.txt";
        FileInputStream input = new FileInputStream(fileName);
        Scanner scanner = new Scanner(input);
        while(scanner.hasNextLine()) {
            //String name = scanner.next();
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            grid = new char [row][col];
            for(int i=0;i < row ;i++){
                scanner.nextLine(); // clears newlines from the buffer
                String name = scanner.next();
                for(int j=0;j < name.length(); j++){
                    grid[i][j] = name.charAt(j);
                }
            }
            scanner.nextLine(); // clears newlines from the buffer
            word = scanner.next();
            /* //PRINTS TO CONFIRM THE GOOD READING
            System.out.println("n_rows:"+row+"\nn_col:"+col+"\n"+word);
            System.out.println("\nGrid:");
            for(int k=0; k < 3;k++){
                for (int l=0;l<14;l++){
                    System.out.print(grid[k][l]);
                }
                System.out.println();
            }
            */ //END OF PRINTS
        }

    }

    public static void write_header_output(){
      sb.append ("input,");
      sb.append("posX,");
      sb.append("posY");
      sb.append('\n');
  }
  public static void write_output(String id, int posX, int posY){
    sb.append(id);
      sb.append(',');
      sb.append(Integer.toString(posX));
      sb.append(',');
      sb.append(Integer.toString(posY));
      sb.append('\n');
  }
  public static void write_to_file(){
  	try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {
      writer.write(sb.toString());

      System.out.println("done!");

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void write_to_file_out(String outName){
    try (PrintWriter writer2 = new PrintWriter(new File(outName+".out"))) {
      writer2.write(sb2.toString());

      System.out.println("done2!");

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void write_output_out(int posX, int posY){
      sb2.append(Integer.toString(posX));
      sb2.append(' ');
      sb2.append(Integer.toString(posY));
      sb2.append('\n');
  }

    public static void main(String[] args) {
    
        write_header_output();
        //for(int i=10; i<=40;i++){ // cycle to boundary inputs
        for(int i=1;i<10;i++){ // cycle to partitioning inputs
            input = ""+i+".txt";
            //fileName = "/home/ruigustavo/Desktop/Project2-QCS/PythonVersion/my-project-env/oracle/inputs_boundary/i"+input; //boundary
            fileName = "/home/ruigustavo/Desktop/Project2-QCS/PythonVersion/my-project-env/oracle/inputs_partitioning/i"+input; // partitioning
        try {
            readInputs(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        searchGrid(grid, word);
        write_to_file_out(""+i);
        sb2 = new StringBuilder();
        
        }
        write_to_file();
        

        System.out.println();
        //searchGrid(grid, "EEE");
        //System.out.println("letra:"+grid[0][0]);
        
    }
}    
    
