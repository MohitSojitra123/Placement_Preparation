
obj1={
   name:"Mohit",
   std:12,
   about1:function(){
     console.log(`Name Is... ${this.name} std Is... ${this.std}`);
   },
   about2:function(result,pare){
    console.log(`Name Is... ${this.name}  Result Is... ${result} Parecentage... ${pare}`);
   }
};


obj2={
    name:"Rohit",
    std:11
};

obj1.about1.apply(obj2);
obj1.about1.apply(obj1);


obj1.about2.apply(obj2,["pass",86]);
obj1.about2.apply(obj1,["fail",58]);
