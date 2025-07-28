package EdgarPineda_20230280.EdgarPineda_20230280;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@SpringBootApplication
public class ProyectoModuloEdgarPineda2023028Application {

	public static void main(String[] args) {
		//Conexion para buscar la informacion de BD
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry ->
			System.setProperty(entry.getKey(), entry.getValue())
		);

		SpringApplication.run(ProyectoModuloEdgarPineda2023028Application.class, args);
	}

}
