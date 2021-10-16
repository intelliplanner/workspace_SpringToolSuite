package com.ipssi.ppgcl.rfid.main;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipssi.ppgcl.rfid.uiConstant.ScreenConstant;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

@SpringBootApplication
public class JavaFxApplication extends Application {

	public JFXTextField testBoxUserName;
	public JFXPasswordField testBoxPassword;
	public Label labelError;
	private JFXButton buttonLogin;
	Scene scene;
	Stage mainStag;

	public static void main(String[] args) {
		Application.launch();
	}

	@Override
	public void init() {
		SpringApplication.run(getClass()).getAutowireCapableBeanFactory().autowireBean(this);
	}

	@Override
	public void start(final Stage initStage) throws Exception {
		try {
			showMainStage(initStage);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void showMainStage(Stage initStage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ScreenConstant.ScreenLinks.LOGIN_WINDOW));
		Parent root = fxmlLoader.load();
//		mainController = fxmlLoader.getController();
		scene = new Scene(root);
		initStage.setScene(scene);
//		mainController.init(this);
		Image icon = new Image(getClass().getResourceAsStream("loginScreenLogo.png"));
		initStage.getIcons().add(icon);

//		initStage.setTitle("CGPL Desktop Manager " + ScreenConstant.VERSION);
		initStage.setMaximized(true);
		initStage.show();
//		if (mainController != null)
//			mainController.registerIdleMonitor();

	}

}