import akka.actor.{ Actor, ActorSystem, Props }
import dispatch.{ Http, as, url }

object Main {
  def main(args: Array[String]) {
    implicit val system = ActorSystem("dispatcher-sample")
    val ma = system.actorOf(Props[MainActor], "main")
    ma ! 'exec
  }
}
class MainActor extends Actor {
  import context.dispatcher
  override def receive = {
    case 'exec => {
      val svc = url("http://www.google.co.jp/")
      for {
        response <- Http(svc OK as.String)
      } {
        println(response.length)
        context.stop(self)
        context.system.shutdown()
      }
    }
  }
}
