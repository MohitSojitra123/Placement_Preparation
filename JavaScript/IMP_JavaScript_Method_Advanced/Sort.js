let array1=[3,6,11,7,2,1,8,1200,410,12,10,4,5,9];

array1.sort(function(a,b){
    return a-b;
    // return b-a;
});

console.log(array1);


// 1200 410

// a-b ===> 790
// a-b ===> positive (greater than 0) ===> b,a
// 410 , 1200

// a-b ===> negative ===> a,b
// 5,9 ===> -4

let array_obj=[

    {product_id:101,product_name:"item1",product_price:300},
    {product_id:102,product_name:"item2",product_price:200},
    {product_id:103,product_name:"item3",product_price:400},
    {product_id:104,product_name:"item4",product_price:100},
    {product_id:105,product_name:"item5",product_price:600},
    {product_id:106,product_name:"item6",product_price:700},
    {product_id:107,product_name:"item7",product_price:500}

];

array_obj.sort(function(a,b){
      return a.product_price-b.product_price; 
});

console.log(array_obj);