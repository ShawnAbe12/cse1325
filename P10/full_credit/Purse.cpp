#include <iostream>
#include "Purse.h"
        Purse::Purse(int hours, int minutes, int seconds)
            : _pound{hours}, _shillings{minutes}, _pence{seconds} {}
        
        std::ostream& operator<<(std::ostream& os, const Purse& purse){
            char poundSymbol = 156; 
            os << poundSymbol <<purse._pound<< " " << purse._shillings << "s" << purse._pence << "d";
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
            ++_pence;
            rationalize();
            return *this;
        }
        Purse Purse::operator++(int){
            Purse results{*this};
            _pence++;
            rationalize();
            return results;
        } 

        Purse Purse::operator+(const Purse& purse){
            Purse p;
            p._pound = this->_pound + purse._pound;
            p._shillings =this->_shillings + purse._shillings;
            p._pence = this->_pence + purse._pence;
            return p;
        }
        Purse Purse::operator-(const Purse& purse){
            // add the carry over stuff
            Purse p;

            while(this->_pence - purse._pence < 0){
                    if(this->_shillings > 0){
                        this->_shillings--;
                    }
                    else{
                        if(this->_pound > 0){
                            this->_pound--;
                            this->_shillings +=19;
                        }
                    }
                    this->_pence += 12;
            }
            
            while(this->_shillings - purse._shillings < 0){
                    if(this->_pound > 0){
                        this->_pound--;
                    }
                    else{
                        std::cout<< "Can't subtract these numbers because it results in negative numbers" << std::endl;
                        return p;
                    }
                    
                    this->_shillings += 20;
            }

            p._pence = this->_pence - purse._pence;
            p._pound = this->_pound - purse._pound;
            p._shillings =this->_shillings - purse._shillings;
            return p;
        }
        Purse Purse::operator+=(const Purse& purse){
            this->_pound += purse._pound;
            this->_shillings += purse._shillings;
            this->_pence += purse._pence;

            return*this;
        }
        Purse Purse::operator-=(const Purse& purse){
            // add all the carry over stuff
            while(this->_pence - purse._pence < 0){
                    if(this->_shillings > 0){
                        this->_shillings--;
                    }
                    else{
                        if(this->_pound > 0){
                            this->_pound--;
                            this->_shillings +=19;
                        }
                    }
                    this->_pence += 12;
            }
            
            while(this->_shillings - purse._shillings < 0){
                    if(this->_pound > 0){
                        this->_pound--;
                    }
                    else{
                        std::cout<< "Can't subtract these numbers because it results in negative numbers" << std::endl;
                        return *this;
                    }
                    
                    this->_shillings += 20;
            }
            this->_pound -= purse._pound;
            this->_shillings -= purse._shillings;
            this->_pence -= purse._pence;

            return*this;
        } 

        void Purse::rationalize(){

            while(this->_pence >= 12){
                this->_pence -= 12;
                this->_shillings += 1;
            }

            while(this->_shillings >= 20){
                this->_shillings -= 20;
                this->_pound += 1;
            }

            if(this->_pence < 0 && this->_shillings < 0 && this->_pound < 0){
                std::cout << "There is a value less than zero " << std::endl;
            }


            
        }
        
    
        int _pound, _shillings, _pence;

