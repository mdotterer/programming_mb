#include <iostream> 

#include "temperature.h"

int main(int argc, char* argv[])
{
    Temperature* lowLimit = new Temperature(32.0, Farenheit);
    Temperature* highLimit = new Temperature(100.0, Farenheit);
    Temperature* tempF;
    Temperature* tempC;
    double input;
    char output[8];

    std::cout << "Enter the temperature in degrees F : ";  
    std::cin >> input;

    tempF = new Temperature(input, Farenheit);
    tempC = new Temperature(tempF, Celsius);
    
    tempC->format(output);
    std::cout << "The temperature in Celsius is: " << output << std::endl;

    if(*tempF > highLimit) {
        std::cout << "Hydrate!!" << std::endl;
    }

    if(*tempF < lowLimit) {
        std::cout << "Pack Long Underwear!!" << std::endl;
    }

    return(0); // exits the program
}