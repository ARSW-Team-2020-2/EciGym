import React, {Component} from "react";
import logo from '../assets/images/logo.png'

class Header extends Component {

    render() {

        return (
            <header id="header">
                <div className="center">

                    <div id="logo">
                        <img src={logo} className="app-logo" alt="Logotipo"/>
                        <span id="brand">
                        <strong>Sale-It</strong>
                    </span>
                    </div>


                    <nav id="menu">
                        <ul>
                            <li>
                                <a href="index.html">Inicio</a>
                            </li>
                            <li>
                                <a href="blog.html">Categorías</a>
                            </li>
                            <li>
                                <a href="formulario.html">Iniciar sesión</a>
                            </li>
                        </ul>
                    </nav>


                    <div className="clearfix"></div>
                </div>
            </header>
        );
    }

}

export default Header;
