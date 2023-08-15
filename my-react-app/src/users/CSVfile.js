import React, { useState } from 'react';
import axios from 'axios';

const CSVfile = () => {
  
       const [selectedFile, setSelectedFile] = useState(null);
    

const handleFileChange = (event) => {
  setSelectedFile(event.target.files[0]);
};

const handleFileUpload = () => {
  const formData = new FormData();
  formData.append('file', selectedFile);

  axios.post('http://localhost:9090/library/upload', formData, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  })
  .then((response) => {
    console.log(response.data);
    // Handle success
  })
  .catch((error) => {
    console.error(error);
    // Handle error
  });
};

return (
    <div>
      <h1 style={{ color: 'red' }}>CSV File Upload</h1>
      <input type="file" onChange={handleFileChange} />
      <button onClick={handleFileUpload}>Upload</button>
    </div>
  );
};

export default CSVfile
