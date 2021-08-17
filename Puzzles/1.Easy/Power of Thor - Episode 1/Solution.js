/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/

var inputs = readline().split(' ');
var lightX = parseInt(inputs[0]); // the X position of the light of power
var lightY = parseInt(inputs[1]); // the Y position of the light of power
var initialTx = parseInt(inputs[2]); // Thor's starting X position
var initialTy = parseInt(inputs[3]); // Thor's starting Y position

// game loop
while (true) {
    const remainingTurns = parseInt(readline()); // The remaining amount of turns Thor can move. Do not remove this line.

    // Write an action using console.log()
    // To debug: console.error('Debug messages...');
     if (initialTx<lightX&&initialTy==lightY){
              
               console.log("E");
               initialTx++;

           }
           else if(initialTx>lightX&&initialTy==lightY){
                console.log("W");
                    initialTx--;


           }
           if (initialTy>lightY&&initialTx==lightX) {
               console.log("N");
               initialTy--;



           }
           else if (initialTy<lightY&&initialTx==lightX){
                     console.log('S');
                     initialTy++;


           }
           if(initialTx>lightX&&initialTy<lightY){
                 console.log('W');
                 initialTx--;


           }
           if(initialTx<lightX&&initialTy<lightY){
                console.log('SE');
                initialTx++;
                initialTy++;
           }
           else if (initialTx>lightX&&initialTy<lightY){

           console.log('SW');
                initialTx--;
                initialTy++;


           } 


    
}

