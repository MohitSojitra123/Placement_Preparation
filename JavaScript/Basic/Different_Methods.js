const pricesUSD = [10, 20, 30];
console.log(pricesUSD.map(price => price * 82)); 

const students = [45, 60, 78, 30, 90];
console.log(students.filter(score => score > 50)); 

const products = ["Laptop", "Mobile", "Tablet"];
products.forEach(product => console.log(product));

const fruits = ["Apple", "Banana", "Mango"];
console.log(fruits.indexOf("Mango")); 

const numbers = [12, 15, 8, 25,30,16];
const evenIndex = numbers.findIndex(num => num % 2 === 0);
console.log(evenIndex); 

const roles = ["admin", "editor", "viewer"];
console.log(roles.includes("admin")); 
console.log(roles.includes("guest")); 

const stock = [10, 15, 8, 20];
console.log(stock.every(item => item > 5)); 

const stock = [10, 0, 8, 20];
console.log(stock.some(item => item === 0));