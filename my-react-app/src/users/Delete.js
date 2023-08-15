import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';
import Swal from 'sweetalert2';

export default function ViewUser() {
  const navigate = useNavigate();
  const [book, setBook] = useState({});
  const { id } = useParams();

  useEffect(() => {
    loadUserDetails();
  }, []);

  const loadUserDetails = async () => {
    try {
      const response = await axios.get(`http://localhost:9090/library/getId/${id}`);
      setBook(response.data.result.book);
    } catch (error) {
      console.error('Error fetching user details:', error);
    }
  };

  const backHome = () => {
    navigate('/');
  };

  const deleteUser = async () => {
    try {
      const confirmationResult = await Swal.fire({
        title: 'Confirm Delete',
        text: 'Are you sure you want to delete this user?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Delete',
        cancelButtonText: 'Cancel',
        dangerMode: true,
      });

      if (confirmationResult.isConfirmed) {
        const response = await axios.delete(`http://localhost:9090/library/delete/${id}`);
        console.log('response', response.data.statusCode);
        const message = response.data.statusCode;
        if (message === '20000') {
          Swal.fire({
            title: 'Deleted',
            text: response.data.message,
            icon: 'success',
          });
        }
        navigate('/');
      }
    } catch (error) {
      console.error('Error deleting user:', error);
    }
  };

  return (
    <div className="container">
      <div className="py-4">
        <h1>User Details</h1>
        <table className="table table-bordered border border-dark table-hover">
          <tbody>
            <tr>
              <td>ID</td>
              <td>{book.id}</td>
            </tr>
            <tr>
              <td>Index Number</td>
              <td>{book.indexNumber}</td>
            </tr>
            <tr>
              <td>Name</td>
              <td>{book.name}</td>
            </tr>
            <tr>
              <td>Title</td>
              <td>{book.title}</td>
            </tr>
          </tbody>
        </table>
        <button className="btn btn-danger mr-2" onClick={deleteUser}>
          Delete User
        </button>
        <button className="btn btn-primary" onClick={backHome}>
          Home
        </button>
      </div>
    </div>
  );
}
