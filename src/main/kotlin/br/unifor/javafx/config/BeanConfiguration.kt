package br.unifor.javafx.config

import javafx.stage.Stage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import java.util.*

/**
 *
 * Spring configuration class to declare the necessary spring beans
 *
 * @author Bruno Lopes <bruno.lopes@unifor.br>
 *
 */
@Configuration
class BeanConfiguration {

    @Autowired
    private lateinit var springFXMLLoader: SpringFXMLLoader

    @Bean
    fun resourceBundle(): ResourceBundle {
        return ResourceBundle.getBundle("bundle")
    }

    @Bean
    @Lazy(true)
    fun stageManager(stage: Stage): StageManager {
        return StageManager(stage, springFXMLLoader)
    }


}