import React, {Component} from "react";

class MiComponente extends Component {

    render() {

        let receta = {
            nombre: "Pizza",
            ingredientes: ["Tomate", "Queso", "Jamon"],
            calorias: 500
        }

        return (
            <div className="miComponente">
                <h1>{receta.nombre}</h1>
                <h6>Tom</h6>
                <hr/>
                <ol>
                    {
                        receta.ingredientes.map((ingrediente, i) => {
                            return(
                                <li key={i}>
                                    {ingrediente}
                                </li>
                            )
                        })
                    }
                </ol>

            </div>
        );
    }

}

export default MiComponente;
