package br.com.fabioaraujo.calcula.produto.dto

import scala.beans.BeanProperty

case class Status(@BeanProperty var online: String = "true")