package action;

import controller.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeslogarAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("index.jsp");
    }

}
