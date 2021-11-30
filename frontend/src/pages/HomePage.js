import PumpAction from "../components/PumpAction";
import WeatherWidget from "../components/WeatherWidget";
import Header from "../components/Header";

export default function Homepage() {

    return (
        <>
            <Header/>
            <WeatherWidget/>
            <PumpAction/>
        </>
    )
}
