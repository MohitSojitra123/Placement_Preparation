let array=[10,20,30,40,50,60];


// let array1=array.map(function(value){
//     return value*value;
// });

let array1=array.map(function(value,ind){
    return `${ind} => ${value*value}`;
});



console.log(array1);



