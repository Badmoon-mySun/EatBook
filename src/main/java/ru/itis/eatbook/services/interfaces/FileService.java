package ru.itis.eatbook.services.interfaces;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.OutputStream;

public interface FileService {
    void upload(Part part, String path, String name) throws IOException;
    void unload(String filePath, OutputStream outputStream) throws IOException;
}
