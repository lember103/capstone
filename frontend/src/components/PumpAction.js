import styled from "styled-components";
import {useContext, useState} from "react";
import {runPump, stopPump} from "../service/timer-api-service";
import {AuthContext} from "../context/AuthProvider";
import StartIcon from "./icons/StartIcon";
import StopIcon from "./icons/StopIcon";

export default function PumpAction() {

    const {token} = useContext(AuthContext);
    const [minutes, setMinutes] = useState(0)
    const durations = [5, 10, 15, 20]

    const handleClickRunPumpButton = () => {
        runPump(minutes, token).then()
    }

    const handleClickStopPumpButton = () => {
        stopPump(minutes, token).then()
    }

    return (
        <StyledComponent>
            <fieldset>
                <legend>
                    Pump Action
                </legend>
                {durations.map(minute =>
                    <button key={minute} onClick={() => {setMinutes(minute)}}>
                        <text>{minute}'</text>
                    </button>)}
                <button onClick={handleClickRunPumpButton}>
                    <StartIcon/>
                </button>
                <button onClick={handleClickStopPumpButton}>
                    <StopIcon/>
                </button>
            </fieldset>
        </StyledComponent>
    )
}

const StyledComponent = styled.section`
  display: flex;
  justify-content: center;
  margin-top: 30px;
  legend{
    font-family: "Trebuchet MS",serif;
    font-weight: bold;
    font-size: 20px;
  }
  fieldset{
    max-width: 280px;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    border: 2px solid black;
    border-radius: 12px;
    box-shadow: 5px 5px 5px gray;
  }
  button{
    width: 70px;
    height: 70px;
    margin: 10px; 
    background-color: white;
    border-radius: 12px;
    &:focus{
     background-color: #338032; 
    }
  }
  text{
    font-family: "Trebuchet MS",serif;
    font-weight: bold;
    font-size: 20px;
  }
`









