
// Set 
// Store Data
// Sets Also Have its own method
// No Index-based access
// Unique Items Only (No Duplicates Allowed)



const number=new Set([1,2,3,4,5,5]);


number.add(6);
console.log(number);


if(number.has(23)){
   console.log("Present...");
}else{
    console.log("Not Present...");
}

for(let s of number){
   console.log(s);
}

// array Unique Element Find Using set

let array=[1,2,3,1,2,3,4,5,6,4,5,6,7,8,9,7,8,9,10,10];

let unique_element=new Set(array);

console.log(unique_elem);