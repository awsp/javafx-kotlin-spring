package br.unifor.javafx.config

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.util.Callback
import org.springframework.beans.factory.getBean
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import java.util.*
import java.io.IOException
import java.util.ResourceBundle
import org.springframework.beans.factory.annotation.Autowired

/**
 *  An FXMLLoader based on Spring Framework. Use this class to load a FXML file from fxml directory on resources.
 *
 *  @author Bruno Lopes <bruno.lopes@unifor.br>
 *
 */
@Component
class SpringFXMLLoader @Autowired
constructor(private val resourceBundle: ResourceBundle, private val context: ApplicationContext) {

    @Throws(IOException::class)
    fun load(fxmlPath: String): Parent {

        val loader = FXMLLoader()
        loader.controllerFactory = Callback<Class<*>, Any> { context.getBean(it) }
        loader.resources = resourceBundle
        loader.location = javaClass.getResource(fxmlPath)
        return loader.load()

    }

}
