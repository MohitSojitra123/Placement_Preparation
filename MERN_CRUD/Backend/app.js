const express=require('express');
const Connect_DataBase=require("./src/config/db.js");
const Student_Route = require('./src/Routes/Student.route.js');

Connect_DataBase();

const app=express();

app.use(express.json());

app.get("/",(req,res)=>{
      res.send("Wroking Properlyyy : ");     
})

app.use("/Student",Student_Route)

app.listen(8000,()=>{
     console.log("Server Is Running : http://localhost:8000 ")
})