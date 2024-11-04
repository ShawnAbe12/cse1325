#include <iostream>
#include <iomanip>


class Clock{
    public:
        Clock(int hours, int minutes, int seconds)
            : _hours{hours}, _minutes{minutes}, _seconds{seconds} {
            if (hours < 0 || hours > 23) throw std::out_of_range{"Invalid Hours Input"};
            if (minutes < 0|| minutes > 59) throw std::out_of_range{"Invalid Minutes Input"};
            if (seconds < 0 || seconds > 59) throw std::out_of_range{"Invalid Seconds Input"};
            }
        virtual ~ Clock(){} 
        void tic(){
            _seconds++;
            if (_seconds >=60){
                _minutes++;
                _seconds = 0;
            }
            if(_minutes >= 60){
                _hours++;
                _minutes =0;
            }
            if(_hours == 24){
                _hours = 0;
            }
        }
        void print(){
            std::cout << "The time is now: ";
            std::cout << std::setw(2) << std::setfill('0') << _hours <<":"<< std::setw(2) << std::setfill('0') << _minutes <<":"<< std::setw(2) << std::setfill('0') << _seconds;
        }
    
     

    protected:
        int _hours, _minutes, _seconds;
};

