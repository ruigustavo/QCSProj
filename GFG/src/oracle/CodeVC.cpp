// C++ programs to search a word in a 2D grid 
#include<bits/stdc++.h> 
#include <string>
#include <sstream>
using namespace std; 

// Rows and columns in given grid 
// #define R 3 
//#define C 14 

// For searching in all 8 direction 
int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 }; 
int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 }; 
//char grid[][];
int R, C;
std::ofstream myfile;
string fileName;
string input;


void writeValues(string id, string posX, string posY){
    myfile <<  id+"," ;
      myfile << posX+",";
      myfile << posY;
      myfile << "\n";
}
void writeHeaderToCSV(){
    
      myfile.open ("cpp_outputs.csv");
      myfile << "input,";
      myfile <<  "posX," ;
      myfile << "posY";
      myfile << "\n";
}

// This function searches in all 8-direction from point 
// (row, col) in grid[][] 
bool search2D(char grid[][100], int row, int col, string word) 
{ 
	// If first character of word doesn't match with 
	// given starting point in grid. 
	if (grid[row][col] != word[0]) 
	return false; 

	int len = word.length(); 

	// Search word in all 8 directions starting from (row,col) 
	for (int dir = 0; dir < 8; dir++) 
	{ 
		// Initialize starting point for current direction 
		int k, rd = row + x[dir], cd = col + y[dir]; 

		// First character is already checked, match remaining 
		// characters 
		for (k = 1; k < len; k++) 
		{ 
			// If out of bound break 
			if (rd >= R || rd < 0 || cd >= C || cd < 0) 
				break; 

			// If not matched, break 
			if (grid[rd][cd] != word[k]) 
				break; 

			// Moving in particular direction 
			rd += x[dir], cd += y[dir]; 
		} 

		// If all character matched, then value of must 
		// be equal to length of word 
		if (k == len) 
			return true; 
	} 
	return false; 
} 

// Searches given word in a given matrix in all 8 directions 
void patternSearch(char grid[][100], string word) 
{ 
	// Consider every point as starting point and search 
	// given word 
	for (int row = 0; row < R; row++) 
	for (int col = 0; col < C; col++) 
		if (search2D(grid, row, col, word)){
			//cout << "pattern found at " << row << ", " << col << endl;
			writeValues(input,std::to_string(row),std::to_string(col)); 
		}
			
} 



// Driver program 
int main() 
{ 
	writeHeaderToCSV();
	//LER FICHEIRO
	//read input
	//for(int i=10;i <=40;i++ ){ // cycle to boundary inputs
	for(int i = 1; i < 10 ;i++ ){ // cycle to partitioning inputs
	std::ostringstream p;
	p << "" << i << ".txt";
	std::string query1(p.str());

	std::ostringstream s;
	//s << "/home/ruigustavo/Desktop/Project2-QCS/PythonVersion/my-project-env/oracle/inputs_boundary/i" << query1;
	s << "/home/ruigustavo/Desktop/Project2-QCS/PythonVersion/my-project-env/oracle/inputs_partitioning/i" << query1;
	std::string query(s.str());

	input = query1;
	fileName = query;
	std::ifstream file( fileName, ios::in );
    string part1, word,part3, part4;
    
    if( !file )
        cerr << "Cant open " << endl;

    file >> R >> C;

    char grid[100][100];
    //cout << R << " " << C;

    char c;
    for (int row = 0; row < R; row++) {
        file >> part1;
        for (int col = 0; col < C; col++){
                grid[row][col] = part1[col];
            //cin >> ; 
        }
    }
    
    /*for(int i=0; i <R;i++){
        cout << "\n";
        for(int j=0; j < C;j++){
            cout << grid[i][j];
        }
        
    }*/

    file >> word;
    //cout <<"\n" + word << "\n";
    file.close();

    
	patternSearch(grid, word);
	} 
	cout << endl; 
	//patternSearch(grid, "EEE"); 
	return 0; 
} 

