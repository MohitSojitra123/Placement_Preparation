

let array1=[1,2,3,4,5];


let ans=array1.reduce(function(accumulator,current_value){
   return accumulator+current_value;
});

console.log(ans);


// accumulator   current_value   returm 
//  1                2        =    3
//  3                3        =    6
//  6                4        =   10
// ...
// ...  


let user_cart=[
    {product:"pro_1",id:101,prince:1200},
    {product:"pro_2",id:102,prince:1100},
    {product:"pro_3",id:103,prince:1300}
];


let ans1=user_cart.reduce(function(accumulator,current_val){
      return accumulator+current_val.prince;
},0);

console.log(ans1);
