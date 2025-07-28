package EdgarPineda_20230280.EdgarPineda_20230280.Services;

import EdgarPineda_20230280.EdgarPineda_20230280.Entities.ProveedoresEntity;
import EdgarPineda_20230280.EdgarPineda_20230280.Exceptions.ExceptionProveedorNoActualizado;
import EdgarPineda_20230280.EdgarPineda_20230280.Exceptions.ExceptionProveedorNoAgregado;
import EdgarPineda_20230280.EdgarPineda_20230280.Exceptions.ExceptionValoresVaciosUpdate;
import EdgarPineda_20230280.EdgarPineda_20230280.Models.DTO.ProveedoresDTO;
import EdgarPineda_20230280.EdgarPineda_20230280.Repositories.ProveedoresRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProveedoresService {

    //Inyectar el Repository en Service
    @Autowired
    private ProveedoresRepository repo;

    private ProveedoresEntity convertirAEntity(ProveedoresDTO dto){
        ProveedoresEntity entity = new ProveedoresEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setTelefono(dto.getTelefono());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        entity.setCode(dto.getCode());
        entity.setStatus(dto.getStatus());
        entity.setComment(dto.getComment());
        return entity;
    }

    private ProveedoresDTO convertirADTO(ProveedoresEntity entity){
        ProveedoresDTO dto = new ProveedoresDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setTelefono(entity.getTelefono());
        dto.setAddress(entity.getAddress());
        dto.setEmail(entity.getEmail());
        dto.setCode(entity.getCode());
        dto.setStatus(entity.getStatus());
        dto.setComment(entity.getComment());
        return dto;
    }

    //Funcion para buscar Proveedores
    public List<ProveedoresDTO> getProveedores() {
        List<ProveedoresEntity> proveedores = repo.findAll();
        return proveedores.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    //Funcion para buscar filtrado
    public ProveedoresDTO buscarporID(Long id){
        ProveedoresEntity entity = repo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el proveedor"));

        return convertirADTO(entity);
    }

    public ProveedoresDTO insertarProveedor(@Valid ProveedoresDTO json) {
        if(json == null || json.getNombre() == null || json.getCode() == null || json.getEmail() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Los campos nombre, codigo y email no deben estar vacio");
        }
        try{
            ProveedoresEntity entity = convertirAEntity(json);
            ProveedoresEntity respuesta = repo.save(entity);
            return convertirADTO(respuesta);
        } catch (Exception e){
            log.error("Error al registrar el nuevo proyecto: " + e.getMessage());
            throw new ExceptionProveedorNoAgregado("Error al registrar el nuevo proyecto");
        }
    }

    public ProveedoresDTO actualizarProveedor(long id, @Valid ProveedoresDTO dto) {
        ProveedoresEntity entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario No encontrado"));

        if (dto == null || dto.getNombre() == null || dto.getTelefono() == null || dto.getEmail() == null || dto.getAddress() == null || dto.getCode() == null || dto.getComment() == null || dto.getStatus() == null){
            throw new ExceptionValoresVaciosUpdate("Hay campos vacios en el metodo Update");
        }

        try {
            entity.setNombre(dto.getNombre());
            entity.setTelefono(dto.getTelefono());
            entity.setAddress(dto.getAddress());
            entity.setEmail(dto.getEmail());
            entity.setCode(dto.getCode());
            entity.setStatus(dto.getStatus());
            entity.setComment(dto.getComment());
            ProveedoresEntity respuesta = repo.save(entity);
            return convertirADTO(respuesta);
        }catch (Exception e){
            log.error("Error al actualizar el registro: " + e.getMessage());
            throw new ExceptionProveedorNoActualizado("Error al actualizar el proveedor");
        }
    }
}
