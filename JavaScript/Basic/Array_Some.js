// some Method
// any one Element Return True Than Ans Is True

let array=[3,5,7,9,13,15,20];


let ans=array.some(function(check){
     return check%2===0;
});

console.log(ans);


let array_obj=[
    {pro_id:101,pro_name:"item1",pro_price:12000},
    {pro_id:102,pro_name:"item2",pro_price:14000},
    {pro_id:103,pro_name:"item3",pro_price:15000},
    {pro_id:104,pro_name:"item4",pro_price:16000},
    // {pro_id:105,pro_name:"item5",pro_price:10000}
    {pro_id:105,pro_name:"item5",pro_price:110000}
];


let obj_ans=array_obj.some(function(check){
    return check.pro_price>100000;
});

console.log(obj_ans);




