import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';

export default function AddUser() {

  

const navigate=useNavigate()
  const [books, setBooks] = useState([]);

    //post
  const [newBook, setNewBook] = useState({
    indexNumber: '',
    name: '',
    title: ''
  });

  useEffect(() => {
  }, [books]);

    //post
  const handleAddBook = async () => {
    
    try {
      const response = await axios.post("http://localhost:9090/library/post", newBook);
      console.log('response',response.data.statusCode);
      const message=response.data.statusCode
      if (message=='20000') {
        alert(response.data.message)
        
      }
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
        indexNumber: '',
        name: '',
        title: ''
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
    navigate('/');
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
          name="indexNumber"
          value={newBook.indexNumber}
          onChange={handleChange}
          placeholder="Index Number"
        />
        <br/>
        <br/>
        <input
          type="text"
          name="name"
          value={newBook.name}
          onChange={handleChange}
          placeholder="Name"
        />

        <br/>
        <br/>
        <input
          type="text"
          name="title"
          value={newBook.title}
          onChange={handleChange}
          placeholder="Title"
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