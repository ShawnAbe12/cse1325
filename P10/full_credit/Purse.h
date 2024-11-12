#include <iostream>
class Purse {
    public:
        Purse(int pound =0, int shillings =0, int pence=0);

        int compare(const Purse& rhs);
        
        #ifdef __cpp_impl_three_way_comparison
            auto operator<=>(const Purse&) const = default;
        #else
            inline bool operator==(const Purse& rhs) {return (compare(rhs) == 0);}
            inline bool operator!=(const Purse& rhs) {return (compare(rhs) != 0);}
            inline bool operator< (const Purse& rhs) {return (compare(rhs) < 0);}
            inline bool operator<=(const Purse& rhs) {return (compare(rhs) <= 0);}
            inline bool operator> (const Purse& rhs) {return (compare(rhs) > 0);}
            inline bool operator>=(const Purse& rhs) {return (compare(rhs) >= 0);}

        #endif

        friend std::ostream& operator<<(std::ostream& os, const Purse& purse);

        Purse& operator++();   
        Purse  operator++(int); 

        Purse operator+(const Purse& purse);
        Purse operator-(const Purse& purse);
        Purse operator+=(const Purse& purse);
        Purse operator-=(const Purse& purse);


    private: 
        void rationalize();

    protected:
        int _pound, _shillings, _pence;

};