const mongoose=require('mongoose');
require('dotenv').config();

async function Connect_DataBase(){
    try{
        await mongoose.connect(`${process.env.MONGO_URL}/${process.env.DATABASE_NAME}`);

        console.log("MongoDB Connectedd : ");
    }catch(err){
        console.log("MongoDB  Connection Error : ");
    }
}

module.exports=Connect_DataBase;