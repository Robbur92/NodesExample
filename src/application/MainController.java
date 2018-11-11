package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainController implements Initializable {
	
	@FXML
	TreeView<String> treeView;
	
	Image icon = new Image(getClass().getResourceAsStream("/img/icon.png"));
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TreeItem<String> root = new TreeItem<>("Root", new ImageView(icon));
		
		root.setExpanded(true);
		
		//Nodes
		TreeItem<String> nodeA = new TreeItem<>("node A", new ImageView(icon));
		TreeItem<String> nodeB = new TreeItem<>("node B", new ImageView(icon));
		TreeItem<String> nodeC = new TreeItem<>("node C", new ImageView(icon));	
		root.getChildren().addAll(nodeA,nodeB,nodeC);
		nodeA.setExpanded(true);
		
		//Sub Nodes
		TreeItem<String> nodeA1 = new TreeItem<>("subnode A 1", new ImageView(icon));
		TreeItem<String> nodeB1 = new TreeItem<>("subnode B 1", new ImageView(icon));
		TreeItem<String> nodeC1 = new TreeItem<>("subnode C 1", new ImageView(icon));
		nodeA.getChildren().addAll(nodeA1,nodeB1,nodeC1);
				
		treeView.setRoot(root);
	}
	
	public void mouseClick(MouseEvent mouseEvent) {
		if(mouseEvent.getClickCount() == 2) {
			TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
			System.out.println(item.getValue());
		}
		
	}

}
