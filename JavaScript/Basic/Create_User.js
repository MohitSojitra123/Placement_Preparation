
function creuser(f_name,l_name,age,email,city){
  
    let creuser={};

    creuser.f_name=f_name;
    creuser.l_name=l_name;
    creuser.age=age;
    creuser.email=email;
    creuser.city=city;

    creuser.print_date=function(){
        console.log(`Frist Name Is => ${f_name} Last Name Is => ${l_name} age Is => ${age}`);
    }

    creuser.check_age=function(){
        if(age>=18){
            return true;
        }else{
            return false;
        }     
    }
     return creuser;
};

let user1=creuser("mohit","sojitra",19,"abc123@gmail.com","rajkot");

console.log(user1);

console.log(user1.check_age());

user1.print_date();
 

