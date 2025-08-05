import { useState } from "react";

const IncDec =()=>{
    const [count,setCount]=useState(0);

    return<div>
        <h1>count:{count}</h1>

    <button onClick={()=>setCount(count+1)}>Increment</button>
    <br></br>
    <button onClick={()=>setCount(count-1)}>Decrement</button>
    <br/>
    <button onClick={()=>alert("Welcome")}>Say Welcome</button>
    <br/>
    <button onClick={()=>alert("I was Clicked")}>Click on me</button>
    </div>

} 
export default IncDec;