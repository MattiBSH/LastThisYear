import React, { useState } from 'react';

function FindBook(props) {
    const[id,setId]=useState(0);
    const[book,setBook]=useState({});

    const handleChange = (event) => {
        const target = event.target;
        const value = target.value;
        setId(value);
      };

      const handleSubmit=(event)=>{
        event.preventDefault();
        console.log("her er id i submit"+id);
        console.log(props.bF.findBook)
        let book1=props.bF.findBook(id);
        setBook(book1);
        
    }
    function bookDelete(){
        console.log(id)
        console.log(props.bF.deleteBook)
        props.bF.deleteBook(id);
    }
  return (
    <div>
     <h1>FindBook</h1>
     {console.log(book)}

     <input type="text" name="id" id="id" onChange={handleChange}/>
     <button onClick={handleSubmit}>Find</button>
    
     <table>
         <thead>
             <tr><th>ID</th><th>Title</th><th>Info</th></tr>
         </thead>
         <tbody>
             
             <tr><td>{book.id}</td><td>{book.title}</td><td>{book.info}</td></tr>
             <div><button onClick={bookDelete}>Delete</button></div>
         </tbody>
     </table>
    </div>
  );
}
export default FindBook;
