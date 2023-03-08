import React, { useState } from 'react';
import axios from 'axios';
import "./App.css";
function Form() {
    const [restaurant, setrestaurant] = useState('');
    const [maincourse, setmaincourse] = useState('');
    const [sidedish, setsidedish] = useState('');
    const [quantity, setquantity] = useState('');
    const [discount, setdiscount] = useState('');
    const [total, settotal] = useState('');
    const [rating, setrating] = useState('');

    const handlerestaurant = (event) => {
        setrestaurant(event.target.value);
    }
    const handlemaincourse = (event) => {
        setmaincourse(event.target.value);
    }
    const handlesidedish = (event) => {
        setsidedish(event.target.value);
    }
    const handlequantity = (event) => {
        setquantity(event.target.value);
    }
    const handlediscount = (event) => {
        setdiscount(event.target.value);
    }
    const handletotal = (event) => {
        settotal(event.target.value);
    }
    const handlerating = (event) => {
        setrating(event.target.value);
    }

    async function handlesubmit(event) {
        event.preventDefault();
        const data = {
            restaurant: restaurant,
            maincourse:maincourse,
            sidedish: sidedish,
            quantity: quantity,
            discount: discount,
            total: total,
            rating:rating
        }
        await axios.post('http://localhost:8080/addfood', data)
            .then(res => {
                console.log(res.data);
            })
            .catch(err => {
                console.log(err);
            })
        setrestaurant('');
        setmaincourse('');
        setsidedish('');
        setdiscount('');
        setquantity('');
        settotal('');
        setrating('');
    }

    return (
        <div className='form'>
            <div className='full'>
                <center><h3>Add Your Details !</h3></center>
                <center>
                <label >restaurant</label>
                <input type="text" id="restaurant" placeholder='restaurant' onChange={handlerestaurant} value={restaurant}></input>
                <br></br> <br></br>
                <label>maincourse</label>
                <input type="text" id="maincourse" placeholder='maincourse' onChange={handlemaincourse} value={maincourse}></input>
                <br></br> <br></br>
                <label>sidedish</label>
                <input type="text" id="sidedish" placeholder='sidedish' onChange={handlesidedish} value={sidedish}></input>
                <br></br> <br></br>
                <label>quantity</label>
                <input type="text" id="quantity" placeholder='quantity' onChange={handlequantity} value={quantity}></input>
                <br></br> <br></br>
                <label>discount</label>
                <input type="text" id="discount" placeholder='discount' onChange={handlediscount} value={discount}></input>
                <br></br> <br></br>
                <label>total</label>
                <input type="text" id="total" placeholder='total' onChange={handletotal} value={total}></input>
                <br></br> <br></br>
                <label>rating</label>
                <input type="text" id="rating" placeholder='rating' onChange={handlerating} value={rating}></input>
                <br></br> <br></br>
                </center>
                <center>
                    <button className="add" onClick={handlesubmit}>Submit</button>
                    
                  
                </center>
            </div>
        </div>
    )
}


export default Form;


