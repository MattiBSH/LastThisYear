import React, { useState } from 'react';

function AddBook(props) {
    const[book,setBook]=useState({});
    

    console.log(props.bF.addBook);
    const handleChange = (event) => {
        const target = event.target;
        const property = target.id;
        const value = target.value;
        const tmpBook = { ...book, [property]: value };
        setBook(tmpBook);
      };
    
    const handleSubmit=(event)=>{
        event.preventDefault();
        
        props.bF.addBook(book);
    }
  return (
    <div>
        <div align="center">
     <h1>Add Book</h1>
     <form>
     <h4>Title</h4><input type="text" id="title" onChange={ handleChange }/><br/>
     <h4>Info</h4><input type="text" id="info" onChange={ handleChange }/><br/>
     </form>
     <button onClick={handleSubmit}>Add Book</button>
     </div>
    </div>
  );
}
export default AddBook;