package com.streaming.analytics.analytics.logs;


import com.streaming.analytics.analytics.logs.wrappers.BufferedRequestWrapper;
import com.streaming.analytics.analytics.logs.wrappers.BufferedResponseWrapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Slf4j
@Component
@AllArgsConstructor
public class RequestLogger {
    private AsyncLogger asyncLogger;

    static String removeRowJumps(String string) {
        if (StringUtils.isBlank(string)) return null;
        return string.replace("\n", "").replace("\r", "");
    }

    public void log(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            BufferedRequestWrapper bufferedRequest = new BufferedRequestWrapper(httpServletRequest);
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            BufferedResponseWrapper bufferedResponse = new BufferedResponseWrapper(httpServletResponse);

            long requestMillis = System.currentTimeMillis();
            if (((HttpServletRequest) request).getRequestURI().contains("/api/"))
                logRequest(bufferedRequest);

            chain.doFilter(bufferedRequest, bufferedResponse);

            long responseMillis = System.currentTimeMillis();
            long totalRequestMillis = responseMillis - requestMillis;
            if (((HttpServletRequest) request).getRequestURI().contains("/api/"))
                logResponse(bufferedResponse, totalRequestMillis);

        } catch (Throwable a) {
            log.error(a.getMessage());
        }
    }

    public void logRequest(BufferedRequestWrapper bufferedRequest) throws IOException {
        String requestMethod = removeRowJumps(bufferedRequest.getMethod());
        String requestUri = removeRowJumps(bufferedRequest.getRequestURI());
        Map<String, String> requestMap = this.getParameters(bufferedRequest);
        String requestParams = removeRowJumps(requestMap.toString());
        String requestBody = removeRowJumps(bufferedRequest.getRequestBody());
        String requestHeaders = removeRowJumps(getHeaders(bufferedRequest).toString());

        asyncLogger.info(String.format("Request method: %s", requestMethod));
        asyncLogger.info(String.format("Request url: %s", requestUri));
        asyncLogger.info(String.format("Request params: %s", requestParams));
        asyncLogger.info(String.format("Request body: %s", requestBody));
        asyncLogger.info(String.format("Request headers: %s", requestHeaders));
    }

    public void logResponse(BufferedResponseWrapper bufferedResponse, long totalRequestTime) {
        int responseStatus = bufferedResponse.getStatus();
        String responseHeaders = removeRowJumps(getHeaders(bufferedResponse).toString());
        String responseBody = bufferedResponse.getContent();

        asyncLogger.info(String.format("Response Code: %s", responseStatus));
        asyncLogger.info(String.format("Response Headers: %s", responseHeaders));
        asyncLogger.info(String.format("Response Body Text: %s", removeRowJumps(responseBody)));
        asyncLogger.info(String.format("Total Request Time: %s ms", totalRequestTime));
    }

    private List<String> getHeaders(HttpServletRequest httpServletRequest) {
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        List<String> headers = new ArrayList<>();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = httpServletRequest.getHeader(headerName);
                headers.add(String.format("%s : %s", headerName, headerValue));
            }
        }
        return headers;
    }

    private List<String> getHeaders(HttpServletResponse httpServletResponse) {
        Collection<String> headerNames = httpServletResponse.getHeaderNames();
        List<String> headers = new ArrayList<>();
        for (String headerName : headerNames) {
            String headerValue = httpServletResponse.getHeader(headerName);
            headers.add(String.format("%s : %s", headerName, headerValue));
        }
        return headers;
    }

    private Map<String, String> getParameters(HttpServletRequest request) {
        Map<String, String> typesafeRequestMap = new HashMap<>();
        Enumeration<?> requestParamNames = request.getParameterNames();
        while (requestParamNames.hasMoreElements()) {
            String requestParamName = (String) requestParamNames.nextElement();
            String requestParamValue = request.getParameter(requestParamName);
            typesafeRequestMap.put(requestParamName, requestParamValue);
        }
        return typesafeRequestMap;
    }
}
