import styled from "styled-components";
import {useState, useEffect} from "react";
import {getWeatherData} from "../service/weather-api-service";

export default function WeatherWidget(){

    const initialState = {
        "pop": 0.0,
        "rain": 0.0,
        "temp": 0.0
    }

    const [weatherData, setWeatherData] = useState(initialState)

    useEffect(() => {
        getWeatherData().then(setWeatherData)
    }, [])

    return(
        <Styled>
            <div>Max. Temperature: {Math.round(weatherData.temp)}°C</div>
            <div>Rain: {weatherData.rain}mm ({weatherData.pop}%)</div>
        </Styled>
    )
}

const Styled = styled.div `

`