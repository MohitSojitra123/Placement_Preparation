// Perform the following queries using Regex: 

// Part – A 
// Create collection named “Employee” and insert following 10 documents into it.

db.employee.insertMany([
  { EID: 1, ENAME: "Nick",    GENDER: "Male",   JOININGDATE: new Date("2013-01-01"), SALARY: 4000, CITY: "London" },
  { EID: 2, ENAME: "Julian",  GENDER: "Female", JOININGDATE: new Date("2014-10-01"), SALARY: 3000, CITY: "New York" },
  { EID: 3, ENAME: "Roy",     GENDER: "Male",   JOININGDATE: new Date("2016-06-01"), SALARY: 3500, CITY: "London" },
  { EID: 4, ENAME: "Tom",     GENDER: "Male",   JOININGDATE: null,                   SALARY: 4500, CITY: "London" },
  { EID: 5, ENAME: "Jerry",   GENDER: "Male",   JOININGDATE: new Date("2013-02-01"), SALARY: 2800, CITY: "Sydney" },
  { EID: 6, ENAME: "Philip",  GENDER: "Male",   JOININGDATE: new Date("2015-01-01"), SALARY: 7000, CITY: "New York" },
  { EID: 7, ENAME: "Sara",    GENDER: "Female", JOININGDATE: new Date("2017-08-01"), SALARY: 4800, CITY: "Sydney" },
  { EID: 8, ENAME: "Emily",   GENDER: "Female", JOININGDATE: new Date("2015-01-01"), SALARY: 5500, CITY: "New York" },
  { EID: 9, ENAME: "Michael", GENDER: "Male",   JOININGDATE: null,                   SALARY: 6500, CITY: "London" },
  { EID: 10, ENAME: "John",   GENDER: "Male",   JOININGDATE: new Date("2015-01-01"), SALARY: 8800, CITY: "London" }
])


// 1. Find employees whose name start with E. 
db.employee.find({ENAME:/^e/i})


// 2. Find employees whose name ends with n. 
db.employee.find({ENAME:/n$/i})


// 3. Find employees whose name starts with S or M in your collection. 
db.employee.find({ENAME:/^[SM]/i})


// 4. Find employees where city starts with A to M in your collection. 
db.employee.find({CITY:/^[a-m]/i})


// 5. Find employees where city name ends in ‘ney’. 
db.employee.find({CITY:/ney$/})


// 6. Display employee info whose name contains n. (Both uppercase(N) and lowercase(n)) 
db.employee.find({ENAME:/n/i})


// 7. Display employee info whose name starts with E and having 5 characters. 
db.employee.find({ENAME:/^e.{4}/i})
db.employee.find({ENAME:/^e..../i})


// 8. Display employee whose name start with S and ends in a. 
db.employee.find({ENAME:/^s.*a$/i})


// 9. Display EID, ENAME, CITY and SALARY whose name starts with ‘Phi’. 
db.employee.find(
  {ENAME:/Phi/i},
  {EID:1,ENAME:1,CITY:1,SALARY:1,_id:0}
)

// 10.  Display ENAME, JOININGDATE and CITY whose city contains ‘dne’ as three letters in city name. 
db.employee.find(
  {CITY:/dne/i},
  {ENAME:1,JOININGDATE:1,CITY:1,_id:0}
)

// 11.  Display ENAME, JOININGDATE and CITY who does not belongs to city London or Sydney.  
db.employee.find(
  {CITY:{$nin:['Sydney','London']}},
  {ENAME:1,JOININGDATE:1,CITY:1,_id:0}
)

// 12.  Find employees whose names start with 'J'. 
db.employee.find({ENAME:/^e/i})


// 13.  Find employees whose names end with 'y'. 
db.employee.find({ENAME:/y$/i})


// 14.  Find employees whose names contain the letter 'a'. 
db.employee.find({ENAME:/a/i})


// 15.  Find employees whose names contain either 'a' or 'e'. 
db.employee.find({ENAME:/[ai]/i})


// 16.  Find employees whose names start with 'J' and end with 'n'. 
db.employee.find({ENAME:/^j.*n$/i})


// 17.  Find employees whose CITY starts with 'New'. 
db.employee.find({CITY:/^new/i})


// 18.  Find employees whose CITY does not start with 'L' 
db.employee.find({CITY:/^[^l]/i})

db.employee.find({CITY:{$not:/^l/i}})


// 19.  Find employees whose CITY contains the word 'York'. 
db.employee.find({CITY:/York/i})


// 20.  Find employees whose names have two consecutive vowels (a, e, i, o, u). 
db.employee.find({ENAME:/[aeiou]{2}/i})
    

// 21.  Find employees whose names have three or more letters. 
db.employee.find({ENAME:/^.{3,}$/})


// 22.  Find employees whose names have exactly 4 letters. 
db.employee.find({ENAME:/^....$/})
db.employee.find({ENAME:/^.{4}$/})


// 23.  Find employees whose names start with either 'S' or 'M'. 
db.employee.find({ENAME:/^[sm]/i})


