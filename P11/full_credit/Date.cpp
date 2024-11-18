#include <iostream>
#include <iomanip>
#include "Date.h"


        Date::Date(int year, int month, int day)
            : _year{year}, _month{month}, _day{day} {}
        
        std::ostream& operator<<(std::ostream& os, const Date& date){
            os << date._year << "/" << std::setw(2) << std::setfill('0') << date._month << "/" << std::setw(2) << std::setfill('0')<< date._day << "";
            return os;
        }
        int Date::compare(const Date& rhs) const{
            if(_year <rhs._year ) return -1;
            if(_year >rhs._year ) return 1;
            if(_month<rhs._month) return -1;
            if(_month>rhs._month) return 1;
            if(_day <rhs._day ) return -1;
            if(_day >rhs._day ) return 1;
            return 0;
        }
        

        int _year, _month, _day;