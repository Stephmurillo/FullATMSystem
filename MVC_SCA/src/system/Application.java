package system;

import java.io.IOException;

/*
* (c) 2021
* @author Yoselin Rojas, Cinthya Murillo
* @version 1.0.0 2021-10-24
*
* -----------------------------------------------
* EIF206 Programación III
* 2do Ciclo 2021
* II Proyecto
*
* 207700499 Rojas Fuentes, Yoselin - Grupo 04
* 305260682 Murillo Hidalgo, Cinthya - Grupo 03
* -----------------------------------------------
*/

public class Application {

    public static void main(String[] args) throws IOException {
        
        system.presentation.CambioClave.ModelCambio modelCambio = new system.presentation.CambioClave.ModelCambio();
        system.presentation.CambioClave.ViewCambio viewCambio = new system.presentation.CambioClave.ViewCambio();
        system.presentation.CambioClave.ControllerCambio controllerCambio = new system.presentation.CambioClave.ControllerCambio(modelCambio, viewCambio);
        CAMBIOCLAVE = controllerCambio; 
        
        system.presentation.RetiroDeDinero.ModelRetiro modelRetiro = new system.presentation.RetiroDeDinero.ModelRetiro();
        system.presentation.RetiroDeDinero.ViewRetiro viewRetiro = new system.presentation.RetiroDeDinero.ViewRetiro();
        system.presentation.RetiroDeDinero.ControllerRetiro controllerRetiro = new system.presentation.RetiroDeDinero.ControllerRetiro(modelRetiro, viewRetiro);
        RETIROS = controllerRetiro; 
        
        system.presentation.Menu.ModelMenu modelMenu = new system.presentation.Menu.ModelMenu();
        system.presentation.Menu.ViewMenu viewMenu = new system.presentation.Menu.ViewMenu();
        system.presentation.Menu.ControllerMenu controllerMenu = new system.presentation.Menu.ControllerMenu(modelMenu, viewMenu);
        MENUES = controllerMenu; 
        
        system.presentation.Login.ModelLogin modelLogin = new system.presentation.Login.ModelLogin();
        system.presentation.Login.ViewLogin viewLogin = new system.presentation.Login.ViewLogin();
        system.presentation.Login.ControllerLogin controllerLogin = new system.presentation.Login.ControllerLogin(modelLogin, viewLogin);
        LOGIN = controllerLogin; 
        
        LOGIN.show();
       
    }
        public static system.presentation.CambioClave.ControllerCambio CAMBIOCLAVE;
        public static system.presentation.RetiroDeDinero.ControllerRetiro RETIROS;
        public static system.presentation.Menu.ControllerMenu MENUES;
        public static system.presentation.Login.ControllerLogin LOGIN;
}
