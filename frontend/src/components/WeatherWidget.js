import styled from "styled-components";
import {useState, useEffect} from "react";
import {getWeatherData} from "../service/weather-api-service";

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

    useEffect(() => {
        getWeatherData().then(setWeatherData)
    }, [])

    return(
        <Styled>
            <div>Max. Temperature: {Math.round(weatherData.Temperature.Maximum.Value)}°C</div>
            <div>Rain: {weatherData.Day.Rain.Value}mm ({weatherData.Day.RainProbability}%)</div>
            <div>Rel. Bodenfechtigkeit: {Math.round(Math.random()*100)}%</div>
        </Styled>
    )
}

const Styled = styled.div `

`