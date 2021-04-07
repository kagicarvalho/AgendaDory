  
package Tela;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

public class Navtwitter  {
  public static void main(String [] args){

    SwingUtilities.invokeLater(new Runnable() {
    @Override
      public void run() {
        Twitter navegador04 = new Twitter();
        navegador04.setVisible(true);
      }
    });

  }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void addActionListener(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}

/**
* Aqui mostra a janela web do face
*/
class Twitter extends JFrame{

  JFXPanel javafxPanel;
  WebView webComponent;
  JPanel mainPanel;

  public Twitter(){

    javafxPanel = new JFXPanel();

    initSwingComponents();

    loadJavaFXScene();
  }

  /**
  * Instantiate the Swing compoents to be used
  */
  private void initSwingComponents(){
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.add(javafxPanel, BorderLayout.CENTER);

    JPanel urlPanel = new JPanel(new FlowLayout());
 

    
    
    /**
     *Tamanho da janela e o metodo que ela é fechada
     */
    this.add(mainPanel);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setSize(320,640); 
    this.setLocationRelativeTo(null);
  }

  private void loadJavaFXScene(){
    Platform.runLater(new Runnable() {
      @Override
      public void run() {

        BorderPane borderPane = new BorderPane();
        webComponent = new WebView();

        webComponent.getEngine().load("https://mobile.twitter.com/session/new");

        borderPane.setCenter(webComponent);
        Scene scene = new Scene(borderPane,450,450);
        javafxPanel.setScene(scene);

      }
    });
  }
}
