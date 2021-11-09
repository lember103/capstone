import styled from "styled-components";
import {useState} from "react";
import {runPump, stopPump} from "../service/timer-api-service";

export default function PumpAction(){

    const [minutes, setMinutes] = useState("")

    const handleClickRunPumpButton = () => {
        runPump(minutes).then()
    }

    const handleClickStopPumpButton = () => {
        stopPump(minutes).then()
    }

    return(
        <Styled>
            <input type={"text"} onChange={event => setMinutes(event.target.value)} placeholder={"Minuten"}/>
            <button onClick={handleClickRunPumpButton}>run pump</button>
            <button onClick={handleClickStopPumpButton}>stop pump</button>
        </Styled>
    )
}

const Styled = styled.div `

`