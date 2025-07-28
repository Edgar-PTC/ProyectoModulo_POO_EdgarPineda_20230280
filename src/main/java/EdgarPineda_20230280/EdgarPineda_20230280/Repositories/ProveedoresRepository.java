package EdgarPineda_20230280.EdgarPineda_20230280.Repositories;

import EdgarPineda_20230280.EdgarPineda_20230280.Entities.ProveedoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedoresRepository extends JpaRepository<ProveedoresEntity, Long> {
}
