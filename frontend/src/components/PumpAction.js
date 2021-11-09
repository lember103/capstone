import styled from "styled-components";
import {useState} from "react";
import {postMinutes} from "../service/timer-api-service";

export default function PumpAction(){

    const [minutes, setMinutes] = useState("")

    const updateTimer = () => {
        postMinutes(minutes).then(response => console.log(response))
    }

    return(
        <Styled>
            <input type={"text"} onChange={event => setMinutes(event.target.value)} placeholder={"Minuten"}/>
            <button onClick={updateTimer}>run system</button>
        </Styled>
    )
}

const Styled = styled.div `

`