import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

const ViewEmployee = () => {
    const navigate=useNavigate()

    const [book, setUser] = useState({});
    const { id } = useParams();
   
  
    useEffect(() => {
      loadUserDetails();
    }, []);
  
    const loadUserDetails = async () => {
      try {
        const response = await axios.get(`http://localhost:9090/library/getIde1/${id}`);
        setUser(response.data.result.books);
  
  
      } catch (error) {
        console.error('Error fetching user details:', error);
      }
    };
  
    const backHome =  () => {
      navigate('/employeeHome');
    }
  
    return (
      <div className='container'>
        <div className='py-4'>
          <h1>User Details</h1>
          {/* <table className='table border border-dark table-hover'> */}
          <table className='table table-bordered border border-dark table-hover ' >
            <tbody>
              <tr>
                <td>ID</td>
                <td>{book.id}</td>
              </tr>
              <tr>
                <td>First Name</td>
                <td>{book.firstName}</td>
              </tr>
              <tr>
                <td>Last Name</td>
                <td>{book.lastName}</td>
              </tr>
              <tr>
                <td>Gender</td>
                <td>{book.gender}</td>
              </tr>
              <tr>
                <td>Library Management Id</td>
                <td>{book.libraryManagementId}</td>
              </tr>
              
              <tr>
                <td>Email</td>
                <td>{book.email}</td>
              </tr>
              <tr>
                <td>ContactNumber</td>
                <td>{book.contactNumber}</td>
              </tr>
              <tr>
                <td>Availability</td>
                <td>{book.availability}</td>
              </tr> 
            </tbody>
          </table>
          <button className="btn btn-primary" onClick={backHome}> Home</button>
        </div>
      </div>
    );
}

export default ViewEmployee
