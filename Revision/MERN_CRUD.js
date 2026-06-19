const express = require("express");
const mongoose = require("mongoose");

const app = express();

// Middleware
app.use(express.json());


// MongoDB Connection

mongoose.connect("mongodb://127.0.0.1:27017/studentDB")
.then(()=>{
    console.log("MongoDB Connected");
})
.catch((err)=>{
    console.log(err);
});

// Schema

const studentSchema = new mongoose.Schema({
    name:{
        type:String,
        required:true
    },
    age:{
        type:Number,
        required:true
    },
    email:{
        type:String,
        required:true
    }
});

// Model
const Student = mongoose.model(
    "Student",
    studentSchema
);

// ==========================
// ADD STUDENT
// POST API
// ==========================

app.post("/student/add", async(req,res)=>{
    try{
        const student = new Student(req.body);
        const data = await student.save();
        res.status(201).json({
            success:true,
            message:"Student Added Successfully",
            data:data
        });
    }
    catch(error){
        res.status(500).json({
            success:false,
            message:error.message
        });
    }
});
// ==========================
// FIND ALL DATA
// GET API
// ==========================
app.get("/student/all",async(req,res)=>{
    try{
        const data = await Student.find();
        res.status(200).json({
            success:true,
            count:data.length,
            data:data
        });
    }
    catch(error){
        res.status(500).json({
            success:false,
            message:error.message
        });
    }
});

// ==========================
// FIND ONE DATA BY ID
// GET API
// ==========================


app.get("/student/:id",async(req,res)=>{


    try{
        const data = await Student.findById(
            req.params.id
        );
        if(!data){
          return res.status(404).json({
                success:false,
                message:"Student Not Found"
            });
        }

        res.status(200).json({
            success:true,
            data:data
        });
    }
    catch(error){
        res.status(500).json({
            success:false,
            message:error.message
        });
    }
});

// ==========================
// UPDATE BY ID
// PUT API
// ==========================

app.put("/student/:id",async(req,res)=>{
    try{
        const data = await Student.findByIdAndUpdate(
            req.params.id,
            req.body,
            {
                new:true
            }
        );
        if(!data){
            return res.status(404).json({
                success:false,
                message:"Student Not Found"
            });
        }
        res.status(200).json({
            success:true,
            message:"Student Updated Successfully",
            data:data
        });
    }
    catch(error){
        res.status(500).json({
            success:false,
            message:error.message
        });
    }
});

// ==========================
// DELETE BY ID
// DELETE API
// ==========================
app.delete("/student/:id",async(req,res)=>{
    try{
        const data = await Student.findByIdAndDelete(
            req.params.id
        );
        if(!data){
            return res.status(404).json({
                success:false,
                message:"Student Not Found"
            });
        }
        res.status(200).json({
            success:true,
            message:"Student Deleted Successfully",
            data:data
        });
    }
    catch(error){
        res.status(500).json({
            success:false,
            message:error.message
        });
    }
});

// Server Start

app.listen(5000,()=>{
    console.log("Server Running On Port 5000");
});