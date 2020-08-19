package com.pooespol.appmillionarie;

import com.pooespol.appmillionarie.modelo.TerminoAcademico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class SecondaryController {
    ArrayList<TerminoAcademico> terminosAc;
    //ArrayList<TerminoAcademico> terserializado;
    @FXML
    TableView losterminos;
    @FXML
    private TableColumn<TerminoAcademico, String> colaño;
    @FXML
    private TableColumn<TerminoAcademico, String> colnumero;
    @FXML
    Label labelterminos;
    String[] numerTermino= {"1","2","3"};
    @FXML
    ComboBox cmbNumerosTerm;
    @FXML
    TextField textoaño;
    @FXML
    Button btningresartermino;
    /*
    @FXML
    FlowPane cambiaflow;
    @FXML
    VBox estableceVbox;
    */
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    public SecondaryController(){
        cargarTerminos();
    }
    
    private void cargarTerminos() {
        terminosAc = new ArrayList<>();
      
        /*BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/resources/com/pooespol/appmillionarie/files/personas.csv"));

            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                String[] datos = line.split(";");
                TerminoAcademico ter = new TerminoAcademico(datos[0],datos[1]);
                System.out.println("Termino" + ter);
                terminosAc.add(ter);
                line = br.readLine();
            }
        

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        */
        FileInputStream entroaterminos = null;
        try{
            entroaterminos= new FileInputStream(App.pathTerminosAc);
            ObjectInputStream term = new ObjectInputStream(entroaterminos);
            terminosAc= (ArrayList<TerminoAcademico>)term.readObject();
            System.out.println(terminosAc);
        }catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (entroaterminos != null) {
                    entroaterminos.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        
    
    
        
        
    }

    @FXML
    private void initialize() {
        //cmbEstado.getItems().setAll(EstadoCivil.values());

        colaño.setCellValueFactory(new PropertyValueFactory<>("year"));
        colnumero.setCellValueFactory(new PropertyValueFactory<>("numeroTermino"));
        

        losterminos.getItems().setAll(terminosAc);
        cmbNumerosTerm.getItems().setAll(numerTermino);
    }
    
    @FXML
    public void llenaCombo(String[] numerTermino ){
        cmbNumerosTerm.getItems().setAll(numerTermino);
    }
    
    @FXML
    public void ingresarTermino(){
        System.out.println("Guardando Termino Academico");
        TerminoAcademico ta= new TerminoAcademico(textoaño.getText(), (String) cmbNumerosTerm.getValue());
        terminosAc.add(ta);
        //System.out.println("Nuevo Termino: "+ta); //me agrega a la lista pero no al archivo
     
        FileOutputStream listaout= null;
        try{
        listaout= new FileOutputStream(App.pathTerminosAc);  //en el archivo que indica la ruta voy a guardar el archivo serializado
        ObjectOutputStream objlista = new ObjectOutputStream(listaout); //serializo la lista
        objlista.writeObject(terminosAc); //escribo la lista en el archivo
        objlista.flush();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operacion");
            alert.setContentText("Nuevp termino agregado exitosamente");

            alert.showAndWait();
            App.setRoot("secondary");
        
        
        }catch(IOException ex){
            ex.printStackTrace();
            System.out.println("IOException:" + ex.getMessage());
        }finally{
            try{
                listaout.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        
    }



    
}