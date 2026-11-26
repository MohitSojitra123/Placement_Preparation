// splice
// start , delete , insert

let array=['itme1','item2','item3','item4','item5','item6'];

// delete
//let delete_item = array.splice(1,2);
// console.log(delete_item);

// insert
// 0 => start
// 0 => no delete 0 
// insert value
// array.splice(0,0,'item0');

// insert and delete
array.splice(1,2,"insert item 2","insert item 3");


console.log(array);