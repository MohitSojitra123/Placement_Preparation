/*
===========================================================
        JAVASCRIPT SPREAD OPERATOR (...) COMPLETE GUIDE
===========================================================

This file covers:

1. Normal Array
2. Copy Array using Spread
3. Add items to Array
4. Update Array item
5. Delete Array item
6. Object Spread
7. Update Object
8. Add Object properties
9. Array of Objects
10. Add Object to Array
11. Update Object inside Array
12. Delete Object from Array
13. Update Multiple Properties
14. Nested Object Update
15. React useState examples

IMPORTANT:

Spread operator:

    ...
    
is used to expand/copy values.

For Array:

    [...array]

For Object:

    {...object}

===========================================================
*/


/*
===========================================================
1. NORMAL ARRAY
===========================================================
*/

const numbers = [10, 20, 30, 40];

console.log("Original Array:");
console.log(numbers);


/*
===========================================================
2. COPY NORMAL ARRAY USING SPREAD
===========================================================

Here:

    ...numbers

takes all values from numbers and puts them into
a NEW array.

It does NOT change the original array.
*/

const copiedNumbers = [...numbers];

console.log("Copied Array:");
console.log(copiedNumbers);


/*
===========================================================
3. ADD ITEM AT THE END OF ARRAY
===========================================================
*/

const numbersWithNewItem = [
    ...numbers,
    50
];

console.log("Add 50:");
console.log(numbersWithNewItem);


/*
Result:

[
    10,
    20,
    30,
    40,
    50
]
*/


/*
===========================================================
4. ADD ITEM AT THE BEGINNING
===========================================================
*/

const numbersWithFirstItem = [
    5,
    ...numbers
];

console.log("Add 5 at beginning:");
console.log(numbersWithFirstItem);


/*
Result:

[
    5,
    10,
    20,
    30,
    40
]
*/


/*
===========================================================
5. UPDATE NORMAL ARRAY ITEM
===========================================================

Suppose we want:

30 -> 300

For updating array values, map() is commonly used.
*/

const updatedNumbers = numbers.map((number) => {

    if (number === 30) {
        return 300;
    }

    return number;
});

console.log("Updated Array:");
console.log(updatedNumbers);


/*
Short version:

const updatedNumbers = numbers.map(number =>
    number === 30 ? 300 : number
);
*/


/*
===========================================================
6. DELETE ITEM FROM NORMAL ARRAY
===========================================================

Suppose we want to remove 30.

filter() is commonly used.
*/

const numbersAfterDelete = numbers.filter(
    number => number !== 30
);

console.log("Array after deleting 30:");
console.log(numbersAfterDelete);


/*
===========================================================
7. OBJECT
===========================================================
*/

const user = {
    id: 1,
    name: "Mohit",
    age: 25,
    city: "Rajkot"
};

console.log("Original User:");
console.log(user);


/*
===========================================================
8. COPY OBJECT USING SPREAD
===========================================================
*/

const copiedUser = {
    ...user
};

console.log("Copied User:");
console.log(copiedUser);


/*
===========================================================
9. UPDATE OBJECT PROPERTY
===========================================================

Suppose:

age = 25

We want:

age = 26

Important:

The property after ...user overrides the old property.
*/

const updatedUser = {
    ...user,
    age: 26
};

console.log("Updated User:");
console.log(updatedUser);


/*
===========================================================
10. UPDATE MULTIPLE OBJECT PROPERTIES
===========================================================
*/

const updatedUserDetails = {
    ...user,

    name: "Mohit Patel",
    age: 26,
    city: "Ahmedabad"
};

console.log("Multiple Properties Updated:");
console.log(updatedUserDetails);


/*
===========================================================
11. ADD NEW PROPERTY TO OBJECT
===========================================================
*/

const userWithEmail = {
    ...user,

    email: "mohit@example.com"
};

console.log("User with Email:");
console.log(userWithEmail);


/*
===========================================================
12. ARRAY OF OBJECTS
===========================================================
*/

const users = [

    {
        id: 1,
        name: "Mohit",
        age: 25,
        active: true
    },

    {
        id: 2,
        name: "Rahul",
        age: 30,
        active: false
    },

    {
        id: 3,
        name: "Amit",
        age: 28,
        active: true
    }

];

console.log("Original Users:");
console.log(users);


/*
===========================================================
13. COPY ARRAY OF OBJECTS
===========================================================

Here:

    [...users]

copies the ARRAY.

But remember:

This is a SHALLOW COPY.

The objects inside are still objects.
*/

const copiedUsers = [
    ...users
];

console.log("Copied Users:");
console.log(copiedUsers);


/*
===========================================================
14. ADD NEW OBJECT TO ARRAY
===========================================================
*/

const usersAfterAdd = [

    ...users,

    {
        id: 4,
        name: "Suresh",
        age: 32,
        active: true
    }

];

console.log("After Adding New User:");
console.log(usersAfterAdd);


