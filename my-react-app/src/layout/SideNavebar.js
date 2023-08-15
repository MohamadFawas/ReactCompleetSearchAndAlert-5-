import React from 'react';
import './style.css'
import Home from '../pages/Home';
import { useParams, useNavigate } from 'react-router-dom';

const SideNavebar = () => {
    const navigate = useNavigate();
    
    const backHome = () => {
        navigate('/');
      };
      const backview = () => {
        navigate('/addUser');
      };

      
      const dashboard = () => {
        navigate('/dashboard');
      };
      const employeeHome = () => {
        navigate('/employeeHome');
      };
      
      const addEmployee = () => {
        navigate('/addEmployee');
      };

      const allDetails = () => {
        navigate('/allDetails');
      };

      



      const listItems = document.querySelectorAll(".list-group-item");
  listItems.forEach(item => {
    item.addEventListener("click", () => {
      // Remove 'selected' class from all list items
      listItems.forEach(item => item.classList.remove("selected"));
      // Add 'selected' class to the clicked item
      item.classList.add("selected");
    });
  });

  
  return (
    <div className="bg-white sidebar p-2">
    <div className='m-2'>
      <i className='bi bi-bootstrap-fill me-3 fs-4'></i>
      <span className='brand-name fs-4'>Book </span>
    </div>
    
    <hr className='text-dark'/>
    <div className='list-group list-group-flush'>
        <a className='list-group-item py-2 '>
            <i className='bi bi-speedometer2 fs-5 me-3'></i>
            <span className='fs-5' onClick={dashboard}>Dashboard</span>
        </a>
        <a className='list-group-item py-2'>
            <i className='bi bi-house fs-5 me-3'></i>
            <span className='fs-5' onClick={backHome}>
          Home
        </span>
            
        </a>

        <a className='list-group-item py-2'>
            <i className='bi bi-table fs-5 me-3'></i>
            <span className='fs-5' onClick={backview}>Add Details</span>
        </a>
        {/* <a className='list-group-item py-2'>
            <i className='bi bi-clipboard-data fs-5 me-3'></i>
            <span className='fs-5'>Products</span>
        </a>
        <a className='list-group-item py-2'>
            <i className='bi bi-people fs-5 me-3'></i>
            <span className='fs-5'>Customers</span>
        </a>
        <a className='list-group-item py-2'>
            <i className='bi bi-power fs-5 me-3'></i>
            <span className='fs-5'>LogOut</span>
        </a> */}

        <a className='list-group-item py-2'>
            <i className='bi bi-house fs-5 me-3'></i>
            <span className='fs-5' onClick={employeeHome}>
                BookUserHome
            </span>
            
        </a>

        <a className='list-group-item py-2'>
            <i className='bi bi-table fs-5 me-3'></i>
            <span className='fs-5' onClick={addEmployee}>Add BUD</span>
        </a>

        {/* <a className='list-group-item py-2'>
            <i className='bi bi-table fs-5 me-3'></i>
            <span className='fs-5' onClick={allDetails}>Add BUD</span>
        </a> */}

        

    </div>
  </div>
  );
};

export default SideNavebar;