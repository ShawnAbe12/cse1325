#include <iostream>
#include "Date.h"
#include <iomanip>
#include <map>
#include <fstream>


typedef double Temp;
using namespace std;

int main(int argc, char *argv[]){
    Temp t;
    ifstream infile;
    string line, substring;
    std::map<Date, Temp> temps;
    int date[3];
    int location, counter = 0;

    // Date d{1970, 20, 20};
    // Date p{1970, 21, 22};
    // t = 69.1;
    // temps[p] =t; 
    // cout<<temps[p]<< endl;


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
                    // std::cout << x <<  std::endl;
                    date[counter] = x;
                    counter++;
                }else{
                    counter= 0;
                    t = stod(line);
                    
                    Date d(date[2],date[1],date[0]);

                    temps[d] = t;

                }
                

            }
            catch(const exception& e){}      
        }

    }
    infile.close();

    while (true) {
        cout << "Enter start date (YYYY MM DD): ";
        int startYear, startMonth, startDay;
        if (!(cin >> startYear >> startMonth >> startDay)) {
            break;
        }

        cout << "Enter end date (YYYY MM DD): ";
        int endYear, endMonth, endDay;
        if (!(cin >> endYear >> endMonth >> endDay)) {
            break;
        }

        Date begining(startYear, startMonth, startDay);
        Date end(endYear, endMonth, endDay);

        for (auto it = temps.begin(); it != temps.end(); it++) {
            
            const Date& date = it->first;
            const Temp& temperature = it->second;

            if (date >= begining && date <= end) {
                cout << date << "   " <<fixed << setprecision(1) << setfill('0') << right << temperature << endl;
            }
        }

       
    }




    

}