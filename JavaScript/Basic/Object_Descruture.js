let obj1={
    name:"Mohit",
    std:12,
    mobile_num:675843453,
    city:"Rajkot"
};

function obj_print({name,std,mobile_num,city}){
   console.log("Name => ",name);
    console.log("Std => ",std);
    console.log("mobile_num => ",mobile_num);
    console.log("city => ",city);
}

obj_print(obj1);