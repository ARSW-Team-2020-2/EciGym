import React from 'react';

function Subasta() {
    return (

      

        <div id="agregarSubasta" className="modal fade" aria-hidden="true">

            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        <h4 className="modal-title">Ingresa los detalles del artículo</h4>
                        <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div className="modal-body">
                        <form>
                            <div className="form-group">
                                <label className="col-form-label">Nombre:</label>
                                <input type="text" className="form-control" id="nobreArticulo"></input>
                            </div>

                            <div className="form-group">
                                <label className="col-form-label">Descripción:</label>
                                <input type="text" className="form-control" id="desArticulo"></input>
                            </div>

                            <div className="form-group">
                                <label className="col-form-label">Fecha fin de la oferta:</label>
                                <input type="date" className="form-control" id="fechaFin"></input>
                            </div>

                            <div className="form-group">
                                <div className="form-field">
                                    <div className="select-wrap">
                                        <div className="icon"><span className="fa fa-chevron-down"></span></div>
                                        <select id="estadoDeuso" className="form-control">
                                            <option value="" className="option-color">Estado de uso</option>
                                            <option value="" className="option-color">Nuevo</option>
                                            <option value="" className="option-color">Usado</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div className="form-group">
                                <label className="col-form-label">Precio mínimo de la orferta:</label>
                                <input type="text" className="form-control" id="precioBase"></input>
                            </div>

                            <div className="form-group">
                                <label className="col-form-label">Dimensiones:</label>
                                <input type="text" className="form-control" id="dimensiones"></input>
                            </div>

                            <div className="form-group">
                                <label className="col-form-label">Tu ubicación:</label>
                                <input type="text" className="form-control" id="ubicacion"></input>
                            </div>

                            <div className="form-group">
                                <label className="col-form-label">Imagen:</label>
                                <input type="text" className="form-control" id="imagen"></input>
                            </div>

                        </form>
                    </div>

                    <div className="modal-footer">
                        <button type="button" className="btn btn-primary">Agregar</button>
                    </div>
                </div>
            </div>
        </div>
 

    );

}

export default Subasta;