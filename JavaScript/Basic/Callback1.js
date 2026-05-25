function sum(a,b){
   return a+b;
}

function sub(a,b){
    return a-b;
}

function  mul(a,b){
    return a*b;
}

function div(a,b){
    return a/b;
}



function cal(a,b,fun){
    return fun(a,b);
}


// cal Is Called Higher Order Function
// mul Is Called Higher Callback Function
// sum.. Is Called Higher Callback Function

console.log(cal(10,2,mul));

let ans=cal(10,20,sum);

console.log(ans);