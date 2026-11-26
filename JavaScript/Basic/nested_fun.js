function outer_fun(){

     function sum(a,b){
           return a+b;
     }


     function multi(a,b){
        return a*b;
     }

     function show(){
        console.log("Working Properly...");
     }

     console.log("Inner Function...");

     console.log(sum(10,2));
     console.log(multi(10,3));
     show();

}


outer_fun();