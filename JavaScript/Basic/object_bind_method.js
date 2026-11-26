function about(){
    console.log(`Name Is ==> ${this.name} Std Is ==> ${this.std}`);
}

function about1(res){
    console.log(`Name Is ==> ${this.name} Result Is ==> ${res}`);
}

let obj1={
    name:"Mohit",
    std:12
};



const func=about.bind(obj1);

const fun1=about1.bind(obj1,"Pass");


func();
fun1();
