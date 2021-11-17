import axios from "axios";

export const getWeatherData = () => {
    return axios
        .get("/api/forecast")
        .then(response => response.data)
        .catch(error => console.log(error))
}