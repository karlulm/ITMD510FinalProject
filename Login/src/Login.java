import javafx.application.Application;
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
 
/**
 *
 * @web http://zoranpavlovic.blogspot.com/
 */
public class Login extends Application {
	
	 String user = "JavaFX2";
	 
	 String pw = "password";
	 
	 	 String checkUser, checkPw;
 
    public static void main(String[] args) {
        launch(args);
    }
     
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("BeerRecipie");
        
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10,50,50,50));
        
        //Adding HBox
        HBox hb = new HBox();
        hb.setPadding(new Insets(10,20,20,30));
        
        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
       //Implementing Nodes for GridPane
        Label lblUserName = new Label("Username");
        final TextField txtUserName = new TextField();
        Label lblPassword = new Label("Password");
        final PasswordField pf = new PasswordField();
        Button btnLogin = new Button("Login");
        final Label lblMessage = new Label();
        
        Button btnCreateNewAccount = new Button("Create New Account");

        
        //Adding Nodes to GridPane layout
        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(btnLogin, 2, 1);
        gridPane.add(lblMessage, 1, 2);
        
        gridPane.add(btnCreateNewAccount, 1, 4);
        
        
        //DropShadow effect 
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        
        //Adding text and DropShadow effect to it
        Text text = new Text("BeerRecipie Login");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 50));
        text.setEffect(dropShadow);
        
        //Adding text to HBox
        hb.getChildren().add(text);
                          
        //Add ID's to Nodes
        bp.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        btnCreateNewAccount.setId("btnLogin");
        text.setId("text");
                
        
        
        //Action for btnLogin
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
        	 
          checkUser = txtUserName.getText().toString();
          checkPw = pf.getText().toString();
          
          if(checkUser.equals(user) && checkPw.equals(pw)){
           lblMessage.setText("Congratulations!");
           lblMessage.setTextFill(Color.GREEN);
          }
          else{
           lblMessage.setText("Incorrect user or pw.");
           lblMessage.setTextFill(Color.RED);
          }
          txtUserName.setText("");
          pf.setText("");
         }
         });
         
        
        //Action for btnCreateNewAccount (Create New Account)
        btnCreateNewAccount.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	
            	Stage createAccountStage;
            	
                BorderPane bp2 = new BorderPane();
                bp2.setPadding(new Insets(10,50,50,50));
                
                //Adding HBox
                HBox hb2 = new HBox();
                hb2.setPadding(new Insets(10,20,20,30));
                
                //Implementing Nodes for GridPane
                Label lblFirstName = new Label("First Name");
                final TextField txtFirstName = new TextField();
                Label lblLastName = new Label("Last Name");
                final PasswordField pf2 = new PasswordField();
                Label lblUserName2 = new Label("UserName");
                final TextField txtUserName2 = new TextField();
                Label lblPassword2 = new Label("Last Name");
                final PasswordField pf2 = new PasswordField();
                Label lblUserName2 = new Label("First Name");
                final TextField txtUserName2 = new TextField();
                Label lblPassword2 = new Label("Last Name");
                final PasswordField pf2 = new PasswordField();
                
                
                
                
                
                Button btnLogin2 = new Button("Create Account");
                final Label lblMessage2 = new Label();
                
                //Adding GridPane
                GridPane gridPane2 = new GridPane();
                gridPane2.setPadding(new Insets(10,20,20,20));
                gridPane2.setHgap(5);
                gridPane2.setVgap(5);
            	
                //Adding Nodes to GridPane layout
                gridPane2.add(lblUserName2, 0, 0);
                gridPane2.add(txtUserName2, 1, 0);
                gridPane2.add(lblPassword2, 0, 1);
                gridPane2.add(pf2, 1, 1);
                gridPane2.add(btnLogin2, 2, 1);
                gridPane2.add(lblMessage2, 1, 2);
                
//                gridPane.add(btnCreateNewAccount2, 1, 4);
                
                DropShadow dropShadow2 = new DropShadow();
                dropShadow2.setOffsetX(5);
                dropShadow2.setOffsetY(5);
                
                //Adding text and DropShadow effect to it
                Text text2 = new Text("Create User");
                text2.setFont(Font.font("Courier New", FontWeight.BOLD, 50));
                text2.setEffect(dropShadow2);
                
                //Adding text to HBox
                hb2.getChildren().add(text2);
                                  
                //Add ID's to Nodes
                bp2.setId("bp");
                gridPane2.setId("root");
                btnLogin2.setId("btnLogin");
//                btnCreateNewAccount2.setId("btnLogin");
                text2.setId("text");
            	
            	
                //Add HBox and GridPane layout to BorderPane Layout
                bp2.setTop(hb2);
                bp2.setCenter(gridPane2);  
                
                //Adding BorderPane to the scene and loading CSS
                Scene scene2 = new Scene(bp2);
                scene2.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
             	primaryStage.setScene(scene2);
             	primaryStage.titleProperty().bind(
                         scene2.widthProperty().asString().
                         concat(" : ").
                         concat(scene2.heightProperty().asString()));
             	//primaryStage.setResizable(false);
             	primaryStage.show();
                
                
                
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
     	//primaryStage.setResizable(false);
     	primaryStage.show();
    }
}
