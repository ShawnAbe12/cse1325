#include <iostream>

int main(){
    std::string name;
    
    std::cout<< "What's is your name? " << std::endl;
    std::cin >> name; 
    
    std::cout <<"Hello, " << name << "!"<< std::endl;
    return 0;
}