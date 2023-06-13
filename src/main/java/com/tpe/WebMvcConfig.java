package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.tpe")   //defaultta da com.tpe
@EnableWebMvc               // SpringWebMvc olusturucagımız için

public class WebMvcConfig implements WebMvcConfigurer {

    //View name e karşılık gelen dosyasının (jsp) çözümlenmesini sağlayan yapı:view resolver
    //view resolver ı tanımladık
    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);   // JstlView.class = JavaStansdatTagLibrary jsp dosyaları içindeki
                                                // HTML taglerini kullanarak daha az kod yazmamızı sağlar.
        resolver.setPrefix("/WEB-INF/views/");  // view dosyalarım nerede belirtmek gerekiyo(dizin)
        resolver.setSuffix(".jsp");             //dosyalarımın uzantısı nedir belirtmek gerekiyo
        return resolver;
    }




    //kullanıcıdan statik istek geldiğinde statik
    // bir cvp verilecekse web server tarafından hazır dosya direk gönderiliyor
    //css,image gibi statik olan kaynakların dispatcher servlete gönderilmesine gerek yok
    //doğrudan otomatik cevaplansın
    //classı  WebMvcConfigurer  implement ediyoruz
    //asağıdaki methodu override ettik doldurduk

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").//bu pathdeki dosyaları statik olarak sun
                addResourceLocations("/resources/").  //lokasyon belirttik
                setCachePeriod(0);//cacheleme için belirli bir periyod süresi verilebilir
    }
}
