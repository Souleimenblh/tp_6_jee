package web;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import dao.TypeDaoImpl;
import dao.ITypeDao;
import aeroport.entities.Type;

@WebServlet (name="catServ",urlPatterns= {"/types","/saisieType",
"/saveType","/supprimerCat","/editerCat","/updateCat"})
public class TypeServlet extends HttpServlet {
ITypeDao aeroport;
@Override
public void init() throws ServletException {
aeroport = new TypeDaoImpl();
}
@Override
protected void doGet(HttpServletRequest request,
 HttpServletResponse response) 
 throws ServletException, IOException {
String path=request.getServletPath();
System.out.println("PATH "+path);
if (path.equals("/types"))
{
TypeModel model= new TypeModel();
List<Type> cats = aeroport.getAllTypes();
model.setTypes(cats);
request.setAttribute("model", model);
request.getRequestDispatcher("types.jsp").forward(request,response);
}
else if (path.equals("/saisieType") )
{
request.getRequestDispatcher("saisieType.jsp").forward(request,response
);
}
else if (path.equals("/saveType") && 
request.getMethod().equals("POST"))
{
Date dateCat= new Date();
 String nom=request.getParameter("nom");
 String pattern = "yyyy-MM-dd";
 SimpleDateFormat simpleDateFormat = new
SimpleDateFormat(pattern);
 try {
dateCat = 
simpleDateFormat.parse(request.getParameter("dateCat"));
} catch (ParseException e) {
e.printStackTrace();
}
 
Type cat = aeroport.save(new Type(nom,dateCat));
request.setAttribute("type", cat);
response.sendRedirect("types");
}
else if (path.equals("/supprimerCat"))
{
 Long id= Long.parseLong(request.getParameter("id"));
 aeroport.deleteType(id);
 response.sendRedirect("types");
}
else if (path.equals("/editerCat") )
{
Long id= Long.parseLong(request.getParameter("id"));
 Type cat = aeroport.getType(id);
 request.setAttribute("type", cat);
request.getRequestDispatcher("editerType.jsp").forward(request,response
);
}
else if (path.equals("/updateCat") )
{
Date dateCat= new Date();
Long id = Long.parseLong(request.getParameter("id"));
String nom=request.getParameter("nom");
Type cat = new Type();
cat.setIdType(id);
cat.setNomType(nom);
String pattern = "yyyy-MM-dd";
SimpleDateFormat simpleDateFormat = new
SimpleDateFormat(pattern);
 try {
dateCat = 
simpleDateFormat.parse(request.getParameter("dateCreation"));
} catch (ParseException e) {
e.printStackTrace();
}
cat.setDateCreation(dateCat);
 aeroport.updateType(cat);
response.sendRedirect("types");
}
else
{
response.sendError(Response.SC_NOT_FOUND);
}
}
@Override
protected void doPost(HttpServletRequest request, 
 HttpServletResponse response) throws
ServletException, IOException {
doGet(request,response);
}
}