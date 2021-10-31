package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Service {

    void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
