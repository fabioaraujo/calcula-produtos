package br.com.fabioaraujo.calcula.produto.service

import br.com.fabioaraujo.calcula.produto.dao.ItemRepository
import br.com.fabioaraujo.calcula.produto.dto.Item
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ItemService(@Autowired val itemRepository: ItemRepository) {
  def listItens(): java.lang.Iterable[Item] = {
    itemRepository.findAll
  }

  def getItem(id: Long): Item = {
    itemRepository.findOne(id)
  }

  def createItem(item: Item): Long = {
    itemRepository.save(item)
    item.id
  }
}