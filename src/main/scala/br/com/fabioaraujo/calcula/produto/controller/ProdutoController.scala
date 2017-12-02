package br.com.fabioaraujo.calcula.produto.controller

import br.com.fabioaraujo.calcula.produto.dto.Produto
import br.com.fabioaraujo.calcula.produto.service.ProdutoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(path = Array("produto"))
class ProdutoController(@Autowired val produtoService: ProdutoService) {

  @PostMapping(path = Array("criar"))
  @ResponseBody
  def criar(@RequestBody produto: Produto): Produto = {
    val id = produtoService.criar(produto)
    produto.setId(id)
    produto
  }

  @GetMapping(path = Array("getById"))
  @ResponseBody
  def getProduto(@RequestParam id: Long): Produto = {
    produtoService.getProduto(id)
  }

  @GetMapping(path = Array("listar"))
  @ResponseBody
  def listar(): java.lang.Iterable[Produto] = {
    produtoService.listar()
  }
}