/*
===========================================================
15. ADD OBJECT AT BEGINNING
===========================================================
*/

const usersWithFirstUser = [

    {
        id: 0,
        name: "First User",
        age: 20,
        active: true
    },

    ...users

];

console.log("New User at Beginning:");
console.log(usersWithFirstUser);


/*
===========================================================
16. UPDATE OBJECT INSIDE ARRAY
===========================================================

Suppose we want to update:

id = 2

Rahul's age:

30 -> 31

We use:

    map()

and inside map():

    ...user

The spread copies the existing object.

Then:

    age: 31

overwrites the old age.
*/

const updatedUsers = users.map((user) => {

    if (user.id === 2) {

        return {
            ...user,
            age: 31
        };

    }

    return user;

});

console.log("Updated Rahul:");
console.log(updatedUsers);


/*
===========================================================
17. SHORT VERSION OF UPDATE
===========================================================
*/

const updatedUsersShort = users.map(user =>

    user.id === 2

        ? {
            ...user,
            age: 31
        }

        : user

);

console.log("Short Update:");
console.log(updatedUsersShort);


/*
===========================================================
18. UPDATE MULTIPLE PROPERTIES INSIDE ARRAY
===========================================================

Update Rahul:

name  -> Rahul Patel
age   -> 31
active -> true
*/

const updatedRahul = users.map(user => {

    if (user.id === 2) {

        return {

            ...user,

            name: "Rahul Patel",
            age: 31,
            active: true

        };

    }

    return user;

});

console.log("Multiple Properties Updated:");
console.log(updatedRahul);


/*
===========================================================
19. DELETE OBJECT FROM ARRAY
===========================================================

Remove user where:

id === 2

filter() creates a new array.
*/

const usersAfterDelete = users.filter(
    user => user.id !== 2
);

console.log("Users after deleting ID 2:");
console.log(usersAfterDelete);


/*
===========================================================
20. FIND SPECIFIC OBJECT
===========================================================

find() returns ONE object.
*/

const foundUser = users.find(
    user => user.id === 2
);

console.log("Found User:");
console.log(foundUser);


/*
===========================================================
21. UPDATE USING findIndex()
===========================================================

Another method is findIndex().

But remember:

This example modifies a copied array.

We first copy the array:

    [...users]

Then find the index.
*/

const usersCopy = [...users];

const index = usersCopy.findIndex(
    user => user.id === 2
);

if (index !== -1) {

    usersCopy[index] = {
        ...usersCopy[index],
        age: 35
    };

}

console.log("Updated using findIndex:");
console.log(usersCopy);


/*
===========================================================
22. NESTED OBJECT
===========================================================
*/

const userWithAddress = {

    id: 1,

    name: "Mohit",

    address: {

        city: "Rajkot",
        state: "Gujarat",
        country: "India"

    }

};

console.log("Nested User:");
console.log(userWithAddress);


/*
===========================================================
23. UPDATE NESTED OBJECT
===========================================================

Suppose:

city = Rajkot

We want:

city = Ahmedabad

We need to spread BOTH objects.

Why?

Because address is also an object.
*/

const updatedAddressUser = {

    ...userWithAddress,

    address: {

        ...userWithAddress.address,

        city: "Ahmedabad"

    }

};

console.log("Updated Nested Object:");
console.log(updatedAddressUser);


/*
===========================================================
24. DEEPER NESTED OBJECT
===========================================================
*/

const employee = {

    id: 1,

    name: "Mohit",

    company: {

        name: "ABC Company",

        address: {

            city: "Rajkot",
            state: "Gujarat"

        }

    }

};


/*
Update:

Rajkot -> Ahmedabad

Because there are multiple levels,
we spread each level.
*/

const updatedEmployee = {

    ...employee,

    company: {

        ...employee.company,

        address: {

            ...employee.company.address,

            city: "Ahmedabad"

        }

    }

};

console.log("Updated Employee:");
console.log(updatedEmployee);


/*
===========================================================
25. REACT useState - NORMAL ARRAY
===========================================================

Example:

const [numbers, setNumbers] = useState([
    10,
    20,
    30
]);

Add item:

setNumbers(prevNumbers => [
    ...prevNumbers,
    40
]);

===========================================================
*/


/*
===========================================================
26. REACT useState - ARRAY OF OBJECTS
===========================================================

Example:

const [users, setUsers] = useState([
    {
        id: 1,
        name: "Mohit"
    },
    {
        id: 2,
        name: "Rahul"
    }
]);

===========================================================
*/


/*
ADD USER
-----------------------------------------------------------

setUsers(prevUsers => [

    ...prevUsers,

    {
        id: 3,
        name: "Amit"
    }

]);

===========================================================
*/


/*
===========================================================
27. REACT UPDATE OBJECT INSIDE ARRAY
===========================================================

This is one of the MOST IMPORTANT React patterns.

Suppose we want to update user ID 2.
*/

