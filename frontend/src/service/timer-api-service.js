import axios from "axios";

export const postMinutes = minutes => {

    const timer = {
        timerDuration: minutes
    }

    return axios
        .post("/api/timer", timer)
        .then(response => response.data)
        .catch(error => console.log(error))
}