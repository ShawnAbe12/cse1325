#include <iostream>
#include <map>
#include <string>
#include "Purse.h"


int main(){
    int account_num;

    std::cout << "Welcome to Ye Olde Bank of Merry England \n" << std::endl;
    std::cout << "How Many Accounts? " << std::endl;

    std::cin >> account_num;
    std::cin.ignore();

    // std::map<Purse> vault = {}; 
    std::map<std::string, Purse> vault = {};
    

    for (int i =0; i< account_num; i++){
        int pounds = 0, shillings =0 , pence =0;
        std::string name;
        
        std::cout<< "Account Name " << i<< " ";   
        std::getline(std::cin, name);
        std::cout << "\n";

        std::cout << "Enter your Initial Deposit (pounds shillings pence): "; 
        std::cin >> pounds >> shillings >> pence;
        Purse p{pounds,shillings,pence};
        std::cin.ignore();

        std::cout << "\n";
        vault[name] = p;
    }

    Purse total;
    std::cout << "Account List \n--------------------" << std::endl;
    for (const auto& [name, purse] : vault) {
        total += purse;
        std::cout << "\t" <<name << " with " << purse << std::endl;
    }

    std::cout << "\nTotal in bank " <<total << std::endl;


    //Checking Subtraction
    // Purse p{2,0,0};
    // Purse c{0,11,11};
    // std::cout<< p - c << std::endl;
    // std::cout<< p -= c << std::endl;



    //Checking comparison Operations
    // Purse p{10,11,12};
    // Purse c{10,12,12};

    // if(p > c){
    //     std::cout<< "here > ";
    // }
    // if(p < c){
    //     std::cout<< "here < ";
    // }
    // if (p == c){
    //     std::cout << " here == ";
    // }
    // if(p != c){
    //     std::cout<< "here != ";
    // }
    // if(p <= c){
    //     std::cout<< "here <= ";
    // }
    // if (p >= c){
    //     std::cout << " here >= ";
    // }


    // Checking Pre-increment and Post_increment
    // std::cout<< ++p << " " << p << p++<< " " << p << std::endl;




}