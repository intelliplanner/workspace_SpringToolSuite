package com.ipssi.ppgcl.rfid.controllers;

import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ipssi.ppgcl.rfid.repository.RFIDService;
import com.jfoenix.controls.JFXButton;

import net.rgielen.fxweaver.core.FxmlView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

@Component
@FxmlView("login.fxml")
public class LoginController {
	
	@Autowired
	RFIDService rfidService;
	
	@FXML
	private TextField TEXT_USER_NAME;
	@FXML
	private PasswordField TEXT_PASSWORD;
	@FXML
	private JFXButton CONTROL_LOGIN;
	@FXML
	public Label labelError;

	
	@FXML 
	public static AnchorPane TopPane; 

	@FXML
	private JFXButton CONTROL_BLUE;
	@FXML
	private JFXButton CONTROL_RED;
	public void test(ActionEvent actionEvent) {
	    System.out.println("actionEvent");
	}
	@FXML
	private void onControlKeyPress(KeyEvent event) {
		rfidService.saveRfidData("Hello onControlKeyPress");
	}
	@FXML
	private void controlItemClicked(MouseEvent event) {
		System.out.println("hello controlItemClicked");
	}
}
