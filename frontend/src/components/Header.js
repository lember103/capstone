import styled from "styled-components/macro";

export default function Header() {
    return (
        <StyledHeader>
            <svg width="150" height="100">
                <text x="0" y="72" fill="#338032">
                    micro
                </text>
                <text x="0" y="100" fontWeight="bold" fill="#338032">
                    GARDENER
                </text>
                <image x="80" y="25" href="seedling.png" width="70"/>
            </svg>
        </StyledHeader>
    )
}

const StyledHeader = styled.section`
  display: flex;
  justify-content: center;
  padding-bottom: 20px;
  font-family: "Trebuchet MS", serif;
  font-size: 30px;
`