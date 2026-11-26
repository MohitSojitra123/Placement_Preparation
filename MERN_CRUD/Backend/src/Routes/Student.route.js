const express=require('express');
const Student=require('../model/Student.model.js');
const {GetAllStudent,AddStudent,DeleteStudent,GetOneStudent,UpdateStudent,DeleteAllStudent} = require('../Controllers/Student.Controllers.js');

const Student_Route=express.Router();


Student_Route.get("/",GetAllStudent);
Student_Route.get("/:id",GetOneStudent);
Student_Route.post("/Add",AddStudent);
Student_Route.delete("/Delete/:id",DeleteStudent);
Student_Route.delete("/DeleteAll",DeleteAllStudent);
Student_Route.patch("/Update/:id",UpdateStudent);

module.exports=Student_Route;