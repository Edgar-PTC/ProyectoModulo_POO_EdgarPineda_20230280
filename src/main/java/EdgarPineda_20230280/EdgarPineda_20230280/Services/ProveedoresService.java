package EdgarPineda_20230280.EdgarPineda_20230280.Services;

import EdgarPineda_20230280.EdgarPineda_20230280.Entities.ProveedoresEntity;
import EdgarPineda_20230280.EdgarPineda_20230280.Models.DTO.ProveedoresDTO;
import EdgarPineda_20230280.EdgarPineda_20230280.Repositories.ProveedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

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

    }
}
