import styled from "styled-components";
import {useContext, useState} from "react";
import {runPump, stopPump} from "../service/timer-api-service";
import {AuthContext} from "../context/AuthProvider";
import {Button} from "@mui/material";
import PlayCircleOutlineIcon from '@mui/icons-material/PlayCircleOutline';
import StopCircleOutlinedIcon from '@mui/icons-material/StopCircleOutlined';

export default function PumpAction(){

    const {token} = useContext(AuthContext);
    const [minutes, setMinutes] = useState(0)

    console.log(minutes)

    const handleClickRunPumpButton = () => {
        runPump(minutes, token).then()
    }

    const handleClickStopPumpButton = () => {
        stopPump(minutes, token).then()
    }

    return(
        <StyledComponent>
            <MinuteButtons>
                <Button className="Button" variant="outlined" onClick={()=>{setMinutes(5)}}>5'</Button>
                <Button className="Button" variant="outlined" onClick={()=>{setMinutes(10)}}>10'</Button>
                <Button className="Button" variant="outlined" onClick={()=>{setMinutes(15)}}>15'</Button>
                <Button className="Button" variant="outlined" onClick={()=>{setMinutes(20)}}>20'</Button>
            </MinuteButtons>
            <ActionButtons>
                <Button className="Button" variant="outlined" startIcon={<PlayCircleOutlineIcon sx={{ fontSize: 40 }}/>} onClick={handleClickRunPumpButton}>start</Button>
                <Button className="Button" variant="outlined" startIcon={<StopCircleOutlinedIcon/>} onClick={handleClickStopPumpButton}>stop</Button>
            </ActionButtons>
        </StyledComponent>
    )
}

const StyledComponent = styled.div `
  display: flex;
  justify-content: center;
  gap: 40px;
  border: black 1px solid;
  border-radius: 12px;
  box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.2);
  padding: 20px;
  margin-top: 30px;
  .Button{
    font-family: "Trebuchet MS",serif;
    font-weight: bold;
    font-size: 20px;
    color: black;
    border-color: black;
  }
`

const MinuteButtons = styled.div`
  display: grid;
  grid-template-columns: [secon] 60px [third] 60px;
  grid-template-rows: [first] 60px [second] 60px;
  column-gap: 20px;
  row-gap: 20px;
`

const ActionButtons = styled.div `
  display: flex;
  flex-direction: column;
  justify-content: space-around;
`









