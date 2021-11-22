import PumpAction from "../components/PumpAction";
import WeatherWidget from "../components/WeatherWidget";
import Header from "../components/Header";
import styled from "styled-components/macro";

export default function Homepage(){

    return(
        <PageStyle>
            <Header/>
            <WeatherWidget/>
            <PumpAction/>
            <h4>Pump Action</h4>
        </PageStyle>
    )
}

const PageStyle = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  h4{
    width: 100px;
    justify-items: center;
    margin-top: -190px;
    padding-left: 10px;
    margin-right: 180px;
    background-color: white;
    font-family: "Trebuchet MS",serif;
  }
`