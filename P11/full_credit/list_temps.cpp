#include <iostream>
#include "Date.h"
#include <map>
#include <fstream>


typedef double Temp;
using namespace std;

int main(int argc, char *argv[]){
    Temp t;
    ifstream infile;
    string line, substring;
    std::map<Date, Temp> temps = {};
    int date[3];
    int location, counter = 0;


    if (argc != 2) {
        cerr << "Usage: <progam name> <data file>\n";
        return -1;
    }

    infile.open(argv[1]);
    if(infile.fail()){
        cout << "The file failed to open";
    }else{
        while(std::getline(infile,line,',')){
            try
            {
                if(counter != 3){
                    int x = stoi(line);
                    std::cout << x <<  std::endl;
                    date[counter] = x;
                    counter++;
                }else{
                    counter= 0;
                    t = stod(line);
                    std::cout << t << std::endl;
                    Date d(date[0],date[1],date[2]);

                    temps[d] = t;

                }
                

            }
            catch(const std::exception& e)
            {
                // std::cerr << e.what() << '\n';
            }        
        }

    }
    infile.close();


    //USE STRING STREAM TO USE FILE INPUT
    

}