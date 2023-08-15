import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

const EditEmployee = () => {
    // const navigate = useNavigate();
    // const [user, setUser] = useState({
    //   id: '',
    //   firstName: '',
    //   lastName: '',
    //   gender: '',
    //   libraryManagementId: '',
    //   email: '',
    //   contactNumber: '',
    //   availability: '',
    // });
    // const { id } = useParams();
  
    // useEffect(() => {
    //   loadUserDetails();
    // }, []);
  
    // const loadUserDetails = async () => {
    //   try {
    //     const response = await axios.get(`http://localhost:9090/library/getId/${id}`);
    //     setUser(response.data.result.book);
    //   } catch (error) {
    //     console.error('Error fetching user details:', error);
    //   }
    // };
  
    // const handleChange = (e) => {
    //   const { name, value } = e.target;
    //   setUser((prevUser) => ({
    //     ...prevUser,
    //     [name]: value,
    //   }));
    // };
  
    // const updateUser = async () => {
    //   try {
    //     await axios.put(`http://localhost:9090/library/update/${id}`, user);
    //     navigate('/');
    //   } catch (error) {
    //     console.error('Error updating user details:', error);
    //   }
    // };
  
    // const backHome = () => {
    //   navigate('/');
    // };
  
    // return (
    //   <div className="container">
    //     <div className="py-4">
    //       <h1>Edit User</h1>
    //       <form>
    //         <div className="form-group">
    //           <label>ID</label>
    //           <input
    //             type="text"
    //             className="form-control"
    //             name="id"
    //             value={user.id}
    //             readOnly
    //           />
    //         </div>
    //         <div className="form-group">
    //           <label>Index Number</label>
    //           <input
    //             type="text"
    //             className="form-control"
    //             name="indexNumber"
    //             value={user.indexNumber}
    //             onChange={handleChange}
    //           />
    //         </div>
    //         <div className="form-group">
    //           <label>Name</label>
    //           <input
    //             type="text"
    //             className="form-control"
    //             name="name"
    //             value={user.name}
    //             onChange={handleChange}
    //           />
    //         </div>
    //         <div className="form-group">
    //           <label>Title</label>
    //           <input
    //             type="text"
    //             className="form-control"
    //             name="title"
    //             value={user.title}
    //             onChange={handleChange}
    //           />
    //         </div>
    //         <button type="button" className="btn btn-primary mr-2" onClick={updateUser}>
    //           Update User
    //         </button>
    //         <button type="button" className="btn btn-danger" onClick={backHome}>
    //           Cancel
    //         </button>
    //       </form>
    //     </div>
    //   </div>
    // );

    const {id} =useParams();
    const[values,setValues] = useState({
      id:id,
      firstName:'',
      lastName:'',
      gender:'',
      libraryManagementId:'',
      email:'',
      contactNumber:'',
      availability:''
    })
    useEffect(()=>{
      axios.get('http://localhost:9090/library/getIde1/'+id)
      .then(res => {setValues({...values, firstName:res.data.result.books.firstName ,lastName:res.data.result.books.lastName,
        gender:res.data.result.books.gender ,libraryManagementId:res.data.result.books.libraryManagementId,
        email:res.data.result.books.email ,contactNumber:res.data.result.books.contactNumber,
        availability:res.data.result.books.availability})})
        
      .catch(err => console.log(err))


      //.then(res => console.log(res))
     // .catch(err => console.log(err))
    },[])

const navigate = useNavigate()

    const handleSubmit = (e) =>{
      e.preventDefault();
      axios.put('http://localhost:9090/library/update1/'+id, values)
      .then(res =>{
        navigate('/employeeHome')
      })
      .catch(err => console.log(err))
    }

  return(
    <div className='d-flex w-100 vh-100 justify-content-center align-items-center'>
      <div className='w-150 border bg-secondary text-white p-5'>
        <form onSubmit={handleSubmit}>
          <div>
            <label htmlFor='firstName'>First Name</label>
            <input type='text' name='firstName' className='form-control' placeholder='First Name' 
            value={values.firstName} onChange={e =>setValues({...values,firstName: e.target.value})}/>
          </div>
          <div>
            <label htmlFor='lastName'>Larst Name </label>
            <input type='text' name='lastName' className='form-control' placeholder='Last Name' 
            value={values.lastName} onChange={e =>setValues({...values,lastName: e.target.value})}/>
          </div>
          <div>
            <label htmlFor='gender'>Gender</label>
            <input type='text' name='gender' className='form-control' placeholder='gender' 
            value={values.gender} onChange={e =>setValues({...values,gender: e.target.value})}/>
          </div>
          <div>
            <label htmlFor='libraryManagementId'>library Management Id</label>
            <input type='text' name='libraryManagementId' className='form-control' placeholder='libraryManagementId' 
            value={values.libraryManagementId} onChange={e =>setValues({...values,libraryManagementId: e.target.value})}/>
          </div>
          <div>
            <label htmlFor='email'>Email </label>
            <input type='text' name='email' className='form-control' placeholder='email' 
            value={values.email} onChange={e =>setValues({...values,email: e.target.value})}/>
          </div>
          <div>
            <label htmlFor='availability'>availability </label>
            <input type='text' name='availability' className='form-control' placeholder='availability' 
            value={values.availability} onChange={e =>setValues({...values,availability: e.target.value})}/>
          </div>
          
          <button className='btn btn-info'>Update</button>
        </form>
      </div>
    </div>
  );

}

export default EditEmployee
