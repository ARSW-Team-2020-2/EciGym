import React from 'react';
import logo from './assets/images/logo.svg';
import './assets/css/App.css';
import MiComponente from "./components/MiComponente";

import Header from "./components/Header";
import Slider from "./components/Slider";
import Sidebar from "./components/Sidebar";
import Footer from "./components/Footer";
import UltimosArticulos from "./components/UltimosArticulos";

function App() {


    return (
        <div className="App">

            <Header></Header>

            <Slider></Slider>

            <div className="center">
                <UltimosArticulos></UltimosArticulos>
                <Sidebar></Sidebar>
            </div>

            <Footer></Footer>
        </div>
    );
}

export default App;
