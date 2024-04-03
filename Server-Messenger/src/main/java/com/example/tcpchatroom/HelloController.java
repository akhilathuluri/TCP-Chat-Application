package com.example.tcpchatroom;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Button button_send;
    @FXML
    private TextField tf_message;
    @FXML
    private VBox vbox_messages;
    @FXML
    private ScrollPane sp_main;

    private Server server;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            server = new Server(new ServerSocket(1234));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error Creating Server");
        }

        vbox_messages.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                sp_main.setVvalue((Double) t1);
            }
        });

        server.receiveMessageFromClient(vbox_messages);

        button_send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String messageToSend = tf_message.getText();
                if (!messageToSend.isEmpty()) {
                    HBox hBox = new HBox();
                    hBox.setAlignment(Pos.CENTER_RIGHT);
                    hBox.setPadding(new Insets(5, 5, 5, 10));

                    Text text = new Text(messageToSend);
                    TextFlow textFlow = new TextFlow(text);

                    textFlow.setStyle("-fx-color: rgb(239,242,255); " +
                            "-fx-background-color: rgb(15,125,242);" +
                            "-fx-background-radius:20px;");

                    textFlow.setPadding(new Insets(5, 10, 5, 10));
                    text.setFill(Color.color(0.934, 0.945, 0.996));

                    hBox.getChildren().add(textFlow);
                    vbox_messages.getChildren().add(hBox);

                    server.sendMessageToClient(messageToSend);
                    tf_message.clear();
                }
            }
        });
    }
    public static void addLabel(String messageFromClient, VBox vbox) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(5, 5, 5, 10));

        Text text = new Text(messageFromClient);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-background-color: rgb(233,233,235);" +
                "-fx-background-radius:20px;");
        textFlow.setPadding(new Insets(5, 5, 5, 10));
        hBox.getChildren().add(textFlow);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vbox.getChildren().add(hBox);
            }
        });
    }
}