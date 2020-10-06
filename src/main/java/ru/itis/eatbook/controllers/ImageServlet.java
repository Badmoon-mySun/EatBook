package ru.itis.eatbook.controllers;

import ru.itis.eatbook.services.FileService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imageName = req.getParameter("name");
        resp.setContentType("image/png");

        String path = (String) getServletContext().getAttribute("IMAGE_DIR");

        FileService fileService = (FileService) getServletContext().getAttribute("fileService");

        OutputStream outputStream = resp.getOutputStream();
        fileService.unload(path + File.separator + imageName, outputStream);
        outputStream.close();
    }
}
