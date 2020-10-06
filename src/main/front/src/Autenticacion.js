import React from 'react';
import SignIn from './SignIn';
import SignUp from './SignUp';

function Autenticacion() {
    return (
      <div id = "autenticacion" className="container mt-5">
        <div className="container register auction-image">
          <div className="container register mt-4">
            <ul className="nav nav-tabs nav-justified" id="myTab" role="tablist">
              <li className="nav-item">
                <a className="nav-link" id="home-tab" data-toggle="tab" href="#TabSignIn" role="tab" aria-controls="home" aria-selected="false">Ingresa</a>
              </li>
              <li className="nav-item">
                <a className="nav-link active" id="profile-tab" data-toggle="tab" href="#TabSignUp" role="tab" aria-controls="profile" aria-selected="true">Regístrate</a>
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
        </div>
      );
}

export default Autenticacion;