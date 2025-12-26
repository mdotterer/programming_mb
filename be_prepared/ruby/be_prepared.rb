def ask(prompt)
    print prompt
    gets
end

temp_f = ask("Enter Temperature in degrees F : ").to_f
temp_c = (temp_f - 32)*5/9
puts "Temperature Degrees C: #{temp_c}"
 
if temp_f > 100
    puts "Hydrate!!"
end

if temp_f < 32
    puts "Pack Long Underwear!!"
end
