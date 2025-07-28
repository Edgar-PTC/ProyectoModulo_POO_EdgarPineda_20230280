package EdgarPineda_20230280.EdgarPineda_20230280.Controllers;

import EdgarPineda_20230280.EdgarPineda_20230280.Models.DTO.ProveedoresDTO;
import EdgarPineda_20230280.EdgarPineda_20230280.Services.ProveedoresService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
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

    //EndPoint para buscar por ID
    @GetMapping("/getidProveedores/{id}")
    public ProveedoresDTO buscarporID(@PathVariable Long id){
        return service.buscarporID(id);
    }

    //Endpoint para la peticion Post
    @PostMapping("/postProveedores")
    public ResponseEntity<?> NuevoProveedores(@Valid @RequestBody ProveedoresDTO json, HttpServletRequest request){
        try{
            ProveedoresDTO respuesta = service.insertarProveedor(json);
            if (respuesta == null){
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "Insercion fallida",
                        "errorType", "VALIDATION_ERROR",
                        "message", "Los datos no se pudieron insertar"
                ));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status", "success",
                    "data", respuesta
            ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "error",
                    "message", "error no controlado al registrar nuevo Proveedor",
                    "detail", e.toString(),
                    "stackTrace", Arrays.toString(e.getStackTrace())
            ));
        }
    }

    //Endpoint para PUT
    @PutMapping("/putProveedores/{id}")
    public ResponseEntity<?> ActualizarProveedor(@PathVariable long id, @Valid @RequestBody ProveedoresDTO dto, HttpServletRequest request){
        try{
            ProveedoresDTO respuesta = service.actualizarProveedor(id, dto);
            if (respuesta == null){
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "Actualizacion fallida",
                        "errorType", "VALIDATION_ERROR",
                        "message", "Los datos no se pudieron Actualizar"
                ));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status", "success",
                    "data", respuesta
            ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "error",
                    "message", "error no controlado al actualizar un Proveedor",
                    "detail", e.toString(),
                    "stackTrace", Arrays.toString(e.getStackTrace())
            ));
        }
    }
}
