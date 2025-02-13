package herbertus.tareas.repositorio;

import herbertus.tareas.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepositorio extends JpaRepository <Tarea, Integer> {
}
