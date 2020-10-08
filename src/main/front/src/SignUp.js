import React from 'react';

function SignUp() {
    return (

        <section className="ftco-section ftco-wrap-about ftco-no-pb ftco-no-pt">
            <div className="container">
                <div className="row no-gutters">
                    <div className="col-sm-4 p-4 p-md-5 d-flex align-items-center justify-content-center bg-primary">
                        <form action="#" className="appointment-form">
                            <h3 className="mb-3">Regístrate!</h3>
                            <div className="row">
                                <div className="col-md-12">
                                    <div className="form-group">
                                        <input type="name" className="form-control" placeholder="Nombre" required></input>
                                    </div>
                                </div>
                                <div className="col-md-12">
                                    <div className="form-group">
                                        <input type="email" className="form-control" placeholder="Correo" required></input>
                                    </div>
                                </div>
                                <div className="col-md-12">
                                    <div className="form-group">
                                        <input type="text" className="form-control" placeholder="Teléfono" required></input>
                                    </div>
                                </div>
                                <div className="col-md-12">
                                    <div className="form-group">
                                        <input type="password" className="form-control" placeholder="Contraseña" required></input>
                                    </div>
                                </div>

                                <div className="col-md-12">
                                    <div className="form-group">
                                        <div className="form-field">
                                            <div className="select-wrap">
                                                <div className="icon"><span className="fa fa-chevron-down"></span></div>
                                                <select id="tipoDocumento" className="form-control" required>
                                                    <option value="" className="option-color">Tipo de Documento</option>
                                                    <option value="" className="option-color">CC</option>
                                                    <option value="" className="option-color">CE</option>
                                                    <option value="" className="option-color">TI</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-12">
                                    <div className="form-group">
                                        <input type="submit" value="Enviar" className="btn btn-white py-3 px-4"></input>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div> 
                </div>
            </div>
        </section>
    );
}

export default SignUp;