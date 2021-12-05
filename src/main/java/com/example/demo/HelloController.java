package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class HelloController {
    public ToolBar toolbar;
    public AnchorPane bg;
    public AnchorPane bg1;
    public Button addstud;
    public Button roll_search;
    public Button m_back;
    public AnchorPane bg5;
    private Stage stage,stage1;
    public String name;
    @FXML
            private TextField add_name,add_rollno,add_div,add_year,add_branch,add_mailid,add_phone;
    String css= Objects.requireNonNull(this.getClass().getResource("/application.css")).toExternalForm();

    @FXML
    private TextField roll_input_search,in_marks_roll,in_marks_name,add_sub,add_sem,add_marks,add_totalMarks;
    @FXML
    private TextField ent_roll,ent_sem;
    @FXML
    private Label lab_name,lab_roll,lab_div,lab_branch,lab_year,lab_sem,total_percent;
   @FXML
   private TableView<marks> tableView;
    @FXML
    private TableColumn<marks,String> col_sub;
    @FXML
    private TableColumn<marks,Integer> col_markscored;
    @FXML
    private TableColumn<marks,Integer> col_totalmarks;
    @FXML
    private TableColumn <marks,Float>col_percent;



    public void switchtoStudent(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("add-stud.fxml"));
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-stud.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root,650,400);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
    public void switchMainScreen(ActionEvent event)throws IOException{
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage1=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root,900,700);
        scene.getStylesheets().add(css);
        stage1.setScene(scene);
        stage1.show();
    }

    public void switchtoMarks(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("add-stud.fxml"));
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-marks.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root,650,400);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
    public void switchtoMarksheet(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("add-stud.fxml"));
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("marksheet.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root,700,550);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void addStudent(ActionEvent event) throws IOException, SQLException {
        DatabaseHelper databaseHelper=new DatabaseHelper();
        Connection connection= databaseHelper.getDbconnect();
        String name=add_name.getText();
        String roll_no=add_rollno.getText();
        String div=add_div.getText();
        Integer year=Integer.parseInt(add_year.getText());
        String branch=add_branch.getText();
        String mail=add_mailid.getText();
        Integer phone=Integer.parseInt(add_phone.getText());
        String f="SET FOREIGN_KEY_CHECKS=0";
        Statement S=connection.createStatement();
        S.execute(f);
        String sql= "INSERT INTO student values ('"+roll_no+" ',' "+name+" ',' "+div+" ',' "+branch+" ',' "+year+" ',' "+mail+" ',' "+phone+" ')";
//        Student student=new Student(name,roll_no,div,branch,year,mail,phone);
        Statement statement=connection.createStatement();
        int b=statement.executeUpdate(sql);
        if(b!=0) {

            TilePane tilePane = new TilePane();
            tilePane.setAlignment(Pos.CENTER);

            Popup popup = new Popup();
            Label label = new Label("Student Added");
            label.setFont(new Font("Arial", 16));
            popup.setAnchorX(300);
            popup.setAnchorY(200);
            popup.getContent().add(label);
            tilePane.getChildren().add(label);
            Stage stage = new Stage();
            Scene scene = new Scene(tilePane, 200, 50);
            stage.setScene(scene);
            stage.show();
            ;
            popup.setAutoHide(true);
            popup.show(stage);
        }


//        if(b==false){
//            Alert alert=new Alert(Alert.AlertType.NONE);
//            alert.setContentText("Student Added");
//            add_name.clear();add_rollno.clear();add_div.clear();add_year.clear();add_branch.clear();add_mailid.clear();add_phone.clear();
//            alert.setOnCloseRequest(alert.getOnShown());
//
//        }else {
//            Alert alert=new Alert(Alert.AlertType.NONE);
//            alert.setContentText("Failed");
//            alert.showAndWait();
//        }


    }

    public void Roll_search(ActionEvent event) throws SQLException {
        DatabaseHelper databaseHelper=new DatabaseHelper();
        Connection connection= databaseHelper.getDbconnect();
        String roll_no=roll_input_search.getText();
        String search_name="SELECT Name FROM student WHERE RollNo=(' "+roll_no+" ')";
        Statement statement=connection.createStatement();
        ResultSet result= statement.executeQuery(search_name);
        while(result.next()){
        name=result.getString(1);
        in_marks_roll.setText(roll_no);
        in_marks_name.setText(name);}



    }
    public void addMarks(ActionEvent actionEvent) throws SQLException {
        DatabaseHelper databaseHelper=new DatabaseHelper();
        Connection connection= databaseHelper.getDbconnect();
        String sem=add_sem.getText();
        String subject=add_sub.getText();
        String roll=roll_input_search.getText();
        String n_name = in_marks_name.getText();

        Integer marks_scored=Integer.parseInt(add_marks.getText());
        Integer total_Marks=Integer.parseInt(add_totalMarks.getText());

        String sql="INSERT INTO marksinput values(' "+roll+" ',' "+n_name+" ',' "+subject+" ',' "+sem+" ',' "+marks_scored+" ',' "+total_Marks+" ')";
        Statement statement=connection.createStatement();
        boolean b=statement.execute(sql);
        add_sub.clear();add_sem.clear();add_marks.clear();add_totalMarks.clear();

        if(b==true) {

            TilePane tilePane = new TilePane();
            tilePane.setAlignment(Pos.CENTER);

            Popup popup = new Popup();
            Label label = new Label("Student Added");
            label.setFont(new Font("Arial", 16));
            popup.setAnchorX(300);
            popup.setAnchorY(200);
            popup.getContent().add(label);
            tilePane.getChildren().add(label);
            Stage stage = new Stage();
            Scene scene = new Scene(tilePane, 200, 50);
            stage.setScene(scene);
            stage.show();
            ;
            popup.setAutoHide(true);
            popup.show(stage);
        }

    }
    public void Marksheet(ActionEvent actionEvent) throws SQLException {
        DatabaseHelper databaseHelper = new DatabaseHelper();
        Connection connection = databaseHelper.getDbconnect();
        String roll_no = ent_roll.getText();
        String search_name = "SELECT Name FROM student WHERE RollNo=(' " + roll_no + " ')";
        String search_div = "SELECT Division FROM student WHERE RollNo=(' " + roll_no + " ')";
        String search_year = "SELECT Year FROM student WHERE RollNo=(' " + roll_no + " ')";
        String search_branch = "SELECT Branch FROM student WHERE RollNo=(' " + roll_no + " ')";
        String sem = ent_sem.getText();
        Statement statement = connection.createStatement();
        Statement statement1 = connection.createStatement();
        Statement statement2 = connection.createStatement();
        Statement statement3 = connection.createStatement();
        ResultSet result = statement.executeQuery(search_name);
        ResultSet result1 = statement1.executeQuery(search_div);
        ResultSet result2 = statement2.executeQuery(search_year);
        ResultSet result3 = statement3.executeQuery(search_branch);
        while (result.next()) {
            name = result.getString(1);
            lab_name.setText(name);
        }
        lab_roll.setText(roll_no);
        lab_sem.setText(sem);
        while (result1.next()) {
            String div = result1.getString(1);
            lab_div.setText(div);
        }
        while (result2.next()) {
            String year = result2.getString(1);
            lab_year.setText(year);
        }
        while (result3.next()) {
            String branch = result3.getString(1);
            lab_branch.setText(branch);
        }
        Statement statement5 = connection.createStatement();
        ObservableList<marks> list=FXCollections.observableArrayList();
//        String sql="SELECT Subject FROM marksinput WHERE SrNo=(' " + roll_no + " ') and Semester=(' "+sem+" ')";
        String sql="SELECT * FROM marksinput WHERE SrNo=(' " + roll_no + " ') and Semester=(' "+sem+" ')";
        ResultSet resultSet4=statement5.executeQuery(sql);
        while (resultSet4.next()){
            list.add(new marks(resultSet4.getString("Subject"),resultSet4.getString("Marksscored"),resultSet4.getString("Outof")));
            Float a=Float.parseFloat(resultSet4.getString("Marksscored"));
            Float b=Float.parseFloat(resultSet4.getString("Outof"));
            Float c=a/b*100;
            col_percent.setCellValueFactory(new PropertyValueFactory<marks, Float>("c"));
        }
        col_sub.setCellValueFactory(new PropertyValueFactory<>("subject"));
        col_markscored.setCellValueFactory(new PropertyValueFactory<>("marks_scored"));
        col_totalmarks.setCellValueFactory(new PropertyValueFactory<>("totalmarks"));

        tableView.setItems(list);
        String sql2="SELECT SUM(Marksscored) FROM marksinput WHERE SrNo=(' " + roll_no + " ') and Semester=(' "+sem+" ')";
        Statement statement6=connection.createStatement();
        ResultSet resultSet5=statement6.executeQuery(sql2);
        Float a = null,b = null,c;
        while (resultSet5.next()){
            a=resultSet5.getFloat(1);
        }

        String sql3="SELECT SUM(Outof) FROM marksinput WHERE SrNo=(' " + roll_no + " ') and Semester=(' "+sem+" ')";
        Statement statement7=connection.createStatement();
        ResultSet resultSet6=statement6.executeQuery(sql3);
        while (resultSet6.next()){
            b=resultSet6.getFloat(1);
        }
        c=a/b*100;
        total_percent.setText(c.toString());



    }
}
