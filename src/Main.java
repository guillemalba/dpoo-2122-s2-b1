import persistence.UserSQLDAO;
import presentation.controllers.LoginController;
import presentation.controllers.LogoutController;
import presentation.controllers.MenuController;
import presentation.controllers.RegisterController;
import presentation.views.*;

import java.awt.*;


public class Main {
    public static void main(String[] args) {

        CardLayout viewComponents = new CardLayout();

        RegisterView registerView = new RegisterView();

        LoginView loginView = new LoginView();

        LogoutView logoutView = new LogoutView();

        MenuView menuView = new MenuView();

        MainView mainView = new MainView(viewComponents, registerView, loginView, logoutView, menuView);

        LoginController loginController = new LoginController(loginView, mainView, viewComponents);
        loginView.loginController(loginController);

        RegisterController registerController = new RegisterController(registerView, mainView, viewComponents);
        registerView.registerController(registerController);

        LogoutController logoutController = new LogoutController(logoutView, mainView, viewComponents);
        logoutView.registerController(logoutController);

        MenuController menuController = new MenuController(menuView, mainView, viewComponents);
        menuView.registerActionListener(menuController);

        mainView.start();



        /*sl.register("Mario","1234","mario@mario.com");
        sl.register("Guille","1234","guille@mario.com");
        sl.register("Didac","1234","didac@mario.com");
        sl.register("Puchi","1234","puchi@mario.com");

        boolean proba1 = sl.login("Mario","1234"); //prueba nombre buena
        boolean proba2 = sl.login("mario@mario.com","1234"); //prueba correo buena
        boolean proba3 = sl.login("guille@guille.com","1234"); // pureba correo mal
        boolean proba4 = sl.login("didi","1234"); //prueba nombre mal
        boolean proba5 = sl.login("Puchi","4321"); //prueba contra mal

        System.out.println(proba1+"\t"+proba2+"\t"+proba3+"\t"+proba4+"\t"+proba5);

        sl.deleteAccount("Didac");
        sl.deleteAccount("Pepe");

        sl.mostrar();*/
    }
    
}







