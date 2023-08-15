import React from 'react'
import { Link } from 'react-router-dom'

const Nabar = () => {

  
  return (
    <div>
    
      <nav className="navbar navbar-expand-lg navbar-dark bg-success">

       <div class="input-group">
          <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
          <button type="button" class="btn btn-danger">search</button>
        </div>

        <div className="container-fluid">
           <a className="navbar-brand" href="#">Full Stuck Application</a>
    
    
           {/* <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
             <span className="navbar-toggler-icon"></span> 
            </button>*/}
   
            {/* <Link className='btn btn-outline-danger' to='/addUser'>Add User</Link>     */}
            <Link className='btn btn-outline-light' to='/file'>CSV file</Link> 
        </div>
      </nav>

    </div>
  )
}

export default Nabar
