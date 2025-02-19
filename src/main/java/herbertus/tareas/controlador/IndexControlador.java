package herbertus.tareas.controlador;

import herbertus.tareas.modelo.Tarea;
import herbertus.tareas.servicio.TareaServicio;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;

@Component
public class IndexControlador implements Initializable {
    private static final Logger logger =
            LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    private TareaServicio tareaServicio;

    @FXML
    private TableView<Tarea> tTarea;

    @FXML
    private TableColumn<Tarea, Integer> tTareaId;

    @FXML
    private TableColumn<Tarea, String> tTareaNombre;

    @FXML
    private TableColumn<Tarea, String> tTareaResponsable;

    @FXML
    private TableColumn<Tarea, String> tTareaEstatus;

    private final ObservableList<Tarea> tareaList =
            FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tTarea.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        configurarColumnas();
        listarTareas();
    }

    private void configurarColumnas(){
        tTareaId.setCellValueFactory(new PropertyValueFactory<>("idTarea"));
        tTareaNombre.setCellValueFactory(new PropertyValueFactory<>("nombreTarea"));
        tTareaResponsable.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        tTareaEstatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void listarTareas(){
        logger.info("ejecutando listado de tareas");
        tareaList.clear();
        tareaList.addAll(tareaServicio.listarTareas());
        tTarea.setItems(tareaList);
    }
}
