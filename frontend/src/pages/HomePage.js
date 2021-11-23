import PumpAction from "../components/PumpAction";
import WeatherWidget from "../components/WeatherWidget";
import Header from "../components/Header";
import styled from "styled-components/macro";

export default function Homepage(){

    return(
        <PageStyle>
            <Header/>
            <WeatherWidget/>
            <h4 className="dashBoard">Dashboard</h4>
            <PumpAction/>
            <h4 className="pumpAction">Pump Action</h4>
        </PageStyle>
    )
}

const PageStyle = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  .pumpAction{
    width: 100px;
    justify-items: center;
    margin-top: -192px;
    padding-left: 8px;
    margin-right: 180px;
    background-color: white;
    font-family: "Trebuchet MS",serif;
  }
  .dashBoard{
    width: 90px;
    background-color: white;
    font-family: "Trebuchet MS",serif;
    margin-top: -170px;
    padding-left: 13px;
    margin-right: 160px;
  }
`