
let array=["Hello","Cat","Dog","Lion"];

// Find Method 

// return frist 3 character length...
let find1=array.find(function(str){
    return str.length === 3;
});

console.log(find1);

let array1=[
    {user_id:1,user_name:"Mohit",std:12},
    {user_id:2,user_name:"Rahul",std:11},
    {user_id:3,user_name:"Het",std:10},
    {user_id:4,user_name:"Deep",std:10}
]; 

const array1_ans=array1.find(function(check){
       return check.user_id===3;
})

console.log(array1_ans);

// Find Method 



