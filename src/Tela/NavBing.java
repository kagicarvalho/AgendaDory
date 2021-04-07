/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Kagi
 */
public class NavBing {
    
    public static void main(String [] args){

    SwingUtilities.invokeLater(new Runnable() {
    @Override
      public void run() {
        BING pesquisar = new BING();
        pesquisar.setVisible(true);
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
class BING extends JFrame{

  JFXPanel javafxPanel;
  WebView webComponent;
  JPanel mainPanel;

  public BING(){

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
    this.setSize(1000,700); 
    this.setLocationRelativeTo(null);
  }

  private void loadJavaFXScene(){
    Platform.runLater(new Runnable() {
      @Override
      public void run() {

        BorderPane borderPane = new BorderPane();
        webComponent = new WebView();

        webComponent.getEngine().load("http://www.bing.com");

        borderPane.setCenter(webComponent);
        Scene scene = new Scene(borderPane,450,450);
        javafxPanel.setScene(scene);

      }
    });
  }
}
