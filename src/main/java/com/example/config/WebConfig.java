//package com.example.config;
//
//
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.ListableBeanFactory;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
//import org.springframework.boot.autoconfigure.web.ResourceProperties;
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
//
////import org.springframework.boot.autoconfigure.web.servlet.WelcomePageHandlerMapping;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.validation.MessageCodesResolver;
//import org.springframework.validation.Validator;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.config.annotation.*;
//import org.springframework.web.servlet.view.BeanNameViewResolver;
//import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//import java.util.List;
//
//@Configuration
//public class WebConfig extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {
//
//    public WebConfig(ResourceProperties resourceProperties, WebMvcProperties mvcProperties, ListableBeanFactory beanFactory, HttpMessageConverters messageConverters, ObjectProvider<WebMvcAutoConfiguration.ResourceHandlerRegistrationCustomizer> resourceHandlerRegistrationCustomizerProvider) {
//        super(resourceProperties, mvcProperties, beanFactory, messageConverters, resourceHandlerRegistrationCustomizerProvider);
//    }
//
////    @Override
////    public WelcomePageHandlerMapping welcomePageHandlerMapping(ApplicationContext applicationContext) {
////        return super.welcomePageHandlerMapping(applicationContext);
////    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//    }
//
//
//
//    @Override
//    public void setResourceLoader(ResourceLoader resourceLoader) {
//        super.setResourceLoader(resourceLoader);
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//    }
//
//    @Override
//    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        super.configureAsyncSupport(configurer);
//    }
//
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        super.configurePathMatch(configurer);
//    }
//
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        super.configureContentNegotiation(configurer);
//    }
//
//    @Override
//    public InternalResourceViewResolver defaultViewResolver() {
//        return super.defaultViewResolver();
//    }
//
//    @Override
//    public BeanNameViewResolver beanNameViewResolver() {
//        return super.beanNameViewResolver();
//    }
//
//    @Override
//    public ContentNegotiatingViewResolver viewResolver(BeanFactory beanFactory) {
//        return super.viewResolver(beanFactory);
//    }
//
//    @Override
//    public LocaleResolver localeResolver() {
//        return super.localeResolver();
//    }
//
//    @Override
//    public MessageCodesResolver getMessageCodesResolver() {
//        return super.getMessageCodesResolver();
//    }
//
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        super.addFormatters(registry);
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        super.addResourceHandlers(registry);
//    }
//
//
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//
//    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//
//    }
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//
//    }
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//
//    }
//
//    @Override
//    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
//
//    }
//
//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//
//    }
//
//    @Override
//    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
//
//    }
//
//    @Override
//    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
//
//    }
//
//    @Override
//    public Validator getValidator() {
//        return null;
//    }
//}
