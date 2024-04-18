package com.hdz.carrillo.api3.controllers;
import com.google.gson.Gson;
import com.hdz.carrillo.api3.models.Titulo;
import com.hdz.carrillo.api3.services.IService;
import com.hdz.carrillo.api3.services.TituloService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/api/titulos")
public class ApiTitulosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Titulo> service = new TituloService(conn);
        List<Titulo> titulos = service.listar();

        resp.setContentType("application/json");

        try(PrintWriter out = resp.getWriter()) {

            Map<String,String> respuesta = new HashMap<>();
            Map<String,List<Titulo>> titulosJSON = new HashMap<>();
            resp.setStatus(201);
            titulosJSON.put("Titulos",titulos);
           // respuesta.put("message","Conectado mi pá");
           // respuesta.put("estaus","success");
           // String json = new Gson().toJson(respuesta);
            String json = new Gson().toJson(titulosJSON);
            out.print(json);
        }
    }
}
