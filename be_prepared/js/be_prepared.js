import readline from 'readline';

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.question("Enter Temperature in degrees F : ", (answer) => {
    const tempF = parseFloat(answer);
    const tempC = (tempF - 32)*5/9;
    console.log("Temperature Degrees C: " + tempC);
    
    if(tempF > 100) {
        console.log("Hydrate!!");
    }

    if(tempF < 32) {
        console.log("Pack Long Underwear!!");
    }

    process.exit(0);
});

