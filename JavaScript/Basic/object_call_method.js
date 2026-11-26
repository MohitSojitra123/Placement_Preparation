let obj1={
    name:"Mohit",
    std:12,
    about:function(){
        console.log(`Name Is ==> ${this.name} Std Is ==> ${this.std}`);
    },
   about1:function(result,per){
     console.log("Name Is ==> ",this.name," Result Is ==> ",result," Per ==> ",per);
   } 

};

let obj2={
     name:"Rohit",
     std:11
};


obj1.about.call(obj2);
obj1.about.call(obj1);


obj1.about1.call(obj2,"pass",92.00)
obj1.about1.call(obj1,"pass",76.00)
