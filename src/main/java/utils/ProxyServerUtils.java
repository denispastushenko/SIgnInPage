package utils;

import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.littleshoot.proxy.*;

public class ProxyServerUtils {
    private static HttpProxyServer httpProxyServer;

    public static void startServer() {
        HttpResponseFilters responseFilter = new HttpResponseFilters() {
            public HttpFilter getFilter(String s) {
                return new HttpFilter() {
                    public HttpResponse filterResponse(HttpRequest httpRequest, HttpResponse httpResponse) {
                        System.out.println(httpRequest.getUri());
                        return httpResponse;
                    }

                    public int getMaxResponseSize() {
                        return Integer.MAX_VALUE;
                    }

                    public boolean filterResponses(HttpRequest httpRequest) {
                        return true;
                    }
                };
            }
        };
        httpProxyServer = new DefaultHttpProxyServer(1128, responseFilter);
        httpProxyServer.start();
    }
}