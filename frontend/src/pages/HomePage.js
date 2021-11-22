import PumpAction from "../components/PumpAction";
import WeatherWidget from "../components/WeatherWidget";
import Header from "../components/Header";
import styled from "styled-components/macro";

export default function Homepage(){

    return(
        <PageStyle>
            <Header/>
            <WeatherWidget/>
            <PumpAction/>
        </PageStyle>
    )
}

const PageStyle = styled.div`
  display: flex;
  justify-content: space-between;
  gap: 20px;
  align-items: center;
  flex-direction: column
`