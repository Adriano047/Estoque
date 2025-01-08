package almoxarifado.estoque;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BrowserLauncher implements CommandLineRunner {
    @Value("${server.port:8080}")
    private int port;

    @Override
    public void run(String... args) {
        String url = "http://localhost:" + port;
        System.out.println("O servidor está rodando!");
        System.out.println("Abra o navegador e acesse: " + url);
    }
}

