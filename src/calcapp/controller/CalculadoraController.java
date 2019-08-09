/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcapp.controller;

import calcapp.model.Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author drink
 */
public class CalculadoraController implements Initializable {

    @FXML
    private Insets x1;
    @FXML
    private Label lblResultado;
    
    private double numero1;
    private String operador;
    private boolean start;
    private Model model;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.numero1 = 0L;
        this.operador = "";
        this.start = true;
        this.model = new Model();               
    }    

    @FXML
    private void processaNumero(ActionEvent event) {
        if (start) {
            lblResultado.setText("");
            start = false;
        }
        String v = ((Button)event.getSource()).getText();
        lblResultado.setText(lblResultado.getText()+v);
    }

    @FXML
    private void processaOperador(ActionEvent event) {
        String v = ((Button)event.getSource()).getText();
        if (!v.equals("=")) {
            if (!operador.isEmpty()){
                return;
            }            
            operador = v;
            numero1 = Double.parseDouble(this.lblResultado.getText());
            lblResultado.setText("");
        } else {
            if (operador.isEmpty()){
                return;
            }
            double numero2 = Double.parseDouble(this.lblResultado.getText());
            double resultado = model.calcular(numero1, numero2, this.operador);
            lblResultado.setText(String.valueOf(resultado));
            this.operador = "";
            this.start = true;
        }
    }
    
}
