package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.model.Voyage;
import sample.util.voyage_info;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
	@FXML
    private AnchorPane window;

	@FXML
	private TableView<voyage_info> table;

	@FXML
	private TableColumn<voyage_info, String> idBus;

	@FXML
	private TableColumn<voyage_info, String> libellle;

	@FXML
	private TableColumn<voyage_info, String> dateDep;

	@FXML
	private TableColumn<voyage_info, String> Hdeb;

	@FXML
	private TableColumn<voyage_info, String> Harriv;

	@FXML
	private TableColumn<voyage_info, String> Vdep;

	@FXML
	private TableColumn<voyage_info, String> Varriv;

	@FXML
    private Button reserver;

    @FXML
    private Label libaff;

    @FXML
    private Label Hdaff;

    @FXML
    private Label Ddebaff;

    @FXML
    private Label Hdarriv;

    @FXML
    private Label Vdepaff;

    @FXML
    private Label Varrivaff;

    @FXML
    private Label idbus;

	// ObservableList<voyage_info> list = Voyage.list;
    static voyage_info  voy ;
    static String id;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		idBus.setCellValueFactory(new PropertyValueFactory<voyage_info, String>("id_bus"));
		libellle.setCellValueFactory(new PropertyValueFactory<voyage_info, String>("libelle_voyage"));
		Hdeb.setCellValueFactory(new PropertyValueFactory<voyage_info, String>("heure_debut"));
		Harriv.setCellValueFactory(new PropertyValueFactory<voyage_info, String>("heure_fin"));
		dateDep.setCellValueFactory(new PropertyValueFactory<voyage_info, String>("date_deb"));
		Varriv.setCellValueFactory(new PropertyValueFactory<voyage_info, String>("ville_arrive"));
		Vdep.setCellValueFactory(new PropertyValueFactory<voyage_info, String>("ville_depart"));
		if (Voyage.list.isEmpty())
		{
			Alert a = new Alert(Alert.AlertType.NONE);
			a.setAlertType(Alert.AlertType.INFORMATION);
			a.setContentText("There are no travels for those credentials at the moment, please try again later !!");
			// show the dialog
			a.show();
		} else{
		table.setItems(Voyage.list);}
	}
	 @FXML
	    void printvoyage(MouseEvent event) {

			int index = table.getSelectionModel().getFocusedIndex();
			if (index <= -1) {
				return;
			}
			libaff.setText(libellle.getCellData(index));
			Hdaff.setText(Hdeb.getCellData(index));
			Hdarriv.setText(Harriv.getCellData(index));
			Ddebaff.setText(dateDep.getCellData(index));
			Varrivaff.setText(Varriv.getCellData(index));
		    Vdepaff.setText(Vdep.getCellData(index));
			idbus.setText(idBus.getCellData(index));
			voy = new voyage_info(Ddebaff.getText(),idbus.getText(),Hdaff.getText(),Vdepaff.getText(),Varrivaff.getText());

	    }

	    @FXML
	    void reservation(ActionEvent event) throws IOException {
	    	AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/ReservationClient.fxml"));
			window.getChildren().setAll(obj);
	    }

	    @FXML
	    void retourner(ActionEvent event) throws IOException {
	    	AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/ChercherBus.fxml"));
			window.getChildren().setAll(obj);
	    }


}
