package kr.pile.songwoo.resumeportfolio.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {

    private static final String START_TIME_ATTRIBUTE = "requestStartTime";

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) {
        long startTime = System.currentTimeMillis();
        request.setAttribute(START_TIME_ATTRIBUTE, startTime);

        String requestPath = createRequestPath(request);

        if (handler instanceof HandlerMethod handlerMethod) {
            log.info(
                    "[REQUEST] {} {} -> {}.{}() client={}",
                    request.getMethod(),
                    requestPath,
                    handlerMethod.getBeanType().getSimpleName(),
                    handlerMethod.getMethod().getName(),
                    request.getRemoteAddr()
            );
        } else {
            log.info(
                    "[REQUEST] {} {} -> handler={} client={}",
                    request.getMethod(),
                    requestPath,
                    handler.getClass().getSimpleName(),
                    request.getRemoteAddr()
            );
        }

        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception exception
    ) {
        String requestPath = createRequestPath(request);
        long duration = calculateDuration(request);

        if (exception == null) {
            log.info(
                    "[RESPONSE] {} {} status={} duration={}ms",
                    request.getMethod(),
                    requestPath,
                    response.getStatus(),
                    duration
            );
            return;
        }

        log.error(
                "[ERROR] {} {} status={} duration={}ms exception={}",
                request.getMethod(),
                requestPath,
                response.getStatus(),
                duration,
                exception.getClass().getSimpleName(),
                exception
        );
    }

    private long calculateDuration(HttpServletRequest request) {
        Object startTimeObject = request.getAttribute(START_TIME_ATTRIBUTE);

        if (!(startTimeObject instanceof Long startTime)) {
            return -1;
        }

        return System.currentTimeMillis() - startTime;
    }

    private String createRequestPath(HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        String queryString = request.getQueryString();

        if (queryString == null || queryString.isBlank()) {
            return requestUri;
        }

        return requestUri + "?" + queryString;
    }
}