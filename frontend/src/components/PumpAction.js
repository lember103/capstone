import styled from "styled-components";
import {useContext, useState} from "react";
import {runPump, stopPump} from "../service/timer-api-service";
import {AuthContext} from "../context/AuthProvider";

export default function PumpAction(){

    const {token} = useContext(AuthContext);
    const [minutes, setMinutes] = useState(0)

    const handleClickRunPumpButton = () => {
        runPump(minutes, token).then()
    }

    const handleClickStopPumpButton = () => {
        stopPump(minutes, token).then()
    }

    return(
        <Styled>
            <input type={"number"} onChange={event => setMinutes(event.target.value)} placeholder={"Minuten"}/>
            <button onClick={handleClickRunPumpButton}>run pump</button>
            <button onClick={handleClickStopPumpButton}>stop pump</button>
        </Styled>
    )
}

const Styled = styled.div `

`