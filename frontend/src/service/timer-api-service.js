import axios from "axios";

export const runPump = minutes => {
    const timer = {
        pumpRunTimeInMinutes: minutes,
        stopPump: false
    }
    return axios
        .post("/api/timer", timer)
        .then(response => response.data)
        .catch(error => console.log(error))
}

export const stopPump = minutes => {
    const timer = {
        pumpRunTimeInMinutes: minutes,
        stopPump: true
    }
    return axios
        .post("/api/timer", timer)
        .then(response => response.data)
        .catch(error => console.log(error))
}