function updateUserExample(setUsers) {

    setUsers(prevUsers =>

        prevUsers.map(user =>

            user.id === 2

                ? {
                    ...user,
                    name: "Rahul Patel"
                }

                : user

        )

    );

}


/*
What happens?

Original:

[
    {
        id: 1,
        name: "Mohit"
    },
    {
        id: 2,
        name: "Rahul"
    }
]


After update:

[
    {
        id: 1,
        name: "Mohit"
    },
    {
        id: 2,
        name: "Rahul Patel"
    }
]

===========================================================
*/


/*
===========================================================
28. REACT DELETE OBJECT
===========================================================
*/

function deleteUserExample(setUsers, id) {

    setUsers(prevUsers =>

        prevUsers.filter(
            user => user.id !== id
        )

    );

}


/*
===========================================================
29. REACT ADD OBJECT
===========================================================
*/

function addUserExample(setUsers, newUser) {

    setUsers(prevUsers => [

        ...prevUsers,

        newUser

    ]);

}


/*
===========================================================
30. REACT UPDATE MULTIPLE PROPERTIES
===========================================================
*/

function updateMultipleProperties(setUsers) {

    setUsers(prevUsers =>

        prevUsers.map(user =>

            user.id === 2

                ? {

                    ...user,

                    name: "Rahul Patel",
                    age: 31,
                    active: true

                }

                : user

        )

    );

}


/*
===========================================================
31. REACT NESTED OBJECT UPDATE
===========================================================
*/

function updateUserCity(setUsers) {

    setUsers(prevUsers =>

        prevUsers.map(user =>

            user.id === 1

                ? {

                    ...user,

                    address: {

                        ...user.address,

                        city: "Ahmedabad"

                    }

                }

                : user

        )

    );

}


/*
===========================================================
32. IMPORTANT DIFFERENCE
===========================================================

ARRAY SPREAD:

    [...users]

means:

    Copy array elements.

OBJECT SPREAD:

    {...user}

means:

    Copy object properties.

===========================================================

For example:

const users = [
    { id: 1, name: "Mohit" },
    { id: 2, name: "Rahul" }
];

Array:

const newUsers = [
    ...users
];


Object:

const newUser = {
    ...users[0]
};

===========================================================
*/


/*
===========================================================
33. MOST IMPORTANT PATTERNS
===========================================================

NORMAL ARRAY
-----------------------------------------------------------

Copy:

const newArray = [...oldArray];


Add:

const newArray = [
    ...oldArray,
    newItem
];


Update:

const newArray = oldArray.map(item =>
    item === oldValue
        ? newValue
        : item
);


Delete:

const newArray = oldArray.filter(
    item => item !== value
);


===========================================================

OBJECT
-----------------------------------------------------------

Copy:

const newObject = {
    ...oldObject
};


Update:

const newObject = {
    ...oldObject,
    name: "New Name"
};


Add Property:

const newObject = {
    ...oldObject,
    email: "test@example.com"
};


===========================================================

ARRAY OF OBJECTS
-----------------------------------------------------------

Add:

const newUsers = [
    ...users,
    newUser
];


Update:

const newUsers = users.map(user =>
    user.id === targetId
        ? {
            ...user,
            name: "New Name"
        }
        : user
);


Delete:

const newUsers = users.filter(
    user => user.id !== targetId
);


===========================================================
*/


/*
===========================================================
34. FINAL REAL-WORLD EXAMPLE
===========================================================

Imagine API returns:

users = [
    {
        userId: 1,
        fullName: "Mohit Patel",
        email: "mohit@gmail.com",
        isActive: true
    },
    {
        userId: 2,
        fullName: "Rahul Patel",
        email: "rahul@gmail.com",
        isActive: false
    }
];


We want to update user ID 2.

===========================================================
*/

const apiUsers = [

    {
        userId: 1,
        fullName: "Mohit Patel",
        email: "mohit@gmail.com",
        isActive: true
    },

    {
        userId: 2,
        fullName: "Rahul Patel",
        email: "rahul@gmail.com",
        isActive: false
    }

];

const finalUsers = apiUsers.map(user =>

    user.userId === 2

        ? {

            ...user,

            fullName: "Rahul Kumar",
            email: "rahulkumar@gmail.com",
            isActive: true

        }

        : user

);

console.log("Final API Users:");
console.log(finalUsers);


/*
===========================================================
FINAL RULE TO REMEMBER
===========================================================

For normal array:

    [...array]


For object:

    {...object}


For array of objects UPDATE:

    array.map(item =>
        item.id === id
            ? {
                ...item,
                property: newValue
            }
            : item
    )


For array of objects ADD:

    [
        ...array,
        newObject
    ]


For array of objects DELETE:

    array.filter(item => item.id !== id)


For nested object UPDATE:

    {
        ...object,
        nestedObject: {
            ...object.nestedObject,
            property: newValue
        }
    }

===========================================================
*/
