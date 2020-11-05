import React, { useState } from 'react';

function Products(props) {
    let arr=props.bF.getBooks();
    console.log(arr.length)
    let mappedProducts=arr.map(x=>{
        console.log(x);
        return <tr><th>{ x.id}</th> <th> { x.title}</th><th> { x.info}</th></tr>
    })
  return (
    <div>
     <h1>Products</h1>
     <table>
         <thead>
             <tr><th>ID</th><th>Title</th><th>Info</th></tr>
         </thead>
         <tbody>
             {mappedProducts}
         </tbody>
     </table>
    </div>
  );
}
export default Products;