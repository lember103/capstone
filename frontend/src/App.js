import {useState} from "react";
import {postMinutes} from "./service/timer-api-service";

function App() {

    const [minutes, setMinutes] = useState("")

    const handleClick = () => {
        postMinutes(minutes).then(response => console.log(response))
    }

    return (
        <>
            <input onChange={event => setMinutes(event.target.value)} placeholder={"Minuten"}/>
            <button onClick={handleClick}>run system</button>
        </>
    );
}

export default App;
