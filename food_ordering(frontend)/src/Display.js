import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';
function Display() {
  const [data, setData] = useState([]);

  useEffect(() => {
    axios.get('http://127.0.0.1:8080/getfood')
      .then(response => {
        setData(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  const handleDelete = (id) => {
    axios.delete(`http://127.0.0.1:8080/delete/${id}`)
    window.location.reload()
      .then(response => {
        setData(data.filter(data => data.id !== id));
        console.log(response + "deleted");
      })
      .catch(error => {
        console.log(error);
      });
  };
  const handleUpdate = async (id) => {
    let amainCourse = prompt("Enter mainCourse");
    let asideDish = prompt("Enter sideDish");
    let aquantity = prompt("Enter quantity");
    let adiscount = prompt("Enter discount");
    let atotal = prompt("Enter total");
    let arating = prompt("Enter rating");


    let newData = {
      restaurant : id,
      mainCourse :amainCourse,
      sideDish : asideDish,
      quantity : aquantity,
      discount: adiscount,
      total: atotal,
      rating: arating
    }


    axios.put(`http://127.0.0.1:8080/upfood`, newData);
    window.location.reload();
  }

  return (
    <div>
    <center><h1 className='h1'> Food Orders ! </h1></center>
    <center>
   <br></br>
    <br></br><br></br><br></br><br></br><br></br><br></br>
      <table>
        <thead>
          <tr>
            <th>restaurant</th>
            <th>maincourse</th>
            <th>sidedish</th>
            <th>quantity</th>
            <th>discount</th>
            <th>total</th>
            <th>rating</th>
          </tr>
        </thead>
        <tbody>
          {data.map(item => (
            <tr key={item.restaurant}>
              <td>{item.restaurant}</td>
              <td>{item.mainCourse}</td>
              <td>{item.sideDish}</td>
              <td>{item.quantity}</td>
              <td>{item.discount}</td>
              <td>{item.total}</td>
              <td>{item.rating}</td>
            
             <td><button onClick={() => handleDelete(item.restaurant)} className='del'>Delete</button></td>
              <td><button onClick={() => handleUpdate(item.restaurant)} className='up'>Update</button></td>
            </tr>
          ))}
        </tbody>
        
      </table>
      </center>
    </div>
  );
}

export default Display;