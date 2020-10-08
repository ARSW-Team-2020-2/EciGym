import React from 'react';
import Subasta from './Subasta';

function Categorias() {

    return (


        <div id="categorias" className="container">
            <div className="row justify-content-center mt-5 pb-2">
                <div className="col-md-7 text-center heading-section">
                    <span className="subheading">Nuestras</span>
                    <h2 className="mb-4">Categorías</h2>
                </div>
            </div>
            <div className="row">
                <div className="col-md-4">
                    <div className="blog-entry">
                        <img src='/img/hogar.jpg' alt="hogar"></img>
                        <div className="text-center px-4 pt-3 pb-4">
                            <h3 className="heading">Hogar y Cocina</h3>
                            <p className="clearfix">
                                <button className="btn btn-primary">Ver Artículos</button>
                                <button className="btn btn-primary ml-3" data-toggle="modal" data-target="#agregarSubasta">Ofertar Artículo</button>
                            </p>
                        </div>
                    </div>
                </div>
                <div className="col-md-4">
                    <div className="blog-entry">
                    <img src='/img/belleza.jpg' alt="belleza"></img>
                        <div className="text-center px-4 pt-3 pb-4">
                            <h3 className="heading">Salud y Belleza</h3>
                            <p className="clearfix">
                                <button className="btn btn-primary">Ver Artículos</button>
                                <button className="btn btn-primary ml-3" data-toggle="modal" data-target="#agregarSubasta">Ofertar Artículo</button>
                            </p>
                        </div>
                    </div>
                </div>
                <div className="col-md-4">
                    <div className="blog-entry">
                    <img src='/img/licores.png' alt="licores"></img>
                        <div className="text-center px-4 pt-3 pb-4">
                            <h3 className="heading">Bebidas y Licores</h3>
                            <p className="clearfix">
                                <button className="btn btn-primary">Ver Artículos</button>
                                <button className="btn btn-primary ml-3" data-toggle="modal" data-target="#agregarSubasta">Ofertar Artículo</button>
                            </p>
                        </div>
                    </div>
                </div>
            </div>

            <div className="row">
                <div className="col-md-4">
                    <div className="blog-entry">
                    <img src='/img/carros.jpg' alt="carros"></img>
                        <div className="text-center px-4 pt-3 pb-4">
                            <h3 className="heading">Carros y Motos</h3>
                            <p className="clearfix">
                                <button className="btn btn-primary">Ver Artículos</button>
                                <button className="btn btn-primary ml-3" data-toggle="modal" data-target="#agregarSubasta">Ofertar Artículo</button>
                            </p>
                        </div>
                    </div>
                </div>
                <div className="col-md-4">
                    <div className="blog-entry">
                    <img src='/img/bb.jpg' alt="infantil"></img>
                        <div className="text-center px-4 pt-3 pb-4">
                            <h3 className="heading">Sección Infantil</h3>
                            <p className="clearfix">
                                <button className="btn btn-primary">Ver Artículos</button>
                                <button className="btn btn-primary ml-3" data-toggle="modal" data-target="#agregarSubasta">Ofertar Artículo</button>
                            </p>
                        </div>
                    </div>
                </div>
                <div className="col-md-4">
                    <div className="blog-entry">
                    <img src='/img/ropa.jpg' alt="ropa"></img>
                        <div className="text-center px-4 pt-3 pb-4">
                            <h3 className="heading">Ropa y Accesorios</h3>
                            <p className="clearfix">
                                <button className="btn btn-primary">Ver Artículos</button>
                                <button className="btn btn-primary ml-3" data-toggle="modal" data-target="#agregarSubasta">Ofertar Artículo</button>
                            </p>
                        </div>
                    </div>
                </div>
            </div>

            <div className="row">
                <div className="col-md-4">
                    <div className="blog-entry">
                    <img src='/img/muebles.jpg' alt="muebles"></img>
                        <div className="text-center px-4 pt-3 pb-4">
                            <h3 className="heading">Muebles y Jardinería</h3>
                            <p className="clearfix">
                                <button className="btn btn-primary">Ver Artículos</button>
                                <button className="btn btn-primary ml-3" data-toggle="modal" data-target="#agregarSubasta">Ofertar Artículo</button>
                            </p>
                        </div>
                    </div>
                </div>
                <div className="col-md-4">
                    <div className="blog-entry">
                    <img src='/img/tec.jpg' alt="tecnologia"></img>
                        <div className="text-center px-4 pt-3 pb-4">
                            <h3 className="heading">Sección de Tecnología</h3>
                            <p className="clearfix">
                                <button className="btn btn-primary">Ver Artículos</button>
                                <button className="btn btn-primary ml-3" data-toggle="modal" data-target="#agregarSubasta">Ofertar Artículo</button>
                            </p>
                        </div>
                    </div>
                </div>
                <div className="col-md-4">
                    <div className="blog-entry">
                    <img src='/img/deporte.jpg' alt="deporte"></img>
                        <div className="text-center px-4 pt-3 pb-4">
                            <h3 className="heading">Sección Deportiva</h3>
                            <p className="clearfix">
                                <button className="btn btn-primary">Ver Artículos</button>
                                
                                <button className="btn btn-primary ml-3" data-toggle="modal" data-target="#agregarSubasta">Ofertar Artículo</button>

                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <Subasta></Subasta>
        </div>

    );
}

export default Categorias;