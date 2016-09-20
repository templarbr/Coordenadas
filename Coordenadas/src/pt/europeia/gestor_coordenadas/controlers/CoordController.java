package pt.europeia.gestor_coordenadas.controlers;


import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CoordController implements MapComponentInitializedListener {
	
	@FXML
	private TextField nomeTF;
	@FXML
	private TextField coordxTF;
	@FXML
	private TextField coordyTF;
	@FXML
	private TextField nivelTF;
	@FXML
	private TextField dataTF;
	@FXML
	private TextField resultsTF;
	
	@FXML
	private ComboBox<String> tipoCB;
	@FXML
	private ComboBox<String> contarCB;
	
	@FXML
	private ListView<Object> eventosLV;
	
	@FXML
	private void initialize(){
		googleMapsInit();

	}
	


	@FXML
	private void gravar() {
	
	}
	@FXML
	private void apagar() {
	
	}
	@FXML
	private void media() {
	
	}
	@FXML
	private void contar() {
	
	}
	@FXML
	private void distancia() {
	
	}
	@FXML
	private void editar() {
	
	}
	@FXML
	private void ordenarData() {
	
	}
	
	@FXML
	private void ordenarTipoNivel() {
	
	}
	
	
	
	// PARA O MAPA
	
	@FXML
	private AnchorPane mapPlace;
	
	protected GoogleMapView mapComponent;
    protected GoogleMap map;
	
	
	private ObservableList<Marker> markers;
	
	private void googleMapsInit() {
		markers = FXCollections.observableArrayList();
		mapComponent = new GoogleMapView();
		mapComponent.addMapInializedListener(this);
	}
		
	@Override
	public void mapInitialized() {
		LatLong center = new LatLong(47.606189, -122.335842);
		MapOptions options = new MapOptions();
        options.center(center)
                .mapMarker(true)
                .zoom(9)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .mapType(MapTypeIdEnum.TERRAIN);
		map = mapComponent.createMap(options);
		mapComponent.setPrefSize(500, 250);
		
		mapPlace.getChildren().add(mapComponent);
		
	}
	
	
	private void addMarker(double x, double y, String name) {
		  //Add a marker to the map
	    MarkerOptions markerOptions = new MarkerOptions();

	    markerOptions.position( new LatLong(x, y) )
	                .visible(Boolean.TRUE)
	                .title(name);

	    
        Marker marker = new Marker( markerOptions );
        
        markers.add(marker);
        
	    map.addMarker(marker);
	}
	
	private void remMarker(int pos) {
		map.removeMarker(markers.get(pos));
		markers.remove(pos);
	}
	
}
