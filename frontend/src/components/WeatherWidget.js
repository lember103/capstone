import styled from "styled-components";
import {useState, useEffect, useContext} from "react";
import {getWeatherData} from "../service/weather-api-service";
import {AuthContext} from "../context/AuthProvider";
import HeavyRainIcon from "./icons/HeavyRainIcon";
import MediumRainIcon from "./icons/MediumRainIcon";
import MaxTempIcon from "./icons/MaxTempIcon";
import MoistureIcon from "./icons/MoistureIcon";
import LightRainIcon from "./icons/LightRainIcon";
import ContainerLevel from "./icons/ContainerLevel";

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
            <fieldset>
                <legend>Dashboard</legend>
                <MaxTempIcon/>
                <text>
                    {Math.round(weatherData.Temperature.Maximum.Value)}°C
                </text>
                {weatherData.Day.Rain.Value < 1 && <LightRainIcon/>}
                {weatherData.Day.Rain.Value >= 1 && weatherData.Day.Rain.Value < 2 && <MediumRainIcon/>}
                {weatherData.Day.Rain.Value >= 2 && <HeavyRainIcon/>}
                <text>
                    {weatherData.Day.RainProbability}%
                </text>
                <MoistureIcon/>
                <text>
                    {Math.round(Math.random() * 100)}%
                </text>
                <ContainerLevel/>
                <text>
                    {Math.round(Math.random() * 100)}%
                </text>
            </fieldset>
        </StyledComponent>
    )
}

const StyledComponent = styled.section`
  display: flex;
  justify-content: center;
  fieldset{
    max-width: 280px;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
    border: 2px solid black;
    border-radius: 12px;
    box-shadow: 5px 5px 5px gray;
  }
  text{
    width: 60px;
    font-family: "Trebuchet MS",serif;
    font-weight: bold;
    font-size: 20px;
  }
  .icon{
    margin: 10px;
  }
  legend{
    font-family: "Trebuchet MS",serif;
    font-weight: bold;
    font-size: 20px;
  }
`