//package com.example.demo;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Type;
//
//@Component
//public class MultipartJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {
//    /**
//     * Multipart Jackson2 HttpMessage Converter.
//     *
//     * @param objectMapper object mapper
//     */
//
//    public MultipartJackson2HttpMessageConverter(ObjectMapper objectMapper) {
//        super(objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false), MediaType.MULTIPART_FORM_DATA);
//    }
//
//    @Override
//    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
//        return false;
//    }
//
//    @Override
//    public boolean canWrite(Type type, Class<?> clazz, MediaType mediaType) {
//        return false;
//    }
//
//    @Override
//    protected boolean canWrite(MediaType mediaType) {
//        return false;
//    }
//}
