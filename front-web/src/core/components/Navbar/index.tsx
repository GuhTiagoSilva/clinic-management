import React from 'react';
import './styles.scss'
import { Link, NavLink } from 'react-router-dom';


const Navbar = () => {
    return (
        <nav className="row bg-primary main-nav">
            <div className="col-4">
                <Link to="/" className="nav-logo-text">
                    <h4>CLINIC MANAGEMENT</h4>
                </Link>
            </div>

            <div className="col-6 offset-2">
                <ul className="main-menu">
                    <NavLink to="/" exact>
                        <li>HOME</li>
                    </NavLink>

                    <NavLink to="/users">
                        <li>USUÁRIOS</li>
                    </NavLink>

                    <NavLink to="/admin" exact>
                        <li>ADMIN</li>
                    </NavLink>

                </ul>
            </div>

        </nav>
    );
};

export default Navbar;
