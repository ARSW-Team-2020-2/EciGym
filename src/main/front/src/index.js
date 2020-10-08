import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import Autenticacion from './Autenticacion';
import About from './About';
import ContactPanel from './ContactPanel';
import * as serviceWorker from './serviceWorker';
import Categorias from './Categorias';

ReactDOM.render(
  <React.StrictMode>
    <App />
    <About />
    <Categorias />
    <Autenticacion />
    <ContactPanel />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
