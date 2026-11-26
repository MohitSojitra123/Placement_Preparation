
function sum_all(...total) {
      let sum=0;
      for(let total1 of total){
         sum+=total1;
      }

      return sum;
}


console.log(sum_all(10,20,30,40,50));
