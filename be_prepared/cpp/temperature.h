#ifndef __TEMPERATURE_H__
#define __TEMPERATURE_H__

enum TemperatureScale {Celsius, Farenheit};

class Temperature
{
    protected:

    TemperatureScale scale;
    double value;

    public:

    Temperature(double newValue, TemperatureScale newScale);
    Temperature(Temperature* other, TemperatureScale newScale);
    
    void format(char* output);

    bool operator<(Temperature* other);
    bool operator>(Temperature* other);
};

#endif