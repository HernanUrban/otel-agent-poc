package com.hurban.echo.controller;

import com.hurban.echo.dto.EchoResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class EchoApiController {


    Logger logger = Logger.getLogger(EchoApiController.class.getName());

    @GetMapping("/echo")
    public ResponseEntity<EchoResponse> echo(
            @RequestParam Map<String, String> params,
            @RequestHeader Map<String, String> headers,
            HttpServletRequest request) {
        // Extract headers from request
        Map<String, String> requestHeaders = new TreeMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            requestHeaders.put(headerName, request.getHeader(headerName));
        }


        EchoResponse echoResponse = EchoResponse.build()
                .withHeaders(requestHeaders)
                .withParams(params);

        logger.info(echoResponse.toString());
        return ResponseEntity.ok(echoResponse);
    }
}
