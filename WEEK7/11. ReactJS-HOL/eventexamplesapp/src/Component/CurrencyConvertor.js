import { useState } from "react";

const CurrencyConvertor = () => {
    const[data,setData]=useState({
        amount:"0",
        currency:""
    });
    const handleChange=(e,key)=>{
        let dataCopy={...data}
        dataCopy[key]=e.target.value
        setData(dataCopy)
        console.log(data.currency)

            
        }
    const handleSubmit=()=>{
        let calcValue=0
        if (data.currency === "euro"){
            calcValue= 0.0099*data.amount
        }
        alert("Converting To Euro Amount is : "+calcValue.toFixed(2));

    }

    

    


    return <>
    
    <h1 style={{color:"green"}}>Currency Convertor!!!</h1>
    <label style={{margin:'30px'}}>Amount:</label>
    <input type='number' style={{marginLeft:"9px", marginBottom:"10px"}} value={data.amount} onChange={(event)=>handleChange(event,'amount') }></input>
    <br/>
    
    <label style={{margin:'30px'}}>Currency:</label>
    <input type="text" value={data.currency} onChange={(event)=>handleChange(event,'currency')}></input>
    <br/>
    <button onClick={()=>handleSubmit()} style={{marginLeft:"150px", marginTop:"10px"  }}>Submit</button>
    </>
};

export default CurrencyConvertor;
