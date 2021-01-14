package bp.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-13
 */
@SpringBootApplication
public class Application {
    /**
     * The application entry point
     *
     * @param args application arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
