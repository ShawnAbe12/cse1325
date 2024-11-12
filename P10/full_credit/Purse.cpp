#include <iostream>
#include <iomanip>
#include "Purse.h"
        Purse::Purse(int hours, int minutes, int seconds)
            : _pound{hours}, _shillings{minutes}, _pence{seconds} {}
        
        std::ostream& operator<<(std::ostream& os, const Purse& purse){
            os << "£" <<purse._pound<< " " << purse._shillings << "s" << purse._pence << "d";
            return os;
        }

        int Purse::compare(const Purse& rhs) {
            if(_pound <rhs._pound ) return -1;
            if(_pound >rhs._pound ) return 1;
            if(_shillings<rhs._shillings) return -1;
            if(_shillings>rhs._shillings) return 1;
            if(_pence <rhs._pence ) return -1;
            if(_pence >rhs._pence ) return 1;
            return 0;
        }

        Purse& Purse::operator++(){

        }
        // Purse  operator++(int); 

        // Purse operator+(const Purse& purse);
        // Purse operator-(const Purse& purse);
        // Purse operator+=(const Purse& purse);
        // Purse operator-=(const Purse& purse);        
        
    
        int _pound, _shillings, _pence;

