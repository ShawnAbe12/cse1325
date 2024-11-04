#include <iostream>
class Clock {
    public:
        Clock(int hours, int minutes, int seconds);
        void tic();
        void print();
        virtual ~ Clock(){} 
    protected:
        int _hours, _minutes, _seconds;
};