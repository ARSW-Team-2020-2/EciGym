import React from 'react';
import SignIn from './SignIn';
import SignUp from './SignUp';

function Autenticacion() {
    return (
    <div className="container register auction-image">
        <div className="container register">
            <ul className="nav nav-tabs" id="myTab" role="tablist">
            <li className="nav-item">
                    <a className="nav-link" id="profile-tab" data-toggle="tab" href="TabRegistrarse" role="tab" aria-controls="profile" aria-selected="false">Sign up</a>
                </li>
                <li className="nav-item">
                    <a className="nav-link active" id="home-tab" data-toggle="tab" href="TabIngresar" role="tab" aria-controls="home" aria-selected="true">Sign in</a>
                </li>
            </ul>
            <div className="tab-content" id="myTabContent">
                <div className="tab-pane fade fade show active" id="TabSignIn" role="tabpanel" aria-labelledby="home-tab">
                    <SignUp> </SignUp>
                </div>
                <div className="tab-pane" id="TabSignUp" role="tabpanel" aria-labelledby="profile-tab">
                    <SignIn> </SignIn>
                </div>
            </div>
        </div>
    </div>
    );
}

export default Autenticacion;