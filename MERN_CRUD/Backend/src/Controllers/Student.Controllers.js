const Student=require("../model/Student.model.js");


const GetAllStudent=async(req,res)=>{
   
    try{

        const AllStudent= await Student.find();
        
        if(AllStudent){
            res.status(200).json({
                Success:true,
                Message:"Data Fetch : ",
                data:AllStudent
            })
        }else{
            res.status(400).json({
                Success:false,
                Message:"Data Not Fetch : "
            })
        }
    }catch (error) {

    return res.status(500).json({
        Success: false,
        Message: "Internal Server Error",
        error: error.message
    });
}
}

const GetOneStudent=async(req,res)=>{
       try{

          const getid=req.params.id; 

          if(getid){

               const GetStudent=await Student.findById(getid);
               
               if(GetStudent){
                      return res.status(200).json({
                          Success:true,
                          Message:"Get One Student : ",
                          data:GetStudent
                      }) 
               }else{
                     return res.status(400).json({
                   Success:false,
                   Message:"Id Not Found : "
               })
               }

          }else{
               return res.status(400).json({
                   Success:false,
                   Message:"Id Not Found : "
               })
          }

       }catch (error) {

    return res.status(500).json({
        Success: false,
        Message: "Internal Server Error",
        error: error.message
    });
}
}

const AddStudent=async(req,res)=>{
      

    try{

        const NewStudent=req.body;
        
        const NewAddStudent =await Student.create(NewStudent);
        
        
        if(NewAddStudent){
            res.status(200).json({
                Success:true,
                Message:"New Student Added  : ",
                data:NewAddStudent
            })
        }
        
        res.status(400).json({
            Success:false,
            Message:"New Student Not Added : "
        })
    }catch (error) {

    return res.status(500).json({
        Success: false,
        Message: "Internal Server Error",
        error: error.message
    });        
    }

}

const DeleteStudent=async(req,res)=>{

      try{

           const deleteid=req.params.id;

           console.log(deleteid);

           if(deleteid){
            
              const  deleteStudet=await  Student.findByIdAndDelete(deleteid);

               if(deleteStudet){
                   return res.status(200).json({
                       Success:true, 
                       Message:"Student Delete Success Fully : ",
                       data:deleteStudet 
                    })
                } else{
                        return res.status(400).json({
                       Success:false, 
                       Message:"Student Id Not Valid : ",
                       Id:deleteid
                    })
                }


           }else{
              return res.status(400).json({
                Success:false, 
                Message:"Id Not Found : " 
              })
           }


      }catch (error) {
    return res.status(500).json({
        Success: false,
        Message: "Internal Server Error",
        error: error.message
    });

}
}

const DeleteAllStudent=async(req,res)=>{
        try {

        const DeleteStudent = await Student.deleteMany({});

        return res.status(200).json({
            Success: true,
            Message: "All Students Deleted Successfully",
            DeletedCount: DeleteStudent
        });

    } catch (error) {
        return res.status(500).json({
            Success: false,
            Message: "Internal Server Error",
            error: error.message
        });

    }
}

const UpdateStudent=async(req,res)=>{
       try{

          const updateid=req.params.id;
          const updatestudent=req.body;

          const newstudent=await Student.findByIdAndUpdate(updateid,updatestudent,{new:true});

           if(newstudent){
                return res.status(200).json({
                    Success:true,
                    Message:"Student Update SuccessFully : ",
                    data:newstudent
                })
           }else{
                  return res.status(200).json({
                    Success:false,
                    Message:"Student Not Update  : "
                })
           } 

       }catch (error) {
    return res.status(500).json({
        Success: false,
        Message: "Internal Server Error",
        error: error.message
    });
    }
}



module.exports={GetAllStudent,AddStudent,DeleteStudent,GetOneStudent,UpdateStudent,DeleteAllStudent}