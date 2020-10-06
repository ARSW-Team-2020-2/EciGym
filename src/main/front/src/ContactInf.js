import React from 'react';

function ContactInf() {

    return (
            
            <div id="informacion" className="container">
                <div className="row d-flex contact-info">
                    <div className="w-100"> </div>
                    <div className="col-md-6 d-flex">
                        <div className="dbox">
                            <p><span>Desarrolladores:</span> <a href="Des">Juan Sebastián Díaz, Juan Sebastián Frásica y Daniela Ruiz.</a></p>
                        </div>
                    </div>
                    <div className="col-md-6 d-flex">
                        <div className="dbox">
                            <p><span>Repositorio:</span> <a href="Repo">https://github.com/ARSW-Team-2020-2/SaleIt</a></p>
                        </div>
                    </div>
                </div>
            </div>

    );
}

export default ContactInf;
