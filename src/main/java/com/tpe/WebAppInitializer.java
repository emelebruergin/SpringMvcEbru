package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xml yerine confg. için bu classı kullancaz.
//bu classta hedefimiz=dispatcher servletin tanımlanması,configuration classlarının yerini gösterme
//
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // extends ettik dispatcher servletin i baslatmak için,spring mvc i baslatmak için .
    //ve içindeki abstract classlar confg classların yerini sağlamak için
    //Dispatcher ın içinde iki tane context vardır
    //Servlet WebAppContext=Controller,Handler mapping,view resolver
    //Root WebAppContext=db e erişimle ilgili olan katmanların oldugu kısım: repositories,services
    @Override
    protected Class<?>[] getRootConfigClasses() { //db e erişim (hibernate/jdbc) lerin confg ayarlarını bu methodda göstermek gerekiyor
        return new Class[]{
                RootContexConfig.class
        };          //RootContexConfig classı olusturdum
    }

    @Override //dicpatcher içindeki servlet Controller,Handler mapping,view resolver(Springmvc) için confg.ayarları için method
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebMvcConfig.class // Config class olusturup class adını buraya yazıyoruz config ayarlarını ceksin diye
        };
    }

    @Override // hangi url ile gelen istekler servelt tarafından karsılanıcak
    protected String[] getServletMappings() {
        return new String[]{"/"};//{"/"} yazarak = / ile gelen tüm istekleri karsıla demek istedim
    }


}
