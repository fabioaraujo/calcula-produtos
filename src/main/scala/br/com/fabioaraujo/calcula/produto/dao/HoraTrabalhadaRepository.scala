package br.com.fabioaraujo.calcula.produto.dao

import br.com.fabioaraujo.calcula.produto.dto.HoraTrabalhada
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
trait HoraTrabalhadaRepository extends CrudRepository[HoraTrabalhada, java.lang.Long] {

}