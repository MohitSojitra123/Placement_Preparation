import React, { useEffect, useState } from "react";

function Users() {

  // =====================================================
  // API URL
  // =====================================================

  const API_URL = "https://localhost:7125/api/Users";


  // =====================================================
  // STATES
  // =====================================================

  const [users, setUsers] = useState([]);

  const [selectedUser, setSelectedUser] = useState(null);

  const [loading, setLoading] = useState(false);

  const [form, setForm] = useState({
    fullName: "",
    email: "",
    password: "",
    mobileNumber: "",
    profilePicturePath: ""
  });


  // =====================================================
  // FORM INPUT CHANGE
  // =====================================================

  const handleChange = (e) => {

    const { name, value } = e.target;

    setForm({
      ...form,
      [name]: value
    });

  };


  // =====================================================
  // GET ALL USERS
  // =====================================================

  const Fetch_All_Users = async () => {

    try {

      setLoading(true);

      const response = await fetch(API_URL);

      if (!response.ok) {
        throw new Error("Failed to fetch users");
      }

      const data = await response.json();

      setUsers(data);

    }
    catch (error) {

      console.error("GET ALL ERROR:", error);

      alert("Failed to load users");

    }
    finally {

      setLoading(false);

    }

  };


  // =====================================================
  // GET ONE USER
  // =====================================================

  const Fetch_One_User = async (id) => {

    try {

      const response = await fetch(
        `${API_URL}/${id}`
      );

      if (!response.ok) {
        throw new Error("User not found");
      }

      const data = await response.json();

      console.log("GET ONE:", data);

      setSelectedUser(data);

      // Fill form with API data
      setForm({
        fullName: data.fullName ?? "",
        email: data.email ?? "",
        password: "",
        mobileNumber: data.mobileNumber ?? "",
        profilePicturePath: data.profilePicturePath ?? ""
      });

    }
    catch (error) {

      console.error("GET ONE ERROR:", error);

      alert("User not found");

    }

  };


  // =====================================================
  // POST - ADD USER
  // =====================================================

  const Add_User = async () => {

    try {

      const userData = {
        fullName: form.fullName,
        email: form.email,
        password: form.password,
        mobileNumber: form.mobileNumber,
        profilePicturePath: form.profilePicturePath
      };


      const response = await fetch(
        API_URL,
        {
          method: "POST",

          headers: {
            "Content-Type": "application/json"
          },

          body: JSON.stringify(userData)
        }
      );


      if (!response.ok) {

        const errorText = await response.text();

        throw new Error(errorText);

      }


      const data = await response.json();

      console.log("POST RESPONSE:", data);


      alert("User added successfully");


      // Refresh users
      await Fetch_All_Users();


      // Clear form
      Clear_Form();

    }
    catch (error) {

      console.error("POST ERROR:", error);

      alert("Failed to add user");

    }

  };


  // =====================================================
  // UPDATE USER
  // =====================================================

  const Update_User = async (id) => {

    try {

      const userData = {
        fullName: form.fullName,
        email: form.email,
        password: form.password,
        mobileNumber: form.mobileNumber,
        profilePicturePath: form.profilePicturePath
      };


      const response = await fetch(
        `${API_URL}/${id}`,
        {
          method: "PUT",

          headers: {
            "Content-Type": "application/json"
          },

          body: JSON.stringify(userData)
        }
      );


      if (!response.ok) {

        const errorText = await response.text();

        throw new Error(errorText);

      }


      console.log("User updated successfully");


      alert("User updated successfully");


      // Refresh users
      await Fetch_All_Users();


      // Clear selected user
      setSelectedUser(null);

      Clear_Form();

    }
    catch (error) {

      console.error("UPDATE ERROR:", error);

      alert("Failed to update user");

    }

  };


  // =====================================================
  // DELETE ONE USER
  // =====================================================

  const Delete_User = async (id) => {

    try {

      // Confirmation
      const confirmDelete = window.confirm(
        "Are you sure you want to delete this user?"
      );

      if (!confirmDelete) {
        return;
      }


      const response = await fetch(
        `${API_URL}/${id}`,
        {
          method: "DELETE"
        }
      );


      if (!response.ok) {

        const errorText = await response.text();

        throw new Error(errorText);

      }


      alert("User deleted successfully");


      // Refresh users
      await Fetch_All_Users();

    }
    catch (error) {

      console.error("DELETE ERROR:", error);

      alert("Failed to delete user");

    }

  };


  // =====================================================
  // DELETE ALL USERS
  // =====================================================

  const Delete_All_Users = async () => {

    try {

      const confirmDelete = window.confirm(
        "Are you sure you want to delete ALL users?"
      );

      if (!confirmDelete) {
        return;
      }


      const response = await fetch(
        API_URL,
        {
          method: "DELETE"
        }
      );


      if (!response.ok) {

        const errorText = await response.text();

        throw new Error(errorText);

      }


      alert("All users deleted successfully");


      // Clear users from UI
      setUsers([]);

    }
    catch (error) {

      console.error("DELETE ALL ERROR:", error);

      alert("Failed to delete all users");

    }

  };


  // =====================================================
  // CLEAR FORM
  // =====================================================

  const Clear_Form = () => {

    setForm({
      fullName: "",
      email: "",
      password: "",
      mobileNumber: "",
      profilePicturePath: ""
    });

  };


  // =====================================================
  // USE EFFECT
  // =====================================================

  useEffect(() => {

    Fetch_All_Users();

  }, []);


  // =====================================================
  // UI
  // =====================================================

  return (

    <div
      style={{
        width: "800px",
        margin: "40px auto",
        fontFamily: "Arial"
      }}
    >

      <h1>User Management</h1>


      {/* =================================================
          USER FORM
      ================================================= */}

      <div
        style={{
          border: "1px solid #ddd",
          padding: "20px",
          marginBottom: "30px"
        }}
      >

        <h2>
          {selectedUser
            ? "Update User"
            : "Add User"
          }
        </h2>


        {/* Full Name */}

        <input
          type="text"
          name="fullName"
          placeholder="Full Name"
          value={form.fullName}
          onChange={handleChange}
          style={{
            display: "block",
            width: "100%",
            padding: "10px",
            marginBottom: "10px"
          }}
        />


        {/* Email */}

        <input
          type="email"
          name="email"
          placeholder="Email"
          value={form.email}
          onChange={handleChange}
          style={{
            display: "block",
            width: "100%",
            padding: "10px",
            marginBottom: "10px"
          }}
        />


        {/* Password */}

        <input
          type="password"
          name="password"
          placeholder="Password"
          value={form.password}
          onChange={handleChange}
          style={{
            display: "block",
            width: "100%",
            padding: "10px",
            marginBottom: "10px"
          }}
        />


        {/* Mobile */}

        <input
          type="text"
          name="mobileNumber"
          placeholder="Mobile Number"
          value={form.mobileNumber}
          onChange={handleChange}
          style={{
            display: "block",
            width: "100%",
            padding: "10px",
            marginBottom: "10px"
          }}
        />


        {/* Profile Picture */}

        <input
          type="text"
          name="profilePicturePath"
          placeholder="Profile Picture Path"
          value={form.profilePicturePath}
          onChange={handleChange}
          style={{
            display: "block",
            width: "100%",
            padding: "10px",
            marginBottom: "10px"
          }}
        />


        {/* ADD */}

        {!selectedUser && (

          <button
            onClick={Add_User}
            style={{
              padding: "10px 20px",
              marginRight: "10px"
            }}
          >
            Add User
          </button>

        )}


        {/* UPDATE */}

        {selectedUser && (

          <button
            onClick={() =>
              Update_User(selectedUser.userId)
            }
            style={{
              padding: "10px 20px",
              marginRight: "10px"
            }}
          >
            Update User
          </button>

        )}


        {/* CLEAR */}

        <button
          onClick={() => {

            setSelectedUser(null);

            Clear_Form();

          }}
          style={{
            padding: "10px 20px"
          }}
        >
          Clear
        </button>

      </div>


      {/* =================================================
          DELETE ALL
      ================================================= */}

      <button
        onClick={Delete_All_Users}
        style={{
          padding: "10px 20px",
          marginBottom: "20px"
        }}
      >
        Delete All Users
      </button>


      {/* =================================================
          LOADING
      ================================================= */}

      {loading && (
        <p>Loading users...</p>
      )}


      {/* =================================================
          USER LIST
      ================================================= */}

      <h2>Users List</h2>


      {users.length === 0 && !loading && (

        <p>
          No users found.
        </p>

      )}


      {users.map((user) => (

        <div
          key={user.userId}
          style={{
            border: "1px solid #ddd",
            padding: "15px",
            marginBottom: "10px"
          }}
        >

          <h3>
            {user.fullName}
          </h3>


          <p>
            ID: {user.userId}
          </p>


          <p>
            Email: {user.email}
          </p>


          <p>
            Mobile: {user.mobileNumber}
          </p>


          {/* GET ONE */}

          <button
            onClick={() =>
              Fetch_One_User(user.userId)
            }
            style={{
              marginRight: "10px",
              padding: "8px 15px"
            }}
          >
            View / Edit
          </button>


          {/* DELETE ONE */}

          <button
            onClick={() =>
              Delete_User(user.userId)
            }
            style={{
              padding: "8px 15px"
            }}
          >
            Delete
          </button>

        </div>

      ))}

    </div>

  );

}

export default Users;