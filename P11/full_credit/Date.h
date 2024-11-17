#include <iostream>

class Date{
    public:
        Date(int year = 1970, int month = 1, int day = 1);

        int compare(const Date& rhs);

        #ifdef __cpp_impl_three_way_comparison
            auto operator<=>(const Date&) const = default;
        #else
            inline bool operator==(const Date& rhs) {return (compare(rhs) == 0);}
            inline bool operator!=(const Date& rhs) {return (compare(rhs) != 0);}
            inline bool operator< (const Date& rhs) {return (compare(rhs) < 0);}
            inline bool operator<=(const Date& rhs) {return (compare(rhs) <= 0);}
            inline bool operator> (const Date& rhs) {return (compare(rhs) > 0);}
            inline bool operator>=(const Date& rhs) {return (compare(rhs) >= 0);}

        #endif

        friend std::ostream& operator<<(std::ostream& os, const Date& date);
    private:
        int _year, _month, _day;  
};