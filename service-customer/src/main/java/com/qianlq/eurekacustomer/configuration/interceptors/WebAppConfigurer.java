package com.qianlq.eurekacustomer.configuration.interceptors;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.qianlq.eurekacustomer.interceptor.MonitorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-09-28 下午1:45
 * mail: qianlq0824@gmail.com
 * <p>
 * 配置自定义拦截器
 */

@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private MonitorInterceptor monitorInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(monitorInterceptor);
        super.addInterceptors(registry);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);

        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        // PrettyFormat:结果是否格式化，默认为false
        // WriteMapNullValue:是否输出值为null的字段，默认为false
        // DisableCircularReferenceDetect:消除对同一对象循环引用的问题，默认为false
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.DisableCircularReferenceDetect
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);

        converters.add(fastConverter);
    }

}
