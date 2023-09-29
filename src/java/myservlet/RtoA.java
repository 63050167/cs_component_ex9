package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pisut
 */
public class RtoA extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Get the radius of the circle from the request parameters.
        String radiusStr = request.getParameter("radius");
        double radius = Double.parseDouble(radiusStr);

        // Calculate the area and perimeter of the circle.
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        double area = Math.PI * radius * radius;
        double perimeter = 2 * Math.PI * radius;

        // Write the area and perimeter of the circle to the response.
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet RtoA</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Area of the circle: " + twoDigits.format(area) + "</h1>");
        out.println("<h1>Perimeter of the circle: " + twoDigits.format(perimeter) + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
