package com.baku.kafkascala

import com.typesafe.scalalogging.LazyLogging

import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App with LazyLogging {

  logger.debug("Running scala code...")
  MsgProducer.processMessages.andThen({
    case Success(_) =>
      logger.info("loading data")
      MsgConsumer.loadData
    case Failure(msg) => msg.printStackTrace()
  })

  while(true) {

  }

}
