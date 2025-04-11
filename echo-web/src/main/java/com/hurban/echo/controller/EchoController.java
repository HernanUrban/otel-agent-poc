package com.hurban.echo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/web")
public class EchoController {

    @GetMapping("/echo")
    public String echoRequest(
            @RequestParam Map<String, String> params,
            @RequestHeader Map<String, String> headers,
            HttpServletRequest request,
            Model model) {

        // Extract headers from request
        Map<String, String> requestHeaders = new TreeMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            requestHeaders.put(headerName, request.getHeader(headerName));
        }

        // Add attributes to model
        model.addAttribute("params", new TreeMap<>(params)); // Sorted map for better visualization
        model.addAttribute("headers", requestHeaders);

        return "echo";
    }

}
