import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CFlowTest {
	@Before
	public void setUp() throws Exception {
		System.out.println("Execução de novo teste");
	} 

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void ShouldThrowOutOfBoundsExceptionBecauseOfRow() {
		final int GRID_ROWS = 1;
		final int GRID_COLS = 1;
		char [][] grid = {{'O'}};
		SearchWord.R = GRID_ROWS;
		SearchWord.C = GRID_COLS;
		SearchWord.search2D(grid, GRID_ROWS + 1, 0, "P");
		fail();
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void ShouldThrowOutOfBoundsExceptionBecauseOfColumn() {
		final int GRID_ROWS = 1;
		final int GRID_COLS = 1;
		char [][] grid = {{'O'}};
		SearchWord.R = GRID_ROWS;
		SearchWord.C = GRID_COLS;
		SearchWord.search2D(grid, 0, GRID_COLS + 1, "P");
		fail();
	}
	
	@Test(expected=StringIndexOutOfBoundsException.class)
	public void ShouldThrowOutOfBoundsExceptionBecauseOfEmptyString() {
		final int GRID_ROWS = 1;
		final int GRID_COLS = 1;
		char [][] grid = {{'O'}};
		SearchWord.R = GRID_ROWS;
		SearchWord.C = GRID_COLS;
		SearchWord.search2D(grid, 0, 0, "");
		fail();
	}
	
	@Test
	public void ShouldExercisePath1() {
		final int GRID_ROWS = 14;
		final int GRID_COLS = 16;
		char [][] grid = {
 		        {'O','R','I','E','J','E','V','R','E','C','O','R','S','E','G','S'},
		        {'I','E','R','A','F','E','R','A','R','C','N','A','U','R','G','I'},
		        {'A','Z','I','A','P','I','S','C','A','R','A','R','G','I','M','I'},
		        {'M','I','C','S','C','E','S','T','E','R','T','T','F','A','D','V'},
		        {'O','D','O','A','D','E','N','E','G','R','I','S','S','E','I','S'},
		        {'O','C','S','A','D','T','E','C','N','O','L','O','G','O','E','A'},
		        {'A','T','I','R','C','O','P','I','H','T','O','M','B','A','D','O'},
		        {'O','L','I','R','S','A','A','O','C','H','P','A','N','E','R','O'},
		        {'P','V','X','E','T','R','C','E','C','O','A','I','Q','R','O','L'},
		        {'R','O','R','M','F','E','S','I','M','O','N','U','W','A','C','A'},
		        {'A','P','V','B','T','A','U','D','D','A','A','S','C','R','F','T'},
		        {'D','M','D','O','U','V','B','N','L','B','I','R','I','R','H','I'},
		        {'P','G','B','R','A','E','B','A','S','E','A','D','O','G','E','N'},
		        {'O','A','C','A','R','R','E','C','E','T','O','N','A','O','O','S'}
	       };
		SearchWord.R = GRID_ROWS;
		SearchWord.C = GRID_COLS;
		assertFalse("Encontrou P na 1ª linha", SearchWord.search2D(grid, 0, 0, "P"));
	}
	
	@Test
	public void ShouldExercisePath2() {// this one is not testavel
		
	}
	@Test
	public void ShouldExercisePath3() {// this one is not testavel
		/*final int GRID_ROWS = 1;
		final int GRID_COLS = 1;
		char [][] grid = {{'O','L','I'}};
		GFG.R = GRID_ROWS;
		GFG.C = GRID_COLS;
		assertFalse("Encontrou OL na 1ª linha", GFG.search2D(grid, 0, 0, "O"));*/
	}
	
	@Test
	public void ShouldExercisePath4() { //testavel
		final int GRID_ROWS = 14;
		final int GRID_COLS = 16;
		char [][] grid = {
 		        {'O','R','I','E','J','E','V','R','E','C','O','R','S','E','G','S'},
		        {'I','E','R','A','F','E','R','A','R','C','N','A','U','R','G','I'},
		        {'A','Z','I','A','P','I','S','C','A','R','A','R','G','I','M','I'},
		        {'M','I','C','S','C','E','S','T','E','R','T','T','F','A','D','V'},
		        {'O','D','O','A','D','E','N','E','G','R','I','S','S','E','I','S'},
		        {'O','C','S','A','D','T','E','C','N','O','L','O','G','O','E','A'},
		        {'A','T','I','R','C','O','P','I','H','T','O','M','B','A','D','O'},
		        {'O','L','I','R','S','A','A','O','C','H','P','A','N','E','R','O'},
		        {'P','V','X','E','T','R','C','E','C','O','A','I','Q','R','O','L'},
		        {'R','O','R','M','F','E','S','I','M','O','N','U','W','A','C','A'},
		        {'A','P','V','B','T','A','U','D','D','A','A','S','C','R','F','T'},
		        {'D','M','D','O','U','V','B','N','L','B','I','R','I','R','H','I'},
		        {'P','G','B','R','A','E','B','A','S','E','A','D','O','G','E','N'},
		        {'O','A','C','A','R','R','E','C','E','T','O','N','A','O','O','S'}
	       };
		SearchWord.R = GRID_ROWS;
		SearchWord.C = GRID_COLS;
		assertTrue("Nao encontrou AZIA na 2ª linha", SearchWord.search2D(grid, 2, 0, "AZIA")); //horizontal
		assertTrue("Nao encontrou TOAR na 5ª linha", SearchWord.search2D(grid, 5, 5, "TOAR")); //vertical
		assertTrue("Nao encontrou DICA na 10ª linha", SearchWord.search2D(grid, 10, 8, "DICA")); //diagonal esquerda cima
		assertTrue("Nao encontrou SIGO na 10ª linha", SearchWord.search2D(grid, 10, 11, "SIGO")); //diagonal direita baixo
		
		//assertTrue("Encontrou OL na 1ª linha", GFG.search2D(grid, 0, 0, "O"));
		
	}
	
	@Test
	public void ShouldExercisePath5() { //Nao testavel nas primeiras 7 iterações.
		/*final int GRID_ROWS = 1;
		final int GRID_COLS = 3;
		char [][] grid = {{'O','L','I'}};
		SearchWord.R = GRID_ROWS;
		SearchWord.C = GRID_COLS;
		assertFalse("Encontrou OL na 1ª linha", SearchWord.search2D(grid, 0, 0, "OLE"));*/
	}
	
	@Test
	public void ShouldExercisePath6() { //Nao testavel
	}
	
	@Test
	public void ShouldExercisePath7() { //Nao testavel p7 = (1,2,3,4,5,6,7,8,9,10,11,17,18,5,20)
		/*final int GRID_ROWS = 2;
		final int GRID_COLS = 16;
		char [][] grid = {
 		        {'O','R','I','E','J','E','V','R','E','C','O','R','S','E','G','S'},
		        {'I','E','R','A','F','E','R','A','R','C','N','A','U','R','G','I'}
	       };
		SearchWord.R = GRID_ROWS;
		SearchWord.C = GRID_COLS;
		assertTrue("Encontrou OL na 1ª linha", SearchWord.search2D(grid, 1, 15, "I"));
	*/}
	
	@Test
	public void ShouldExercisePath8() { //Nao testavel //Nao testavel p8 = (1,2,3,4,5,6,7,8,9,10,11,12,17,18,5,20)
		
	}
	
	@Test
	public void ShouldExercisePath9() { //Nao estavel nas primeiras 7 iteraçoes p9 = (1,2,3,4,5,6,7,8,9,10,11,12,13,17,18,5,20)
		/*final int GRID_ROWS = 2;
		final int GRID_COLS = 16;
		char [][] grid = {
 		        {'O','R','I','E','J','E','V','R','E','C','O','R','S','E','G','S'},
		        {'I','E','R','A','F','E','R','A','R','C','N','A','U','R','G','I'}
	       };
		SearchWord.R = GRID_ROWS;
		SearchWord.C = GRID_COLS;
		assertFalse("Encontrou OL na 1ª linha", SearchWord.search2D(grid, 0, 2, "IP"));*/
	}
	
	@Test
	public void ShouldExercisePath10() { //Nao testavel //PQ PARA SE atingir os nos 14-15-16 os caracteres ate ao momento têm de ser validados 
		//p10 = (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,8,17,18,5,20)
		/*
		final int GRID_ROWS = 2;
		final int GRID_COLS = 16;
		char [][] grid = {
 		        {'O','R','I','E','J','E','V','R','E','C','O','R','S','E','G','S'},
		        {'I','E','R','A','F','E','R','A','R','C','N','A','U','R','G','I'}
	       };
		SearchWord.R = GRID_ROWS;
		SearchWord.C = GRID_COLS;
		assertFalse("Encontrou IP na 1ª linha", SearchWord.search2D(grid, 0, 0, "ORIEJEVRECORSEGSPPP"));
	*/}
	
	
	@Test
	public void ShouldFindTheWOrd() {
		final int GRID_ROWS = 1;
		final int GRID_COLS = 3;
		char [][] grid = {{'O','L','A'}};
		SearchWord.R = GRID_ROWS;
		SearchWord.C = GRID_COLS;
		assertTrue("Não encontrou OLA na 1ª linha", SearchWord.search2D(grid, 0, 0, "OLA"));
	}
	
	
	
	/*
	@Test
	public void ShouldExercisePath3() {
		assertTrue("Não encontrou B na 3ª linha", GFG.search2D(grid, 0, 0, "OR"));
	}
	*/
/*
	@Test
	public void ShouldExercisePath4() {
		assertFalse("Não encontrou A na 3ª linha", GFG.search2D(grid, 2, 0, "B"));
	}
	
	*/
	/*
	@Test
	public void ShouldNotFind(){
		assertFalse("Encontrou a string fornecida", GFG.search2D(grid, 2, 0, "AES"));
	}

*/
}