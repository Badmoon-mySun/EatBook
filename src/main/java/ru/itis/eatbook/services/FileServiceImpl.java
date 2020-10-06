package ru.itis.eatbook.services;

import javax.servlet.http.Part;
import java.io.*;

public class FileServiceImpl implements FileService {
    @Override
    public void upload(Part part, String path, String name) throws IOException {
        InputStream inputStream = part.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];

        int c;
        while ((c = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, c);
        }

        inputStream.close();
        outputStream.close();

        byte[] result = outputStream.toByteArray();

        FileOutputStream fileOutputStream = new FileOutputStream(path + File.separator + name);
        fileOutputStream.write(result);
        fileOutputStream.close();
    }

    @Override
    public void unload(String filePath, OutputStream outputStream) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            byte[] buffer = new byte[1024];

            int c;
            while ((c = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, c);
            }

            fileInputStream.close();
        } catch (FileNotFoundException ignore) { }
    }
}
