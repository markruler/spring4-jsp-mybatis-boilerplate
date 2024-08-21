package com.markruler.legacy.micro;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class ExternalFileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String filePath = "/Users/cs.im/playground/welcome.jsp";
        File file = new File(filePath);

        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
            return;
        }

        // JSP에서 Servlet을 직접 포함할 경우 OutputStream이 아니라 PrintWriter를 사용해야 함.
        try (FileInputStream fis = new FileInputStream(file)) {
            // 스트림은 여기서 닫으면 안 됨.
            // java.io.IOException: 스트림이 닫혔습니다.
            // 		at org.apache.jasper.runtime.JspWriterImpl.ensureOpen(JspWriterImpl.java:195)
            // 		at org.apache.jasper.runtime.JspWriterImpl.flushBuffer(JspWriterImpl.java:107)
            PrintWriter writer = response.getWriter();

            response.setContentType("text/plain");
            response.setContentLength((int) file.length());

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                writer.write(new String(buffer, 0, bytesRead));
            }
        } catch (IOException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error reading file");
        }
    }
}

