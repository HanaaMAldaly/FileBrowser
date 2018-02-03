/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filebrowser;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author Hanaa
 */
public class ListCellFactory extends ListCell<File>{
HBox hBox;
ImageView img;
String folderImg="F:\\ITI\\JavaFx\\FileBrowser\\src\\filebrowser\\text.png";
    @Override
    protected void updateItem(File item, boolean empty) {
        super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
        if(item!=null &&!empty){ 
            hBox=new HBox();
            img=new ImageView();
          int dot=item.getName().toString().lastIndexOf(".");
          if(dot!=-1){
          String extension=item.getName().toString().substring(dot);
                if(extension.equals(".rar")||extension.equals(".zip"))
                img.setImage(new Image("file:///F:/ITI/JavaFx/FileBrowser/src/filebrowser/rar.jpg", 50, 50, true, true));
                else if(extension.equals(".mp3")||extension.equals(".wav"))
                img.setImage(new Image("file:///F:/ITI/JavaFx/FileBrowser/src/filebrowser/audio.jpg", 50, 50, true, true));
                else if(extension.equals(".pdf"))
                img.setImage(new Image("file:///F:/ITI/JavaFx/FileBrowser/src/filebrowser/pdf.jpg", 50, 50, true, true));
                else if(extension.equals(".mp4"))
                img.setImage(new Image("file:///F:/ITI/JavaFx/FileBrowser/src/filebrowser/video.jpg", 50, 50, true, true));
                 else if(extension.equals(".txt"))
         
                     img.setImage(new Image("file:///F:/ITI/JavaFx/FileBrowser/src/filebrowser/txt.png", 50, 50, true, true));
                else if(extension.toLowerCase().equals(".png")||extension.toLowerCase().equals(".jpg")){
                     try {
                           System.out.println("kkk");
                         img.setImage(new Image(item.toURL().toString(), 50, 50, true, true));
          } catch (MalformedURLException ex) {
              Logger.getLogger(ListCellFactory.class.getName()).log(Level.SEVERE, null, ex);
          }}
                else  img.setImage(new Image("file:///F:/ITI/JavaFx/FileBrowser/src/filebrowser/file.jpg", 50, 50, true, true));
          } else if(item.isDirectory()){
        
                  img.setImage(new Image("file:///F:/ITI/JavaFx/FileBrowser/src/filebrowser/folder.jpg", 50, 50, true, true));   
                } 
        Text t=new Text(item.getName());
            hBox.getChildren().addAll(img,t);
          
        setGraphic(hBox);
        }else{
            setGraphic(null);
        }
    }
    
    
}
