package com.project.local.jakartasimplewebapp.servlet;


import com.project.local.jakartasimplewebapp.bean.CategoryDrop;
import com.project.local.jakartasimplewebapp.bean.CategoryList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class CategorieVis
 */
@WebServlet("/ModPro")
public class ModificaPro extends HttpServlet {

    private static final long serialVersionUID = 876868L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaPro() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param request
     * @param response
     * @throws jakarta.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession currentSession = request.getSession();
        
        String visualizza = request.getParameter("visualizza");

        if (visualizza != null) {

        } else {
            
            CategoryList list = null;
            try {

                list = new CategoryList();
            } catch (SQLException e) {
                // TODO Auto-generated catch block

            }
            List<CategoryDrop> categorieslist = list.DropCategories();
            request.setAttribute("categoriesList", categorieslist);
            request.getRequestDispatcher("form_modifica_prodotto.jsp").forward(request, response);
        } 

    }

    /**
     * @param request
     * @param response
     * @throws jakarta.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
