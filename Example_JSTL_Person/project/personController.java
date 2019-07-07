package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Person;
import model.PersonDAO;

public class personController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        PersonDAO personHandler = new PersonDAO();
        
        String action = request.getParameter("action");
        
        if (action.equals("modify")) {
            int personId = Integer.parseInt(request.getParameter("personId"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("email");

            Person newPerson = new Person();

            newPerson.setPersonId(personId);
            newPerson.setFirstName(firstName);
            newPerson.setLastName(lastName);
            newPerson.setEmailAddress(emailAddress);

            try {
                personHandler.updatePerson(newPerson);

                List<Person> displayList = personHandler.selectAll();
                request.setAttribute("displayList", displayList);
                String url = "/contactList.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            } catch (SQLException ex) {
                request.setAttribute("exception", ex);

                String url = "/SQLException.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            } catch (ClassNotFoundException ex) {
                request.setAttribute("exception", ex);

                String url = "/ClassNotFoundException.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
            
            
            
        } // end action = MODIFY
        else {
            int personId = Integer.parseInt(request.getParameter("personId"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("email");

            Person newPerson = new Person();

            newPerson.setPersonId(personId);
            newPerson.setFirstName(firstName);
            newPerson.setLastName(lastName);
            newPerson.setEmailAddress(emailAddress);

            try {
                personHandler.insertPerson(newPerson);

                List<Person> displayList = personHandler.selectAll();
                request.setAttribute("displayList", displayList);
                String url = "/contactList.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            } catch (SQLException ex) {
                request.setAttribute("exception", ex);

                String url = "/SQLException.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            } catch (ClassNotFoundException ex) {
                request.setAttribute("exception", ex);

                String url = "/ClassNotFoundException.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
        } // end action INSERT
    } // end doPost
    
    
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        PersonDAO personHandler = new PersonDAO();
        
        String action = request.getParameter("action");
        int personId = Integer.parseInt(request.getParameter("personId"));
        
        if (action.equals("delete")) {
            try {
                personHandler.delete(personId);

                List<Person> displayList = personHandler.selectAll();
                request.setAttribute("displayList", displayList);
                String url = "/contactList.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            } catch (SQLException ex) {
                request.setAttribute("exception", ex);
            
                String url = "/SQLException.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            } catch (ClassNotFoundException ex) {
                request.setAttribute("exception", ex);

                String url = "/ClassNotFoundException.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
        } // end action = delete
        
        if (action.equals("edit")) {
            try {
                Person personModified = personHandler.selectById(personId);

                request.setAttribute("person", personModified);
                String url = "/modify.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            } catch (SQLException ex) {
                request.setAttribute("exception", ex);
            
                String url = "/SQLException.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            } catch (ClassNotFoundException ex) {
                request.setAttribute("exception", ex);

                String url = "/ClassNotFoundException.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
        } // end action = edit
        
    } // end doGet
    

} // end class personController