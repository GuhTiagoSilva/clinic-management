import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import Navbar from './core/components/Navbar';
import Home from './pages/Home';

const Routes = () => {
    return (
        <BrowserRouter>
            <Navbar />
            <Switch>
                <Route path="/" exact>
                    <Home/>
                </Route>
                <Route path="/users">

                </Route>

                <Route path="/admin">

                </Route>

            </Switch>
        </BrowserRouter>
    );
};

export default Routes;