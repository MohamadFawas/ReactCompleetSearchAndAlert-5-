import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';

const EmployeeHome = () => {
 
    const [users,setUsers]=useState([])
 

    useEffect(() => {
        loadUsers();
       // console.log("code with arjun");
    },[]);
    
   

    const loadUsers= async ()=>{
        const result=await axios.get("http://localhost:9090/library/getAlle1")
        setUsers(result.data.result.books);
        //console.log('result',result.data.result.books);
    };

    return (
    <div className='container' style={{textAlign:'center'}}>
            <h1 style={{ color: 'red' }}>Book User Home Page</h1>
    <div className='py-4'style={{ width: '50px', height: '200px' }}>

        <table className="table border shadow"  >
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">firstName</th>
      <th scope="col">lastName</th>
      <th scope="col">gender</th>
      <th scope="col" >LMId</th>
      <th scope="col">email</th>
      <th scope="col">contactNumber</th>
      <th scope="col">availability</th>
      <th colspan="4">Action</th>
    </tr>
  </thead>
  <tbody>

{
    users.map((user,index)=>(
        <tr key={user.id}>
              <th scope="row">{index + 1}</th>
        <td>{user.firstName}</td>
        <td>{user.lastName}</td>
        <td>{user.gender}</td> 
        <td>{user.libraryManagementId}</td>
        <td>{user.email}</td>
        <td>{user.contactNumber}</td>
        <td>{user.availability}</td>
        <td>{user.title}</td>
        
        <td className="mx-2">
          <td>
        <Link to={`/viewEmployee/${user.id}`}><button className='btn btn-primary mx-2' >View</button></Link>

        <Link to={`/editEmployee/${user.id}`}><button className="btn btn-outline-primary mx-2" >Edit</button></Link>
            
           < Link to={`/deleteEmployee/${user.id}`}><button className="btn btn-danger mx-2" >Delete</button></Link>
            
             {/* <button className='btn btn-primary mx-2' >View</button>
             
             {/* <button className='btn btn-primary mx-2' >View</button> 
        </td>
        <td><button className='btn btn-primary mx-2' >View</button></td>
        <td><button className='btn btn-primary mx-2' >View</button></td>
         */}
         </td>
         </td>
        </tr>
    ))
}

  </tbody>
</table>

        </div>
    </div>
  )
}

export default EmployeeHome
