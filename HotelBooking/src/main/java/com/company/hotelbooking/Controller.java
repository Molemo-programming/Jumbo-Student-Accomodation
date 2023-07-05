package com.company.hotelbooking;

import com.company.dao.Booking;
import com.company.dao.BookingDAO;
import com.company.dao.Customer;
import com.company.dao.Payment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.DialogPane;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

    @FXML
    private AnchorPane pnBank;
    @FXML
    private Label Mc, Menu;

    @FXML
    private Label lblExit, lblFull;

    @FXML
    private AnchorPane pnB, imgGarden, imgRest, imgWedding, imgWelcome, pnHome;

    Stage stage = null;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField email;
    @FXML
    private TextField contact;
    @FXML
    private TextField guest;
    @FXML
    private TextField adrs;
    @FXML
    private TextField card;
    @FXML
    private TextField card_num;
    @FXML
    private TextField s_code;
    @FXML
    private TextField card_name;
    @FXML
    private DatePicker cin;
    @FXML
    private DatePicker cout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lblExit.setOnMouseClicked(event -> System.exit(0));

        Slideshow();
        MenuAni();
        FullScreen();
    }

    private void Slideshow() {

        FadeTransition fade = new FadeTransition(Duration.seconds(3), imgWelcome);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();

        fade.setOnFinished(event -> {

            FadeTransition fade1 = new FadeTransition(Duration.seconds(3), imgGarden);
            fade1.setFromValue(1);
            fade1.setToValue(0);
            fade1.play();

            fade1.setOnFinished(event1 -> {

                FadeTransition fade2 = new FadeTransition(Duration.seconds(3), imgWedding);
                fade2.setFromValue(1);
                fade2.setToValue(0);
                fade2.play();

                fade2.setOnFinished(event2 -> {

                    FadeTransition fade3 = new FadeTransition(Duration.seconds(3), imgRest);
                    fade3.setFromValue(1);
                    fade3.setToValue(0);
                    fade3.play();

                    fade3.setOnFinished(event3 -> {

                        FadeTransition fade4 = new FadeTransition(Duration.seconds(3), imgRest);
                        fade4.setFromValue(0);
                        fade4.setToValue(1);
                        fade4.play();

                        fade4.setOnFinished(event4 -> {

                            FadeTransition fade5 = new FadeTransition(Duration.seconds(3), imgWedding);
                            fade5.setFromValue(0);
                            fade5.setToValue(1);
                            fade5.play();

                            fade5.setOnFinished(event5 -> {

                                FadeTransition fade6 = new FadeTransition(Duration.seconds(3), imgGarden);
                                fade6.setFromValue(0);
                                fade6.setToValue(1);
                                fade6.play();

                                fade6.setOnFinished(event6 -> {

                                    FadeTransition fade7 = new FadeTransition(Duration.seconds(3), imgWelcome);
                                    fade7.setFromValue(0);
                                    fade7.setToValue(1);
                                    fade7.play();

                                    fade7.setOnFinished(event7 -> Slideshow());
                                });
                            });
                        });
                    });
                });

            });

        });

    }

    private void MenuAni() {

        pnB.setTranslateX(-176);
        Menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(pnB);

            slide.setToX(0);
            slide.play();

            pnB.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(false);
                Mc.setVisible(true);
            });
        });

        Mc.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(pnB);

            slide.setToX(-176);
            slide.play();

            pnB.setTranslateX(0);

            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(true);
                Mc.setVisible(false);
            });
        });

    }

    private void FullScreen() {
        lblFull.setOnMouseClicked(event -> {
            stage = (Stage) pnHome.getScene().getWindow();
            if (stage.isMaximized()) {
                stage.setMaximized(false);
            } else {
                stage.setMaximized(true);
            }
        });
    }

    public void btnHome(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        String css = this.getClass().getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void btnBookin(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Booking.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        String css = this.getClass().getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void btnGallery(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Bank.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        String css = this.getClass().getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void btnAbout(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("About.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        String css = this.getClass().getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    private Customer customer;
    private String cn;

    public void btnSubmit(ActionEvent event) throws IOException {

        String fname = name.getText();
        String lname = surname.getText();
        String em = email.getText();
        String con = contact.getText();
        String address = adrs.getText();
        cn = card.getText();
        customer = new Customer(fname, lname, em, con, address);
        if (BookingDAO.addCustomer(customer)) {
            String checkin = cin.getValue().toString();
            String checkout = cout.getValue().toString();
            LocalDate cinDate = cin.getValue();
            LocalDate coutDate = cout.getValue();
            int guestNum = Integer.parseInt(guest.getText());
            int overdueDays = (int) ChronoUnit.DAYS.between(cinDate, coutDate);
            if (BookingDAO.Book(new Booking(em, checkin, checkout, guestNum, overdueDays * 1500))) {

                FileWriter writer = new FileWriter("detail.txt");
                try ( BufferedWriter buffer = new BufferedWriter(writer)) {
                    buffer.write(em + "#" + cn);
                   
                }
                System.out.println("Success");
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Bank.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                String css = this.getClass().getResource("Style.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();

            } else {
                System.out.println("failure");
            }
        } else {
            System.out.println("error");
        }
//        JOptionPane.showMessageDialog(null,"Hello, Welcome to Javatpoint.");  
    }

    public void btnCancel(ActionEvent event) {

        // stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.close();
    }

    //Payment code
    public void btnCard(ActionEvent event) throws IOException {
        FileReader fr = new FileReader("detail.txt");
        
        BufferedReader br = new BufferedReader(fr);
        String[] det = br.readLine().split("#");
        int cardNo = Integer.parseInt(card_num.getText());
        String em = det[0];
        int code = Integer.parseInt(s_code.getText());
        String holderName = card_name.getText();
        if (cardNo == Integer.parseInt(det[1])) {
            if (BookingDAO.addCard(new Payment(cardNo, em, code, holderName))) {
                System.out.println("card accepted");
                File f = new File("C:\\Users\\Sbani\\Documents\\NetBeansProjects\\HotelBooking\\detail.txt");
                if (f.delete()) {
                    System.out.println("deleted");
                } else {
                    System.out.println("err");
                }
                //success
            } else {
                //failed
                System.out.println("card failed");
            }
        } else {
            //card num in booking and payment do mot match
            System.out.println("incorrect card num");
        }

    }

}
