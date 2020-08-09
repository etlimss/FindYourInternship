package client.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import client.view.login.LoginController;
import client.viewmodel.ViewModelFactory;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws Exception {
        openView("App");
    }

    public void openView(String viewToOpen) throws IOException {
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        try {
            if("login".equals(viewToOpen)) {
                Stage stage1 = new Stage();
                loader.setLocation(getClass().getResource("login/logIn.fxml"));
                root = loader.load();
                loader.<LoginController>getController().init(viewModelFactory.getLoginViewModel(), this);
                scene = new Scene(root);
                stage1.setScene(scene);
                stage1.show();
                stage.setTitle("Log-in");
            }
//
//            loader.setLocation(getClass().getResource(viewToOpen.toLowerCase() + "/" + viewToOpen + "View.fxml"));
//            root = loader.load();
//            if ("App".equals(viewToOpen)) {
//                LoginController view = loader.getController();
//                view.init(viewModelFactory.getLoginViewModel(), this);
//                stage.setTitle("Find Your Internship");
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeView(Stage stage){
        stage.close();
    }
}
