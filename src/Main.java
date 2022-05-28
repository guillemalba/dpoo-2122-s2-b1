import business.GameManager;
import business.RecordedGameManager;
import business.UserManager;
import persistence.GameDAO;
import persistence.GameSQLDAO;
import persistence.UserDAO;
import persistence.UserSQLDAO;
import presentation.controllers.*;
import presentation.views.*;

import java.awt.*;


public class Main {
    public static void main(String[] args) {

        /**
         * 1- New dels DAO
         * 2- New dels Manager
         * 3- New de les vistes
         * 4- New del Mainview, o Cardlayout
         * 5- New dels Controller
         * 6- Vincular controladors
         */

        /* New dels DAO */
        UserDAO userDAO = new UserSQLDAO();
        GameDAO gameDAO = new GameSQLDAO();

        /* News dels Managers */
        UserManager userManager = new UserManager(userDAO);
        GameManager gameManager = new GameManager(gameDAO,userManager);
        RecordedGameManager recordedGameManager = new RecordedGameManager(gameDAO,gameManager);


        /* New de les Vistes */
        LoginView loginView = new LoginView();
        RegisterView registerView = new RegisterView();
        LogoutView logoutView = new LogoutView();
        MenuView menuView = new MenuView();
        GameView gameView = new GameView();
        RecordedGameMenuView recordedGameMenuView = new RecordedGameMenuView();
        RankingView rankingView = new RankingView();

        /* New del mainView i CardLayout */
        CardLayout cardLayout = new CardLayout();
        MainView mainView = new MainView(cardLayout, registerView, loginView, logoutView, menuView, gameView, recordedGameMenuView, rankingView);

        /* New dels Controller */
        LoginController loginController = new LoginController(loginView, mainView, cardLayout, userManager);
        RegisterController registerController = new RegisterController(registerView, mainView, cardLayout,userManager);
        LogoutController logoutController = new LogoutController(logoutView, mainView, cardLayout,userManager);
        RecordedGameMenuController recordedGameMenuController = new RecordedGameMenuController(recordedGameMenuView, mainView, gameManager,recordedGameManager);
        GameViewController gameViewController = new GameViewController(gameView, mainView,gameManager);
        RankingController rankingController = new RankingController(rankingView, mainView, userManager);

        /* Vincular Controllers */
        loginView.loginController(loginController);
        registerView.registerController(registerController);
        logoutView.registerController(logoutController);
        gameView.registerController(gameViewController, gameViewController);
        recordedGameMenuView.setRecordedGameMenuController(recordedGameMenuController);
        gameManager.registerController(gameViewController);
        rankingView.registerRankingController(rankingController);

        mainView.start();
    }
    
}







