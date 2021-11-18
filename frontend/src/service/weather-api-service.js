import axios from "axios";

export const getWeatherData = token => {
    const header = {
        headers:{
            Authorization: `Bearer ${token}`
        }
    }
    return axios
        .get("/api/forecast", header)
        .then(response => response.data)
        .catch(error => console.log(error))
}