let first_name = "AB";
let age=10;

function Print_Full_Name() {
    let middle_name = "CD";
    let last_name = "Ef";

    console.log(
        "First Name : " + this.first_name +
        " Middle Name : " + middle_name +
        " Last Name : " + last_name +
        " Age : "+this.age
    );
}

// 1. call()
Print_Full_Name.call({first_name,age });

// 2. apply()
Print_Full_Name.apply({ first_name ,age });

// 3. bind()
let myFunction = Print_Full_Name.bind({ first_name: first_name ,age});
myFunction();