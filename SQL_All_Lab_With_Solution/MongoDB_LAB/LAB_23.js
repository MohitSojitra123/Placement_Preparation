// Lab 23

//  Perform the following queries using Regex: 

// Part – A 
// Create collection named “Customer” and insert following 10 documents into it.

db.Customer.insertMany([
  { CID: 1, CNAME: "Rajesh", EMAIL: "rajesh@gmail.com", GENDER: "Male", CITY: "Surat", BALANCE: 5000 },
  { CID: 2, CNAME: "Meena", EMAIL: "meena@yahoo.com", GENDER: "Female", CITY: "Ahmedabad", BALANCE: 8000 },
  { CID: 3, CNAME: "Anil", EMAIL: "anil@outlook.com", GENDER: "Male", CITY: "Vadodara", BALANCE: 6000 },
  { CID: 4, CNAME: "Sneha", EMAIL: "sneha@hotmail.com", GENDER: "Female", CITY: "Rajkot", BALANCE: 50000 },
  { CID: 5, CNAME: "Nikhil", EMAIL: "nikhil@gmail.com", GENDER: "Male", CITY: "Surat", BALANCE: 4000 },
  { CID: 6, CNAME: "Rachna", EMAIL: "rachna@yahoo.com", GENDER: "Female", CITY: "Baroda", BALANCE: 9000 },
  { CID: 7, CNAME: "Gaurav", EMAIL: "gaurav@outlook.com", GENDER: "Male", CITY: "Jamnagar", BALANCE: 10000 },
  { CID: 8, CNAME: "Tanya", EMAIL: "tanya@hotmail.com", GENDER: "Female", CITY: "Mehsana", BALANCE: 5500 },
  { CID: 9, CNAME: "Pushti", EMAIL: "pushti@gmail.com", GENDER: "Female", CITY: "Rajkot", BALANCE: 50000 },
  { CID: 10, CNAME: "Avni", EMAIL: "avni@yahoo.com", GENDER: "Female", CITY: "Morbi", BALANCE: 10000 }
]);


// 1. Find customers whose CITY does not start with 'S' 
db.Customer.find({CITY:{$not:/^s/i}})


// 2. Find customers whose CITY contains the word 'bad' 
db.Customer.find({CITY:/bad/i})


// 3. Find customers whose CNAME has two consecutive vowels. 
db.Customer.find({CNAME:/[aeiou]{2}/})


// 4. Find customers whose CNAME has three or more letters. 
db.Customer.find({CNAME:/^.{3,}/})


// 5. Find customers whose EMAIL ends with 'gmail.com'. 
db.Customer.find({EMAIL:/gmail\.com$/i})


// 6. Find customers whose EMAIL contains 'outlook' 
db.Customer.find({EMAIL:/outlook/i})


// 7. Find customers whose name starts with any uppercase letter. 
db.Customer.find({ CNAME: /^[A-Z]/ });


// 8. Find customers not from Surat or Rajkot. 
db.Customer.find({CITY:{$nin:['Rajkot','Surat']}})


// 9. Find customers whose EMAIL starts with 't' and ends with '.com'. 
db.Customer.find({ EMAIL: /^t.*\.com$/i });


// 10.  Find customers whose CNAME does not contain 'a' or 'e' 
db.Customer.find({ CNAME: { $not: /[ae]/i } });


// 11.  Find customers whose EMAIL contains exactly one digit.
db.Customer.find({ EMAIL: /^[^0-9]*[0-9][^0-9]*$/ });


// Part – B 
// Create collection named “Company” and insert following 10 documents into it. 

