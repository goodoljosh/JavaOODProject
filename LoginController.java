package Controller;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LoginController {

    public static void handleLogin(
            HttpExchange exchange)
            throws IOException {

        String html =
                Files.readString(
                        Path.of(
                            "Views/login.html"));

        exchange.getResponseHeaders()
                .set(
                     "Content-Type",
                     "text/html");

        exchange.sendResponseHeaders(
                200,
                html.getBytes().length);

        exchange.getResponseBody()
                .write(
                    html.getBytes());

        exchange.close();
    }
}