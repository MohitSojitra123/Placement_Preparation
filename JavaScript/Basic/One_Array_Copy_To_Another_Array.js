// Using Slice Method Copy ONe Array to Another array To Reference Type 


let array1=[10,20,30,40,50,60,70,80,90,100];

let array2=array1.slice(0);
// let array2=array1.slice(0).concat([110,120,130,140]);

// Using Spread Operator

// let array2=[...array1];
// let array2=[...array1,110,120];


console.log(array1);
console.log(array2);


let array123=[..."123456789"];
console.log(array123);

let obj1={
    key1:"value1",
    key2:"value2",
    key3:"value3"
}

let obj2={
    key4:"value4", 
    key5:"value5", 
    key6:"value6", 
}

let obj3={...obj1,...obj2};
console.log(obj3);

let obj4={..."abcdef"};
console.log(obj4);