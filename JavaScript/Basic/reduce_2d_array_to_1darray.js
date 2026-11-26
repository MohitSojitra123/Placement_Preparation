let array=[
    ["a1","a2"],
    ["b1","b2"],
    ["c1","c2"],
    ["d1","d2"],
    ["e1","e2"]
];

console.log(array);

let arr=array.reduce(function(acumulator,curentval){
         return acumulator.concat(curentval);   
});

console.log(arr);