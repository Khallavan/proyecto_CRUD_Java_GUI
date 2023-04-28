package appDTO;

import gui.MainWindow;

public class App {
    public static void main(String[] args) throws Exception {
        javax.swing.SwingUtilities.invokeLater(() ->{
            MainWindow app = new MainWindow();
            app.setVisible(true);
        });
    }
}
