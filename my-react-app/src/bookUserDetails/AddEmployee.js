import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';

const AddEmployee = () => {
 
 const navigate=useNavigate()
const [books, setBooks] = useState([]);

  //post
const [newBook, setNewBook] = useState({
    firstName: '',
    lastName: '',
    gender: '',
    libraryManagementId: '',
    email: '',
    contactNumber: '',
    availability: ''
});

useEffect(() => {
}, [books]);

  //post
const handleAddBook = async () => {
  
  try {
    const response = await axios.post("http://localhost:9090/library/poste1", newBook);
    setBooks([...books, response.data.result.book]);
    // setNewBook({
    //   indexNumber: '',
    //   name: '',
    //   title: ''
    // });
  } catch (error) {
    console.error('Error adding book:', error);
  }
  setNewBook({
    firstName: '',
    lastName: '',
    gender: '',
    libraryManagementId: '',
    email: '',
    contactNumber: '',
    availability: ''
    });

};

//post
const handleChange = (event) => {
  setNewBook({
    ...newBook,
    [event.target.name]: event.target.value
  });
  event.preventDefault();
 
  // setTimeout(() => {
  //   window.location.reload();
  // }, 5000);
};

const backHome =  () => {
  navigate('/employeeHome');
}

return (
  <div className='container'>
      <div className='row'>
      {/* <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow"> */}
        
  //Add Box
    <div className="mt-4">
    <h1 style={{ color: 'red' }}>Add New Book & User Details</h1>
      <input
        type="text"
        name="firstName"
        value={newBook.firstName}
        onChange={handleChange}
        placeholder="first Name"
      />
      <br/>
      <br/>
      <input
        type="text"
        name="lastName"
        value={newBook.lastName}
        onChange={handleChange}
        placeholder="Last Name"
      />

      <br/>
      <br/>
      <input
        type="text"
        name="gender"
        value={newBook.gender}
        onChange={handleChange}
        placeholder="Gender"
      />

      <br/>
      <br/>
      <input
        type="text"
        name="libraryManagementId"
        value={newBook.libraryManagementId}
        onChange={handleChange}
        placeholder="Ilibrary Management Id"
      />
      <br/>
      <br/>
      <input
        type="text"
        name="email"
        value={newBook.email}
        onChange={handleChange}
        placeholder="Email"
      />

      <br/>
      <br/>
      <input
        type="text"
        name="contactNumber"
        value={newBook.contactNumber}
        onChange={handleChange}
        placeholder="Contact Number"
      />

      <br/>
      <br/>
      <input
        type="text"
        name="availability"
        value={newBook.availability}
        onChange={handleChange}
        placeholder="Availability"
      />


      <br/>
      <br/>
       <button className="btn btn-primary" onClick={handleAddBook}>
         Add
       </button>

       <br/>
       <br/>
      {/* <Link to='/'>  */}
      <button className="btn btn-primary" onClick={backHome}> Home</button>
      {/* </Link>  */}
       
      
      
     {/* </div> */}
     </div>
       </div>
    
   </div>
 )

}

export default AddEmployee
