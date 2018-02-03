/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filebrowser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyCode;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Hanaa
 */
public class FXMLDocumentController implements Initializable {
    @FXML
   Label label;
    @FXML
    private TreeView<File> treeView;
    @FXML
    private TreeFile treeFile;
    @FXML
    private ListView listView;
    @FXML
    TreeCellFactory treeCellFactory;
     @FXML
    private TextField textField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
        treeFile=new TreeFile();
       listView.setCellFactory(new Callback<ListView<File>,ListCell<File>>() {
            @Override
            public ListCell<File> call(ListView<File> param) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return new ListCellFactory();
            }
        });
        treeView.setCellFactory( new Callback<TreeView<File>, TreeCell<File>>() {
            @Override
            public TreeCell<File> call(TreeView<File> param) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return treeCellFactory= new TreeCellFactory(listView);
            }
        });
        textField.setOnKeyPressed((event) -> {
              if(event.getCode()==KeyCode.ENTER){
              treeView.setRoot(treeFile.buildFileSystemBrowser(textField.getText()).getRoot());
                  
              }
          });
        treeView.setRoot(treeFile.buildFileSystemBrowser(textField.getText()).getRoot());
       // listView.setItems(treeCellFactory.listPath);
    }  
  
    
}
