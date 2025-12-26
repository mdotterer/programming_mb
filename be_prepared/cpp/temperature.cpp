#include <stdio.h>
#include <stdlib.h>

#include "temperature.h"

Temperature::Temperature(double newValue, TemperatureScale newScale)
{
    value = newValue;
    scale = newScale;
}
 
Temperature::Temperature(Temperature* other, TemperatureScale newScale)
{
    scale = newScale;
    if(other->scale == newScale) 
    {
        value = other->value;
    } else if(newScale == Celsius) {
        value = 5*(other->value-32)/9;
    } else {
        value = (9*other->value/5)+32;
    }
}

void Temperature::format(char* output)
{
    snprintf(output, 8, "%0.2g °%s", value, scale == Farenheit ? "F" : "C");
}

bool Temperature::operator<(Temperature* other)
{
    bool result;
    
    Temperature* converted = new Temperature(other, scale);
    result = value < (converted->value);

    delete converted;

    return result;
}

bool Temperature::operator>(Temperature* other)
{
    bool result;
    
    Temperature* converted = new Temperature(other, scale);
    result = value > (converted->value);

    delete converted;

    return result;
}