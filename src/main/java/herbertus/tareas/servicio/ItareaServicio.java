package herbertus.tareas.servicio;

import herbertus.tareas.modelo.Tarea;
import java.util.List;

public interface ItareaServicio {

    public List<Tarea> listarTareas();
    public Tarea buscarTareaPorId(Integer idTarea);
    public void guardarTarea(Tarea tarea); // elimina t actualiza
    public void eliminarTarea(Tarea tarea);
}
