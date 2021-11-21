import styled from "styled-components/macro";

export default function Header(){
    return(
        <StyledHeader width="150" height="130">
            <text x="0" y="72" fontSize="30px" fill="#338032" fontFamily="Trebuchet MS">micro</text>
            <text x="0" y="100" fontSize="30px" fontWeight="bold" fill="#338032" fontFamily="Trebuchet MS">GARDENER</text>
            <image x="80" y="25" href="seedling.png" width="70" fill="blue"/>
        </StyledHeader>
    )
}

const StyledHeader = styled.svg`
    display: flex;
    align-items: center;
    `