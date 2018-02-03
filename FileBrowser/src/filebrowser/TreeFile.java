/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filebrowser;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 *
 * @author Hanaa
 */
public class TreeFile {
  private ObservableList<TreeItem<File>>buildChildren(TreeItem<File>treeItem){
        File f=treeItem.getValue();
        if(f!=null&&f.isDirectory()){
            File[] files=f.listFiles();
            if(files!=null){
            
                ObservableList<TreeItem<File>> children=
                        FXCollections.observableArrayList();
                for(File child:files){
                    children.add(createNode(child));
                }
                return children;
            }
        }
        return FXCollections.emptyObservableList();
    }
    TreeItem<File> createNode(final File file){
        return new TreeItem<File>(file){
            private boolean isLeaf;
            private boolean isFirstTimeChild=true;
            private boolean isFirstTimeLeaf=true;

            @Override
            public ObservableList<TreeItem<File>> getChildren() {
              if(isFirstTimeChild){
                  isFirstTimeChild=false;
                  super.getChildren().setAll(buildChildren(this));
              }
                return super.getChildren(); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isLeaf() {
                //return super.isLeaf(); //To change body of generated methods, choose Tools | Templates.
                if(isFirstTimeLeaf){
                    isFirstTimeLeaf=false;
                    File f=(File)getValue();
                    isLeaf=f.isFile();
                }
                return isLeaf;
                        
            }
            
        
        };
    }
    TreeView<File> buildFileSystemBrowser(String path){
      TreeItem<File> root=createNode(new File(path));
      return new TreeView<>(root);
    }   
}
