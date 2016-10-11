package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import example.Example;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.littleshoot.proxy.DefaultHttpProxyServer;
import org.littleshoot.proxy.HttpFilter;
import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.HttpResponseFilters;

import java.io.IOException;
import java.nio.charset.Charset;

public class ProxyServerUtils {
    private static HttpProxyServer httpProxyServer;

    public static void startServer() throws IOException {
        HttpResponseFilters responseFilter = new HttpResponseFilters() {
            public HttpFilter getFilter(String s) {
                return new HttpFilter() {
                    public HttpResponse filterResponse(HttpRequest httpRequest, HttpResponse httpResponse) {

                        if (httpRequest.getUri().contains("PriceAvailability?SKU=0500285&")) {
                            try {
                                ObjectMapper objectMapper = new ObjectMapper();
                                Example example =  objectMapper.readValue(httpResponse.getContent().array(), Example[].class)[0];
                                example.setPrice(108.8);
                                httpResponse.setContent(ChannelBuffers.copiedBuffer(objectMapper.writeValueAsString(example), Charset.defaultCharset()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println( new String(httpResponse.getContent().array()));
                        }
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
