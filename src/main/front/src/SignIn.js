import React from 'react';

function SignIn() {
    return (
        <section className="ftco-section ftco-wrap-about ftco-no-pb ftco-no-pt">
            <div className="container">
                <div className="row no-gutters">
                    <div className="col-sm-4 p-4 p-md-5 d-flex align-items-center justify-content-center bg-primary">
                        <form action="#" className="appointment-form">
                            <h3 className="mb-3">Ingresa!</h3>
                            <div className="row">
                                <div className="col-md-12">
                                    <div className="form-group">
                                        <input type="name" className="form-control" placeholder="Nombre"></input>
                                    </div>
                                </div>
                                <div className="col-md-12">
                                    <div className="form-group">
                                        <input type="password" className="form-control" placeholder="Contraseña"></input>
                                    </div>
                                </div>

                            </div>
                            <div className="col-md-12">
                                    <div className="form-group">
                                        <input type="submit" value="Enviar" className="btn btn-white py-3 px-4"></input>
                                    </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
    </section>
    );
}

export default SignIn;