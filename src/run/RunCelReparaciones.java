package run;

import controlador.CtrlCelular;
import modelo.Celular;
import modelo.ConsultaCelular;
import vista.VistaCelular;

public class RunCelReparaciones {
    public static void main(String[] args) {
        
        Celular cel = new Celular();
        ConsultaCelular celC = new ConsultaCelular();
        VistaCelular celV = new VistaCelular();
        
        CtrlCelular ctrlC = new CtrlCelular(cel, celC, celV);
        ctrlC.iniciar();
        celV.setVisible(true);
        
    }
}
