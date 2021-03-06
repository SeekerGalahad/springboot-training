package autoconfig;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Wagic
 * @Description:
 * @Date: 2019-04-28 09:59 by Wagic 创建
 */
@Configuration
@ConditionalOnClass({HttpClient.class})
@EnableConfigurationProperties(HttpClientProperties.class)
public class HttpClientAutoConfiguration {

    private final HttpClientProperties properties;

    public HttpClientAutoConfiguration(HttpClientProperties properties) {
        this.properties = properties;
    }

    /**
     * HttpClient Bean定义
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(HttpClient.class)
    public HttpClient httpClient() {
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(properties.getConnectTimeOut())
                .setSocketTimeout(properties.getSocketTimeOut()).build();
        HttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).setUserAgent(properties.getAgent())
                .setMaxConnPerRoute(properties.getMaxConnPerRoute())
                .setMaxConnTotal(properties.getMaxConnTotal())
                .setConnectionReuseStrategy(new NoConnectionReuseStrategy()).build();
        return httpClient;
    }
}
