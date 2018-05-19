package br.unifor.javafx.view

import java.util.*

/**
 *
 * Enum that store the information the path and title of the screens of application.
 *
 * Every new screen must be inserted here with the necessary information to load correctly the screen.
 *
 * @author Bruno Lopes <bruno.lopes@unifor.br>
 */
enum class FxmlView {

    MAIN {
        override fun getTitle(): String {
            return getStringFromResourceBundle("main.title")
        }

        override fun getFxmlFile(): String {
            return "/fxml/MainWindow.fxml"
        }
    };

    abstract fun getTitle(): String
    abstract fun getFxmlFile(): String

    /**
     * This method get a value from bundle.properties file stored on recource directory
     *
     * @param key The key of desired value
     *
     * @return The value associate with passed key
     */
    fun getStringFromResourceBundle(key: String): String {
        return ResourceBundle.getBundle("bundle").getString(key)
    }

}
