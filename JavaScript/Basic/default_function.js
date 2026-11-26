// Default Value
function sayName(name="rahul"){
    console.log("My Name Is...",name);
}

sayName("Jeet");
sayName();

// Variable value pass in function
function sayName2(fname,lname=fname.toUpperCase()){
     console.log("fname Is...",fname," lname Is...",lname);
}
sayName2("yooo");
sayName2("yooo","booo");

// Array Pass In Argument

function sayName3(name=["rahul","keval","rohit"]){
    console.log("Name Is...",name);
}

sayName3();

// Function Pass In Argument
function age(){
    return 180;
}

function sayName4(name="Babber",a=age()){
    console.log(name," ",a);
}

sayName4();