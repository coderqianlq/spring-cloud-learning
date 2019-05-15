package com.qianlq.eurekacustomer.configuration.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author qianliqing
 * @date 2018-09-28 下午1:29
 * mail: qianlq0824@gmail.com
 * <p>
 * druid过滤器
 */

@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
        }
)
public class DruidStatFilter extends WebStatFilter {
}
