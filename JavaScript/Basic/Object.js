
let obj1={
    name:"Mohit",
    city:"Rajkot",
    address:"BAPS Kalawad Road...",
    num:[100,200,300,400,500,600]
};

console.log(obj1.city);
console.log(obj1["address"]);
console.log(obj1.num[0]);
console.log(obj1.num[4]);
console.log(obj1.num);


// Add Value

obj1.Id="mohit@123";
obj1["gender"]="Male";

console.log(obj1);

// Use Variable As a Key

let key="E_mail";

obj1[key]="Mohit@123gmail.com";

console.log(obj1);