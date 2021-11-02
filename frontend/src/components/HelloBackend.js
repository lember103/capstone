import {useState} from "react";
import {getBackendAnswer} from "../service/sayHi-service";

export default function HelloBackend() {

    const [backendAnswer, setBackendAnswer] = useState("")

    const sayHelloBackend = () => {
        setBackendAnswer("Waiting...")
        getBackendAnswer().then(setBackendAnswer)
    }

    return(
        <>
            <button onClick={sayHelloBackend}>Hello Backend</button>
            {backendAnswer}
        </>
    )
}