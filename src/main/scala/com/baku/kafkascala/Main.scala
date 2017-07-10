package com.baku.kafkascala

import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {

  println("Running scala code...")
  MsgProducer.processMessages.andThen({
    case Success(_) =>
      println("loading data")
      MsgConsumer.loadData
    case Failure(msg) => msg.printStackTrace()
  })

  while(true) {

  }

}
