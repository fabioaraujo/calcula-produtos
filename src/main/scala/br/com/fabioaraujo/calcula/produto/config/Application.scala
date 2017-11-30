package br.com.fabioaraujo.calcula.produto.config;

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = Array("br.com.fabioaraujo"))
@EnableJpaRepositories(Array("br.com.fabioaraujo"))
@EntityScan(Array("br.com.fabioaraujo"))
class Application
object Application extends App {
    SpringApplication.run(classOf[Application]);
}