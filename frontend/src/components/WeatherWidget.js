import styled from "styled-components";
import {useState, useEffect, useContext} from "react";
import {getWeatherData} from "../service/weather-api-service";
import {AuthContext} from "../context/AuthProvider";
import HeavyRainIcon from "./icons/HeavyRainIcon";
import MediumRainIcon from "./icons/MediumRainIcon";
import MaxTempIcon from "./icons/MaxTempIcon";
import MoistureIcon from "./icons/MoistureIcon";
import LightRainIcon from "./icons/LightRainIcon";

export default function WeatherWidget(){

    const initialState = {
        "Temperature":{
            "Maximum":{
                "Value":0.0
            }
        },
        "Day":{
            "RainProbability":0,
            "Rain":{
                "Value":0.0
            }
        },
    }

    const [weatherData, setWeatherData] = useState(initialState)
    const {token} = useContext(AuthContext)

    useEffect(() => {
        getWeatherData(token).then(setWeatherData)
    }, [token])

    return(
        <StyledComponent>
            <StyledIcons>
                <MaxTempIcon/>
                {weatherData.Day.Rain.Value < 1 && <LightRainIcon/>}
                {weatherData.Day.Rain.Value >= 1 && weatherData.Day.Rain.Value < 2 && <MediumRainIcon/>}
                {weatherData.Day.Rain.Value >= 2 && <HeavyRainIcon/>}
                <MoistureIcon/>
            </StyledIcons>
            <StyledValues>
                <div className="temp">{Math.round(weatherData.Temperature.Maximum.Value)}°C</div>
                <div>{weatherData.Day.RainProbability}%</div>
                <div className="moisture">{Math.round(Math.random()*100)}%</div>
            </StyledValues>

        </StyledComponent>
    )
}

const StyledComponent = styled.div`
  display: flex;
  justify-content: center;
  gap: 10px;
  margin-top: 80px;
`

const StyledIcons = styled.div `
  display: flex;
  flex-direction: column;
  gap: 20px;
`

const StyledValues = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  font-family: "Trebuchet MS",serif;
  font-weight: bold;
  font-size: 20px;
  .temp{
    margin-top: -10px;
  }
  .moisture{
    margin-bottom: -10px;
  }
`