package br.unifor.javafx

import br.unifor.javafx.config.StageManager
import br.unifor.javafx.view.FxmlView
import javafx.application.Application
import javafx.stage.Stage
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.ConfigurableApplicationContext

/**
 *  The entry point of application
 *
 *  This class initialize the SprintContext and create the necessary spring beans to initialize the JavaFX.
 *
 *  @author Bruno Lopes <bruno.lopes@unifor.br>
 *
 */

@SpringBootApplication
class App : Application() {

    private val LOG = LoggerFactory.getLogger(App::class.java)

    private lateinit var springContext: ConfigurableApplicationContext
    private lateinit var stageManager: StageManager

    override fun init() {
        springContext = springBootApplicationContext()
    }

    override fun start(primaryStage: Stage?) {

        stageManager = springContext.getBean(StageManager::class.java, primaryStage)
        displayInitialScene()
        LOG.info("Application Started.")

    }

    private fun displayInitialScene() {
        stageManager.switchScene(FxmlView.MAIN)
    }

    override fun stop() {
        springContext.close()
    }

    private fun springBootApplicationContext(): ConfigurableApplicationContext {
        val builder = SpringApplicationBuilder(App::class.java)
        return builder.run()
    }

}

fun main(args: Array<String>) {
    Application.launch(App::class.java)
}