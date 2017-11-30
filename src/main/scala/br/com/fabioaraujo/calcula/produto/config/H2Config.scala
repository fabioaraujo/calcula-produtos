package br.com.fabioaraujo.calcula.produto.config

import org.h2.server.web.WebServlet
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.{Bean, Configuration}


@Configuration
class H2Config {
  @Bean def h2servletRegistration(): ServletRegistrationBean = {
    val registrationBean = new ServletRegistrationBean(new WebServlet)
    registrationBean.addUrlMappings("/h2-console/*")
    return registrationBean
  }
}