// 24.  Find employees whose names contain 'il' anywhere. 
db.employee.find({ENAME:/il/i})


// 25.  Find employees whose names do not contain 'a'. 
db.employee.find({ENAME:{$not:/a/}})


// 26.  Find employees whose names contain any digit. 
db.employee.find({ENAME:/\d/})


// 27.  Find employees whose names contain exactly one vowel. 
db.employee.find({ ENAME: /^[^aeiou]*[aeiou][^aeiou]*$/i })


// 28.  Find employees whose names start with any uppercase letter followed by any lowercase letter.
db.employee.find({ENAME:/^[A-Z][a-z]+$/})


// Part – B 
// Create collection named “Student” and insert following 10 documents into it.

db.student.insertMany([
  { ROLLNO: 101, SNAME: "Vina",   DEPARTMENT: "CE",         FEES: 15000, SEM: 3, GENDER: "Female", CITY: "Rajkot" },
  { ROLLNO: 102, SNAME: "Krisha", DEPARTMENT: "EC",         FEES: 8000,  SEM: 5, GENDER: "Female", CITY: "Ahmedabad" },
  { ROLLNO: 103, SNAME: "Priti",  DEPARTMENT: "Civil",      FEES: 12000, SEM: 7, GENDER: "Female", CITY: "Baroda" },
  { ROLLNO: 104, SNAME: "Mitul",  DEPARTMENT: "CE",         FEES: 15000, SEM: 3, GENDER: "Male",   CITY: "Rajkot" },
  { ROLLNO: 105, SNAME: "Keshav", DEPARTMENT: "CE",         FEES: 15000, SEM: 3, GENDER: "Male",   CITY: "Jamnagar" },
  { ROLLNO: 106, SNAME: "Zarna",  DEPARTMENT: "Civil",      FEES: 12000, SEM: 5, GENDER: "Female", CITY: "Ahmedabad" },
  { ROLLNO: 107, SNAME: "Nima",   DEPARTMENT: "EE",         FEES: 9000,  SEM: 5, GENDER: "Female", CITY: "Rajkot" },
  { ROLLNO: 108, SNAME: "Dhruv",  DEPARTMENT: "Mechanical", FEES: 10000, SEM: 5, GENDER: "Male",   CITY: "Rajkot" },
  { ROLLNO: 109, SNAME: "Krish",  DEPARTMENT: "Mechanical", FEES: 10000, SEM: 7, GENDER: "Male",   CITY: "Baroda" },
  { ROLLNO: 110, SNAME: "Zeel",   DEPARTMENT: "EE",         FEES: 9000,  SEM: 3, GENDER: "Female", CITY: "Jamnagar" }
])


// 1. Display documents where sname start with K. 
db.student.find({SNAME:/^k/i})


// 2. Display documents where sname starts with Z or D. 
db.student.find({SNAME:/^[sz]/i})


// 3. Display documents where city starts with A to R. 
db.student.find({CITY:/^[a-r]/i})


// 4. Display students’ info whose name start with P and ends with i. 
db.student.find({SNAME:/^P.*I$/i})


// 5. Display students’ info whose department name starts with ‘C’. 
db.student.find({DEPARTMENT:/^c/i})


// 6. Display name, sem, fees, and department whose city contains ‘med’ as three letters somewhere in city 
// name. 
db.student.find(
  { CITY: /med/i },
  { SNAME: 1, SEM: 1, FEES: 1, DEPARTMENT: 1, _id: 0 }
)


// 7. Display name, sem, fees, and department who does not belongs to city Rajkot or Baroda.  
db.student.find(
  {CITY:{$nin:['Rajkot','Baroda']}},
  {SNAME:1,SEM:1,FEES:1,DEPARTMENT:1,_id:0} 
)

// 8. Find students whose names start with 'K' and are followed by any character. 
db.student.find({SNAME:/^K/i})


// 9. Find students whose names end with 'a'. 
db.student.find({SNAME:/^.*a$/i})
db.student.find({SNAME:/a$/})


// 10.  Find students whose names contain 'ri'. (case-insensitive)
db.student.find({SNAME:/ri/i})


// Part – C 

// 1. Find students whose names start with a vowel (A, E, I, O, U). 


// 2. Find students whose CITY ends with 'pur' or 'bad'. 


// 3. Find students whose FEES starts with '1'. 


// 4. Find students whose SNAME starts with 'K' or 'V'. 


// 5. Find students whose CITY contains exactly five characters. 


// 6. Find students whose names do not contain the letter 'e'. 


// 7. Find students whose CITY starts with 'Ra' and ends with 'ot'. 


// 8. Find students whose names contain exactly one vowel. 


// 9. Find students whose names start and end with the same letter. 

// 10.  Find students whose DEPARTMENT starts with either 'C' or 'E'. 

// 11.  Find students whose SNAME has exactly 5 characters. 

// 12.  Find students whose GENDER is Female and CITY starts with 'A'. 