package EdgarPineda_20230280.EdgarPineda_20230280.Controllers;

import EdgarPineda_20230280.EdgarPineda_20230280.Models.DTO.ProveedoresDTO;
import EdgarPineda_20230280.EdgarPineda_20230280.Services.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiProveedores")
public class ProveedoresController {

    //Inyectar el Service en Controller
    @Autowired
    private ProveedoresService service;

    //EndPoint para la peticion get
    @GetMapping("/getProveedores")
    public List<ProveedoresDTO>datosProveedores(){
        //Llama la funcion de service y lo retorna
        return service.getProveedores();
    }
}
