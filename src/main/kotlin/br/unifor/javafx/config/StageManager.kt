package br.unifor.javafx.config

import br.unifor.javafx.view.FxmlView
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import org.slf4j.LoggerFactory

/**
 *
 * This class manage the JavaFX primary stage and load a FXML file on screen.
 *
 *  @author Bruno Lopes <bruno.lopes@unifor.br>
 *
 */
class StageManager(val primaryStage: Stage, val springFXMLLoader: SpringFXMLLoader) {

    private val LOG = LoggerFactory.getLogger(StageManager::class.java)

    fun getStage(): Stage {
        return this.primaryStage
    }

    fun switchScene(view: FxmlView) {
        val viewRootNodeHierarchy = loadViewRoorNodeHierarchy(view.getFxmlFile())
        show(viewRootNodeHierarchy, view.getTitle())
    }

    private fun show(rootNode: Parent, title: String) {

        val scene = prepareScene(rootNode)

        primaryStage.title = title
        primaryStage.scene = scene

        primaryStage.sizeToScene()
        primaryStage.centerOnScreen()
        primaryStage.show()

    }

    private fun prepareScene(rootNode: Parent): Scene {

        var scene = primaryStage.scene

        if (scene == null) {
            scene = Scene(rootNode)
        }

        scene.root = rootNode
        return scene

    }

    private fun loadViewRoorNodeHierarchy(fxmlFilePath: String): Parent {
        return springFXMLLoader.load(fxmlFilePath)
    }


}