db.Company.insertMany([
  { CID: 1, CNAME: "TechNova", EMAIL: "info@technova.com", INDUSTRY: "IT", CITY: "Bangalore", EMPLOYEES: 250 },
  { CID: 2, CNAME: "GreenWorld", EMAIL: "support@greenw.com", INDUSTRY: "Agriculture", CITY: "Ahmedabad", EMPLOYEES: 120 },
  { CID: 3, CNAME: "SkyHigh Ltd", EMAIL: "contact@skyhigh.in", INDUSTRY: "Aviation", CITY: "Mumbai", EMPLOYEES: 300 },
  { CID: 4, CNAME: "UrbanBuild", EMAIL: "info@urbanbuild.org", INDUSTRY: "Construction", CITY: "Surat", EMPLOYEES: 180 },
  { CID: 5, CNAME: "MediCore", EMAIL: "hello@medicore.net", INDUSTRY: "Healthcare", CITY: "Pune", EMPLOYEES: 90 },
  { CID: 6, CNAME: "FinEdge", EMAIL: "info@finedge.co", INDUSTRY: "Finance", CITY: "Kolkata", EMPLOYEES: 200 },
  { CID: 7, CNAME: "AutoSphere", EMAIL: "sales@autos.com", INDUSTRY: "Automotive", CITY: "Chennai", EMPLOYEES: 400 },
  { CID: 8, CNAME: "EduQuest", EMAIL: "info@eduquest.edu", INDUSTRY: "Education", CITY: "Rajkot", EMPLOYEES: 75 },
  { CID: 9, CNAME: "FoodiesHub", EMAIL: "contact@foodies.org", INDUSTRY: "Food", CITY: "Baroda", EMPLOYEES: 60 },
  { CID: 10, CNAME: "BioPure", EMAIL: "info@biopure.bio", INDUSTRY: "Pharma", CITY: "Hyderabad", EMPLOYEES: 150 }
]);


// 1. Find companies whose name starts with 'B' or 'F' 
db.Company.find({CNAME:/^[BF]/i})
db.Company.find({CNAME:{$regex:/^[BF]/i}})


// 2. Find companies located in cities ending with 'pur' 
db.Company.find({CITY:/pur/i})
db.Company.find({CITY:{$regex:/pur$/i}})

// 3. Find  companies  whose  name  contains  the  word  "Core" Find  companies  with  email addresses  starting  with 
// "info" 
db.Company.find({$or:[{CNAME:/Core/i},{EMAIL:/^info/i}]})

db.Company.find({
  $or: [
    { CNAME: { $regex: /Core/i } },
    { EMAIL: { $regex: /^info/i } }
  ]
})


// 4. Find companies whose INDUSTRY starts with a capital letter followed by 4 lowercase letters 
db.Company.find({ INDUSTRY: { $regex: /^[A-Z][a-z]{4}/ } })


// 5. Find companies whose CNAME ends with a capital letter 
db.Company.find({ CNAME: { $regex: /[A-Z]$/ } })


// 6. Find companies whose CITY starts with any letter from A to K 
db.Company.find({CITY:/^[a-k]/i})
db.Company.find({CITY:{$regex:/^[a-k]/i}})


// 7. Find companies whose INDUSTRY name has more than 8 letters 
db.Company.find({INDUSTRY:/^[a-z]{9,}$/i})
db.Company.find({ INDUSTRY: { $regex: /^.{9,}$/ } })


// 8. Find companies whose EMAIL has a number in it 
db.Company.find({ EMAIL: { $regex: /\d/ } })

// 9. Find companies whose name starts and ends with vowels 
db.Company.find({ CNAME: { $regex: /^[AEIOUaeiou].*[AEIOUaeiou]$/ } })


// 10.  Find companies with CITY names that contain the same letter twice in a row
db.Company.find({ CITY: { $regex: /(.)\1/ } })



// Part – C 
// 1. Find companies whose email starts with any two letters followed by digits 
// 2. Find companies whose EMAIL includes an underscore _ 
// 3. Find companies whose EMAIL domain (after @) starts with 'g' or 'h' 
// 4. Find companies whose CNAME contains a repeating pattern like "ana", "ele", etc. 
// 5. Find companies whose CNAME contains at least 3 vowels 
// 6. Find companies whose EMAIL domain ends with '.com' and starts with 'out' 
// 7. Find companies whose INDUSTRY does not contain any vowels 
// 8. Find companies whose CNAME contains two or more consecutive consonants 
// 9. Find companies whose CNAME has alternating vowels and consonants (at least 4 characters) 
// Find companies where CITY starts with two same letters (e.g., "Mehsana" doesn't match, but "AAhmedabad" would)