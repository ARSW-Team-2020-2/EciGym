import React from 'react';
import ContactInf from './ContactInf';

function ContactPanel() {
    return (

        <div className="col-sm-12 wrap-about py-5">
            <div className="row pb-5 pb-md-0">
                <div className="col-md-12 col-lg-12">
                    <div className="heading-section mt-5 mb-4">
                        <div className="pl-lg-3 ml-md-5">
                            <span className="subheading">Información de</span>
                            <h2 className="mb-4 ">Contacto</h2>
                        </div>
                    </div>
                    <div className="pl-lg-3 ml-md-5">
                        <ContactInf> </ContactInf>
                    </div>
                </div>
            </div>
        </div>

    );
}

export default ContactPanel;