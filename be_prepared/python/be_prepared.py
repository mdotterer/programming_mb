sDegreeF = input("Enter temperature in degrees Fahrenheit (F): ")
 
nDegreeF = int(sDegreeF)
 
nDegreeC = (nDegreeF - 32) * 5 / 9
 
print ("Temperature in degrees C is:", nDegreeC)
 
if nDegreeF < 32:
    print ("Pack long underwear!")
 
if nDegreeF > 100:
    print ("Hydrate!!")