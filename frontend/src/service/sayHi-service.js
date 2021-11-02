import axios from "axios";

export const getBackendAnswer = () => {
    return(
        axios
            .get("/api/greeting")
            .then(response => response.data)
            .catch(error => console.log(error))
    )

}