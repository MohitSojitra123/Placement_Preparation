
array=[
    {id:1,name:"rohit",std:12},
    {id:2,name:"rahul",std:11},
    {id:3,name:"jeet",std:10}
]


console.log(array);


// destructuring...

// let [user1,user2,user3]=array;
let [{name:username1},user2,user3]=array;

console.log("Destructuring Of array inside Object...");
console.log(user2);
console.log(user3);


console.log(username1);
