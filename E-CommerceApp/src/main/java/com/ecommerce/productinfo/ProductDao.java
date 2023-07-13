package com.ecommerce.productinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/ProductDao")
public class ProductDao extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SessionFactory sessionFactory;

    @Override
    public void init() throws ServletException {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("txtproductname");
        String model = request.getParameter("txtproductmodel");
        float price = Float.parseFloat(request.getParameter("txtprice"));

        Product item = new Product();
        item.setProductName(name);
        item.setProducModel(model);
        item.setPrice(price);

        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.save(item);

            transaction.commit();

            PrintWriter out = response.getWriter();
            out.println("Record inserted successfully.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            out.println("Error occurred while inserting the record.");
        } finally {
            session.close();
        }
    }

    @Override
    public void destroy() {
        sessionFactory.close();
    }
}
