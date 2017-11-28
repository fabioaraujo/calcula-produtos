package br.com.fabioaraujo.calcula.produto.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = Array("br.com.fabioaraujo"))
class Application
object Application extends App {
    SpringApplication.run(classOf[Application]);
}