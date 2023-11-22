package com.markruler.legacy.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
// @PropertySource("classpath:application.yaml") // @Value 사용을 위한 설정
// @EnableAspectJAutoProxy // AspectJ를 사용하기 위한 설정
// @ComponentScan(
//         basePackages = {"com.markruler"},
//         useDefaultFilters = false,
//         includeFilters = {
//                 @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Component.class)
//         }
// )
public class WebConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder
                .json()
                .createXmlMapper(false)
                // .dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm"))
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                // .modules(new JavaTimeModule())
                .build();
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");

        resolver.setMaxInMemorySize(10 * 1024 * 1024); // 10MB. file-size-threshold; default: 10KB (10240 bytes)
        resolver.setMaxUploadSize(1024 * 1024 * 1024 * 1024L);
        resolver.setMaxUploadSizePerFile(1024 * 1024 * 1024 * 1024L);
        // resolver.setResolveLazily(true);
        return resolver;
    }

}
