
import React,{useState} from "react"
import axios from "axios"

function UrlScanner(){

const [url,setUrl] = useState("")
const [result,setResult] = useState("")

const scan = async()=>{
try{
const res = await axios.post("http://127.0.0.1:5000/predict",{url:url})
setResult(res.data.prediction)
}catch{
setResult("Server error")
}
}

return(
<div className="card">
<input
type="text"
placeholder="Enter URL"
value={url}
onChange={(e)=>setUrl(e.target.value)}
/>

<button onClick={scan}>Scan URL</button>

<h2>{result}</h2>
</div>
)
}

export default UrlScanner
