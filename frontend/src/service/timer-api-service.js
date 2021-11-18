import axios from "axios";

const getHeader = token => {
    console.log(token)
    return {
        headers:{
            Authorization: `Bearer ${token}`
        }
    }
}

export const runPump = (minutes, token) => {
    const timer = {
        pumpRunTimeInMinutes: minutes,
        stopPump: false
    }
    return axios
        .post("/api/timer", timer, getHeader(token))
        .then(response => response.data)
        .catch(error => console.log(error))
}

export const stopPump = (minutes, token) => {
    const timer = {
        pumpRunTimeInMinutes: minutes,
        stopPump: true
    }
    return axios
        .post("/api/timer", timer, getHeader(token))
        .then(response => response.data)
        .catch(error => console.log(error))
}