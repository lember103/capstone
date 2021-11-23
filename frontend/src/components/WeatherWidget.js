import styled from "styled-components";
import {useState, useEffect, useContext} from "react";
import {getWeatherData} from "../service/weather-api-service";
import {AuthContext} from "../context/AuthProvider";
import HeavyRainIcon from "./icons/HeavyRainIcon";
import MediumRainIcon from "./icons/MediumRainIcon";
import MaxTempIcon from "./icons/MaxTempIcon";
import MoistureIcon from "./icons/MoistureIcon";
import LightRainIcon from "./icons/LightRainIcon";

export default function WeatherWidget() {

    const initialState = {
        "Temperature": {
            "Maximum": {
                "Value": 0.0
            }
        },
        "Day": {
            "RainProbability": 0,
            "Rain": {
                "Value": 0.0
            }
        },
    }

    const [weatherData, setWeatherData] = useState(initialState)
    const {token} = useContext(AuthContext)

    useEffect(() => {
        getWeatherData(token).then(setWeatherData)
    }, [token])

    return (
        <StyledComponent>
            <MaxTempIcon/>
            <div className="data">{Math.round(weatherData.Temperature.Maximum.Value)}°C</div>
            <div className="cloud">
                {weatherData.Day.Rain.Value < 1 && <LightRainIcon/>}
                {weatherData.Day.Rain.Value >= 1 && weatherData.Day.Rain.Value < 2 && <MediumRainIcon/>}
                {weatherData.Day.Rain.Value >= 2 && <HeavyRainIcon/>}
            </div>
            <div className="rainData">{weatherData.Day.RainProbability}%</div>
            <MoistureIcon/>
            <div className="data">{Math.round(Math.random() * 100)}%</div>
        </StyledComponent>
    )
}

const StyledComponent = styled.div`
  display: grid;
  grid-template-columns: 50px 50px 50px 50px;
  grid-template-rows: 50px 50px;
  column-gap: 20px;
  row-gap: 20px;
  border: black 1px solid;
  border-radius: 12px;
  box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.2);
  padding: 20px;
  margin-top: 100px;

  .data {
    font-family: "Trebuchet MS", serif;
    font-weight: bold;
    font-size: 20px;
    padding-top: 10px;
    margin-left: -10px;
  }
  
  .cloud{
    padding-left: 30px;
  }
  
  .rainData{
    font-family: "Trebuchet MS", serif;
    font-weight: bold;
    font-size: 20px;
    padding-top: 10px;
    margin-left: 20px;
  }
`