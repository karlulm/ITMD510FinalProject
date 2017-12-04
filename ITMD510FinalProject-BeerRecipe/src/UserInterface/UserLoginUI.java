package UserInterface;

import java.sql.Connection;
import connections.Connector;
import connections.StartUpCheck;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import user.Login;

public class UserLoginUI  extends Application{
	
	
	static Connector myConnector = new Connector();		
	static Connection conn = myConnector.OpenConnection();
	
	
	public static void main(String[] args) {


		StartUpCheck newStart = new StartUpCheck();
		
		newStart.StartUp(conn); //runs before first run of the software to make sure all tables are set up and working.
		
		launch(args);
		
		 myConnector.Close(conn);
		
	}
	
	@Override
	public void start(Stage primaryStage ) {
		
		primaryStage.setTitle("BeerReciieLogin");
        
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10,50,50,50));
        
        //Adding HBox
        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));
        
        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(0,0,0,0));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
       //Implementing Nodes for GridPane
        Label lblUserName = new Label("Username");
        final TextField txtUserName = new TextField();
        Label lblPassword = new Label("Password");
        final PasswordField pf = new PasswordField();
        Button btnLogin = new Button("Login");
        final Label lblMessage = new Label();
        
        Button btnCreateNewUser = new Button("Create New Account");
        Button btnExit = new Button("Exit");

        
        //Adding Nodes to GridPane layout
        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(btnLogin, 2, 1);
        gridPane.add(lblMessage, 1, 2);
        
        gridPane.add(btnCreateNewUser, 1, 3);
        gridPane.add(btnExit, 2, 3);
        
        //DropShadow effect 
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        
        //Adding text and DropShadow effect to it
        Text text = new Text("Beer Recipie");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 75));
        text.setEffect(dropShadow);
        
        //Adding text to HBox
        hb.getChildren().add(text);
                          
        //Add ID's to Nodes
        bp.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        btnCreateNewUser.setId("btnLogin"); //gave the cool colors
        text.setId("text");
        btnExit.setId("btnExit");
                
        //Action for btnLogin
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {        	 
        	 
     		Login newLogin = new Login();
     		
    		Boolean valid = newLogin.isValidPassowrd(txtUserName.getText().toString(), pf.getText().toString()  , conn);
        	 
    		
        	 if(valid == true){
                 lblMessage.setText("Congratulations! You logged in!");
                 lblMessage.setTextFill(Color.GREEN);
                 
                 myConnector.Close(conn);
                 
                }
             else{
                 lblMessage.setText("Incorrect user or pw.");
                 lblMessage.setTextFill(Color.RED);
                 
                 myConnector.Close(conn);
                 
             } 
         }
         });
        
        //Action for btnExit
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {     
        		
        		Platform.exit();
        	}
        });
        
        
        
        
        //Add HBox and GridPane layout to BorderPane Layout
        bp.setTop(hb);
        bp.setCenter(gridPane);  
        
        //Adding BorderPane to the scene and loading CSS
        Scene scene = new Scene(bp);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.titleProperty().bind(
             scene.widthProperty().asString().
             concat(" : ").
             concat(scene.heightProperty().asString()));
        
        //Action for btnCreateNewUser
        btnCreateNewUser.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {         		
        		
        		BorderPane bp2 = new BorderPane();
                bp2.setPadding(new Insets(10,50,50,50));
                
                //Adding HBox
                HBox hb2 = new HBox();
                hb2.setPadding(new Insets(20,20,20,20));
                
                //Adding GridPane
                GridPane gridPane2 = new GridPane();
                gridPane2.setPadding(new Insets(20,20,20,20));
                gridPane2.setHgap(5);
                gridPane2.setVgap(5);
                
               //Implementing Nodes for GridPane
                Label lblNewUserName = new Label("New User Name");
                final TextField txtUserName = new TextField();
                final Label lblUserNameError = new Label();
                
                Label lblNewFirstName = new Label("First Name");                
                final TextField txtFirstName = new TextField();
                final Label lblFirstNameError= new Label();
                
                Label lblNewLastName = new Label("Last Name");                
                final TextField txtLastName = new TextField();
                final Label lblLastNameError = new Label();
                
                Label lblEmail = new Label("Email");                
                final TextField txtEmail = new TextField();
                
                Label lblPassword1 = new Label("Password");
                final PasswordField pf1 = new PasswordField();
                final Label lblPasswordError = new Label();

                Label lblPassword2 = new Label("Password");
                final PasswordField pf2 = new PasswordField();

                
                Button btnSubmit = new Button("Submit");
                Button btnCancel = new Button("Cancel");

                

                final Label lblMessage = new Label();
                
                //Adding Nodes to GridPane layout
                gridPane2.add(lblNewUserName, 0, 0);
                gridPane2.add(txtUserName, 1, 0);
                gridPane2.add(lblUserNameError, 2, 0);
                
                
                gridPane2.add(lblNewFirstName, 0, 1);
                gridPane2.add(txtFirstName, 1, 1);
                gridPane2.add(lblFirstNameError, 2, 1);
                
                gridPane2.add(lblNewLastName, 0, 2);
                gridPane2.add(txtLastName, 1, 2);
                gridPane2.add(lblLastNameError, 2, 2);                
                
                gridPane2.add(lblEmail, 0, 3);
                gridPane2.add(txtEmail, 1, 3);
                
                gridPane2.add(lblPassword1, 0, 4);
                gridPane2.add(pf1, 1, 4);
                gridPane2.add(lblPasswordError, 2, 4);
                
                gridPane2.add(lblPassword2, 0, 5);
                gridPane2.add(pf2, 1, 5);      
                
                gridPane2.add(btnSubmit, 1, 6);
                gridPane2.add(btnCancel, 1, 7);
                
                //DropShadow effect 
                DropShadow dropShadow2 = new DropShadow();
                dropShadow2.setOffsetX(5);
                dropShadow2.setOffsetY(5);
                
                //Adding text and DropShadow effect to it
                Text text2 = new Text("Create New User");
                text2.setFont(Font.font("Courier New", FontWeight.BOLD, 45));
                text2.setEffect(dropShadow);
                
                //Adding text to HBox
                hb2.getChildren().add(text2);
                                  
                //Add ID's to Nodes
                bp2.setId("bp");
                gridPane2.setId("root");;
                text2.setId("text");
                        
                //Add HBox and GridPane layout to BorderPane Layout
                bp2.setTop(hb2);
                bp2.setCenter(gridPane2);  
                btnSubmit.setId("btnLogin");
                btnCancel.setId("btnCancel");
                
                //Adding BorderPane to the scene and loading CSS
                Scene scene2 = new Scene(bp2);
                scene2.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
                primaryStage.setScene(scene2);
                primaryStage.titleProperty().bind(
                         scene2.widthProperty().asString().
                         concat(" : ").
                         concat(scene2.heightProperty().asString()));
                
                
                btnCancel.setOnAction(new EventHandler<ActionEvent>() {
                	public void handle(ActionEvent event) {  
                		
                		
                		
                        lblMessage.setText("Incorrect user or pw.");
                        lblMessage.setTextFill(Color.RED);
                		
                		
                	}
                });
                
                
                
                
                
                lblMessage.setText("Incorrect user or pw.");
                lblMessage.setTextFill(Color.RED);
                
                
                
                
                
                
                
                //Action for btnCancel
                btnCancel.setOnAction(new EventHandler<ActionEvent>() {
                	public void handle(ActionEvent event) {     
                		
                		primaryStage.setScene(scene);

                	}
                });
             }
         });

        
        
     //primaryStage.setResizable(false);
     primaryStage.show();
    }

}
