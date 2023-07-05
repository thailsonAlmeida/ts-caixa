import { BrowserRouter, Route } from "react-router-dom";
import Home from "./Home";
import Deposits from "./Deposits";
import Navbar from "./Navbar";

function Routes() {
    return(
        <BrowserRouter>
            <Navbar />
            <Route component={ Home } path="/" exact />
            <Route component={ Deposits } path="/depositos" exact />
        </ BrowserRouter>
    )
}

export default Routes;