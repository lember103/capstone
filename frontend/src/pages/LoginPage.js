import {useContext, useState} from 'react'
import styled from "styled-components/macro";
import {AuthContext} from "../context/AuthProvider";
import {Button, TextField, Typography} from "@mui/material";
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Header from "../components/Header";

const initialState = {
    username: '',
    password: '',
}

export default function LoginPage() {
    const [credentials, setCredentials] = useState(initialState)
    const {login} = useContext(AuthContext)

    const handleChange = event => {
        setCredentials({...credentials, [event.target.name]: event.target.value})
    }

    const handleSubmit = event => {
        event.preventDefault()
        login(credentials)
    }

    return (
        <PageLayout>
            <Header/>
            <Form onSubmit={handleSubmit}>
                <LockOutlinedIcon/>
                <Typography component="h1" variant="h5">
                    Login
                </Typography>
                <TextField
                    id="username" label="Username" variant="outlined"
                    required
                    value={credentials.username}
                    name="username"
                    onChange={handleChange}
                />
                <TextField
                    type="password"
                    label="password"
                    variant="outlined"
                    required
                    value={credentials.password}
                    name="password"
                    id="password"
                    onChange={handleChange}
                />
                <Button type="submit" variant="contained">Login</Button>
            </Form>
        </PageLayout>

    )
}
const PageLayout = styled.div`
  display: flex;
  justify-content: space-between;
  gap: 130px;
  align-items: center;
  flex-direction: column;
`

const Form = styled.form`
  display: flex;
  justify-content: space-between;
  gap: 15px;
  align-items: center;
  flex-direction: column;
`