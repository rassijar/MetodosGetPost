/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.ContactoDAO;
import modelo.dto.ContactoDTO;

/**
 *
 * @author Morenofamily
 */
public class ContactoCTO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ContactoDAO dao = new ContactoDAO();
        switch (accion) {
            case "Agregar": {
                //1.
                String nombre = request.getParameter("txtnombre");
                String correo = request.getParameter("txtcorreo");
                String asunto = request.getParameter("txtasunto");
                String mensaje = request.getParameter("txtmensaje");

                //2.
                ContactoDTO dto = new ContactoDTO(nombre, correo, asunto, mensaje);

                //3.
                boolean res = dao.crear(dto);
                if (res) {
                    PrintWriter out = response.getWriter();
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>respuesta</title>");
                    out.println("</head>");
                    out.println("<body><h1>Su comentario fue enviado con exito</h1>"
                            + "<a href=index.jsp>Volver</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
                break;
            }
            case "Listar": {
                System.out.println("Entro");
                List<ContactoDTO> list = dao.readAll();
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>respuesta</title>");
                out.println("<style>\n"
                        + "table, th, td {\n"
                        + "  border: 3px solid blue;\n"
                        + "  border-collapse: collapse;\n"                    
                        + "}"
                        +"th,td{"
                        + "padding:15px;}"
                        + "</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<table>");
                out.println("<caption>Lista de mensajes</caption>");
                out.println("<th>Nombre</th>");
                out.println("<th>Correo</th>");
                out.println("<th>Asunto</th>");
                out.println("<th>Descripcion</th>");
                for (ContactoDTO i : list) {
                    out.println("<tr>");
                    out.println("<td>" + i.getNombre() + "</td>");
                    out.println("<td>" + i.getCorreo() + "</td>");
                    out.println("<td>" + i.getAsunto() + "</td>");
                    out.println("<td>" + i.getDescripcion() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");

                break;
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        /* //1.
        String nombre = request.getParameter("txtnombre");
        String correo = request.getParameter("txtcorreo");
        String asunto = request.getParameter("txtasunto");
        String mensaje = request.getParameter("txtmensaje");
        
        //2.
        ContactoDTO dto = new ContactoDTO(nombre, correo, asunto, mensaje);
        
        //3.
        ContactoDAO dao = new ContactoDAO();
        dao.crear(dto);
        
        List<ContactoDTO> list = dao.readAll();
        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }*/
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
