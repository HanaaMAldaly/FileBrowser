/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filebrowser;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 *
 * @author Hanaa
 */
public class TreeCellFactory extends TreeCell<File>{
    ObservableList<File> listPath =null;
    ListView<File> list=new ListView<>();

    public TreeCellFactory(ListView lv) {
         /*lv.setCellFactory(new Callback<ListView<File>,ListCell<File>>() {
            @Override
            public ListCell<File> call(ListView<File> param) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return new ListCellFactory();
            }
        });*/
        list=lv;
    }
    

        @Override
            protected void updateItem(File item, boolean empty) {
                super.updateItem(item, empty);
              
                Text text=new Text("");
               
                if (item != null && !empty) {
                    text = new Text(item.getName());
                    text.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                           listPath=buildList(item);
                           list.setItems(listPath);
                        }
                    });
                   
                }
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    setGraphic(text);
                }
            
        
    
    
    
    
    
}
   public ObservableList<File> buildList(File f) { 
        ObservableList<File> children = FXCollections.observableArrayList();//
        if (f != null && f.isDirectory()) {
            File[] files = f.listFiles();
            if (files != null) {
                for (File child : files) { 
                    children.add(child);
                }
            }
        } else {
            children.add(f);
        }
        return children;
    }        
}