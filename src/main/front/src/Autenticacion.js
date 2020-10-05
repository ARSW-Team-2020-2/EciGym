import React from 'react';
import SignIn from './SignIn';
import SignUp from './SignUp';

function Autenticacion() {
    return (
        <div className="container register auction-image">
          <div className="container register">
            <ul className="nav nav-tabs nav-justified" id="myTab" role="tablist">
              <li className="nav-item">
                <a className="nav-link" id="home-tab" data-toggle="tab" href="#TabSignIn" role="tab" aria-controls="home" aria-selected="false">Ingresar</a>
              </li>
              <li className="nav-item">
                <a className="nav-link active" id="profile-tab" data-toggle="tab" href="#TabSignUp" role="tab" aria-controls="profile" aria-selected="true">Registrarse</a>
              </li>
            </ul>
            <div className="tab-content" id="myTabContent">
              <div className="tab-pane fade" id="TabSignIn" role="tabpanel" aria-labelledby="home-tab">
                <SignIn></SignIn>
              </div>
              <div class="tab-pane fade show active" id="TabSignUp" role="tabpanel" aria-labelledby="profile-tab">
                <SignUp></SignUp>
              </div>
            </div>
          </div>
        </div>
      );
}

export default Autenticacion;