import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

const AllDetails = () => {
  const navigate = useNavigate();
  const [books, setBooks] = useState([]); // Rename the state variable to 'books'
  const { id } = useParams();

  useEffect(() => {
    loadBookDetails();
  }, []);

  const loadBookDetails = async () => {
    try {
      const response = await axios.get(`http://localhost:9090/library/libraryid/${id}`);
      setBooks(response.data.result.books); // Update the state with the 'books' array
    } catch (error) {
      console.error('Error fetching book details:', error);
    }
  };

  const backHome = () => {
    navigate('/');
  };

  return (
    <div className='container'>
      <div className='py-4'>
        <h1>Book Details</h1>
        <table className='table table-bordered border border-dark table-hover'>
          <tbody>
            <tr>
              <td>First Name</td>
              <td>Last Name</td>
              <td>Gender</td>
              <td>Library Management ID</td>
              <td>Index Number</td>
              <td>Title</td>
              <td>Contact Number</td>
              <td>Availability</td>
            </tr>
          </tbody>
          <tbody>
            {books.map((book, index) => (
              <tr key={index}>
                <td>{book.firstName}</td>
                <td>{book.lastName}</td>
                <td>{book.gender}</td>
                <td>{book.libraryManagement.id}</td>
                <td>{book.libraryManagement.indexNumber}</td>
                <td>{book.libraryManagement.title}</td>
                <td>{book.contactNumber}</td>
                <td>{book.availability}</td>
              </tr>
            ))}
          </tbody>
        </table>
        <button className='btn btn-primary' onClick={backHome}>
          Home
        </button>
      </div>
    </div>
  );
};

export default AllDetails;
