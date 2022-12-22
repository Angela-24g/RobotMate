package com.project.robotmate.admin.global.util;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {
    private static final String REQUESTED_WITH = "X-Requested-With";
    private static final String XMLHttpRequest = "XMLHttpRequest";
    public static boolean isAjax(HttpServletRequest request) {
        String header = request.getHeader(REQUESTED_WITH);
        return XMLHttpRequest.equals(header);
    }
}
