// Optional Chaining

const user={
    firstName:"harshit",
    address:{houseNUmber:'1234'}
    // city:"Rajkot"
}

console.log(user.firstName);
console.log(user.address);
console.log(user.address.houseNUmber);

// ? ==> check 
console.log(user?.city);
