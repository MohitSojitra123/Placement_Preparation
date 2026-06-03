// Synchronous Code Runs Line by Line . Each Operation Must Compleete Before The next One Starts

// Asynchronous Code can Start a Task and Move on Without Waiting for it to finish
// Asynchronous Code execution allows to execute next instructions code immediately and doesn't block the flow


// settimeout setinterval is by default asynchronus Means At a Time  Not Block Any Process Execution Start All The Code 

setTimeout(()=>{
   console.log("3000 Second : ");
},3000);



setTimeout(()=>{
   console.log("2000 Second : ");
},5000);


setTimeout(()=>{
   console.log("5000 Second : ");
},7000);