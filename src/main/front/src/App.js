import React from 'react';

function App() {
  return (
    <div id="inicio" >
      <nav className="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
        <div className="container">
          <a className="navbar-brand" href="index.html">Saleit <span>Subastas</span></a>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span className="oi oi-menu"> </span> Menu
			</button>

          <div className="collapse navbar-collapse" id="ftco-nav">
            <ul className="navbar-nav ml-auto">
              <li className="nav-item"><a href="#inicio" className="nav-link">Inicio</a></li>
              <li className="nav-item"><a href="#acerca" className="nav-link">Acerca de Nosotros</a></li>
              <li className="nav-item"><a href="#categorias" className="nav-link">Categorías</a></li>
              <li className="nav-item"><a href="#autenticacion" className="nav-link">Ingreso/Registro</a></li>
              <li className="nav-item"><a href="#informacion" className="nav-link">Información de Contacto</a></li>
            </ul>
          </div>
        </div>
      </nav>
      <Home> </Home>
    </div>
  );
}

function Home() {
  return (

      <div className="overlay home-background justify-content-center">
        <div className="row align-items-center">
          <div className="col-md-12">
            <div className="text w-100 mt-5 text-center">
            <div className="heading-section mt-5 mb-4">
              <span><h2 className="mb-4 color-white">Saleit</h2></span>
              <h2 className="mb-4 color-white">Tu mejor opción</h2>
              </div>
            </div>
          </div>
        </div>
      </div>
  );
}
export default App;


