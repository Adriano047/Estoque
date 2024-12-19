package almoxarifado.estoque;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BrowserLauncher implements CommandLineRunner {

    @Override
    public void run(String... args) {
        String url = "http://localhost:8080";
        System.out.println("O servidor está rodando!");
        System.out.println("Abra o navegador e acesse: " + url);
    }
}
