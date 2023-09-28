package com.spring.backend.apirest.springbootbackendapirest.model.utilities;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyResponseUtility {

    public Boolean error;
    public String message;
    public Object data;
    public Integer status;
    /**
     * La clase MyResponseUtility es una clase que
     * permite generar un objeto de tipo MyResponse
     */
    public MyResponseUtility() {
        this.error = false;
        this.message = "success";
        this.data = null;
        this.status = 0;
    }

    // este metodo restablece el listado de la peticion
    public void restart() {
        error = false;
        message = "Success";
        data = null;
        status = 0;
    }
}


