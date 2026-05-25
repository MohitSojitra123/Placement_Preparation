let arr1=[1,2,3,4,5];

let arr2=arr1.map(function(e1){
    return e1*2;
}).filter(function(e1){
    return e1>8;
})

console.log(arr2);
