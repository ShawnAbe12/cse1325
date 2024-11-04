#include <iostream>
#include "clock.h"

int main(int argc, char *argv[]){
    bool is_on = true;

    // std::cin >> hours >> minutes >> seconds;
     if (argc != 4) {
        std::cerr << "Usage: <hours> <minutes> <seconds>\n";
        return -1;
    }

    std::cout<< "\nEnter \'q\' to exit\n" << std::endl;
    int hours = std::stoi(argv[1]);
    int minutes = std::stoi(argv[2]);
    int seconds= std::stoi(argv[3]);

    Clock c(hours,minutes,seconds);
    c.print();
    // c.tic();

    while(is_on){
        std::string input;
        std::getline(std::cin, input);
        if(input.compare("q") == 0){
            is_on = false;
            break;
        }
        c.tic();
        c.print();
    }
    
    return 0;
    
}
