import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CalculationVisitServlet extends HttpServlet
{
private int counter;
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException
{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
HttpSession session=request.getSession(true);
if(session.isNew())
{
out.print("This is the first time you are visiting this page");
++counter;
}
else
{
    synchronized(CalculationVisitServlet.this)
{
if(counter==10)
{ session.invalidate();
counter=0;
request.getSession(false);
}
else
out.print("You have visited this page "+(++counter)+ " times");
}
}
}
}
