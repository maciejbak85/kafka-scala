package com.baku.kafkascala

import akka.kafka.ProducerSettings
import akka.kafka.scaladsl.Producer
import akka.stream.scaladsl.Source
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.{ByteArraySerializer, StringSerializer}

import scala.concurrent.ExecutionContext

object MsgProducer {

  val producerSettings = ProducerSettings(system, new ByteArraySerializer, new StringSerializer)
    .withBootstrapServers("kafka:9092")

  val kafkaProducer = producerSettings.createKafkaProducer()

  def processMessages = Source(1 to 10)
    .map(_.toString)
    .map { elem =>
      println("Producing elem: "+elem)
      new ProducerRecord[Array[Byte], String]("topic1", elem)
    }
    .runWith(Producer.plainSink(producerSettings))
}
