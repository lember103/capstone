import {Route, Switch} from 'react-router-dom'
import LoginPage from "./pages/LoginPage";
import Homepage from "./pages/HomePage";
import PrivateRoute from "./routing/PrivateRoute";

function App() {

    return (
        <Switch>
            <Route path='/login'>
                <LoginPage/>
            </Route>
            <PrivateRoute path='/' exact>
                <Homepage/>
            </PrivateRoute>
        </Switch>

    );
}

export default App;
