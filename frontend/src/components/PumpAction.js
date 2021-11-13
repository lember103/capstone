import styled from "styled-components";
import {useState} from "react";
import {runAutoPump, runPump, stopPump} from "../service/timer-api-service";

export default function PumpAction(){

    const [minutes, setMinutes] = useState(0)

    const handleClickRunPumpButton = () => {
        runPump(minutes).then()
    }
    const handleClickStopPumpButton = () => {
        stopPump(minutes).then()
    }
    const handleClickAutoButton = () => {
        runAutoPump().then()
    }

    return(
        <Styled>
            <input type={"number"} onChange={event => setMinutes(event.target.value)} placeholder={"Minuten"}/>
            <button onClick={handleClickRunPumpButton}>run pump</button>
            <button onClick={handleClickStopPumpButton}>stop pump</button>
            <button onClick={handleClickAutoButton}>auto</button>
        </Styled>
    )
}

const Styled = styled.div `

`