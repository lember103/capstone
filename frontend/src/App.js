import PumpAction from "./components/PumpAction";
import styled from "styled-components";
import WeatherWidget from "./components/WeatherWidget";

function App() {

    return (
        <Styled>
            <PumpAction/>
            <WeatherWidget/>
        </Styled>

    );
}

export default App;

const Styled = styled.div `

`
