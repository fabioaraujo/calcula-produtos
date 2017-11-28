package br.com.fabioaraujo.calcula.produto.controller

import org.springframework.web.bind.annotation.{GetMapping, RestController}

@RestController
class UserController {
    @GetMapping(path = Array("/online"))
    def online(): String = {
        "online: true"
    }
}