import java.net.InetSocketAddress

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer

object SimpleHttpServer {
  def main(args: Array[String]) {
    var server = HttpServer.create(new InetSocketAddress(8000), 0)
    server.setExecutor(null)
    server.createContext("/", new IndexHandler)
    server.start
  }
}

class IndexHandler extends HttpHandler {
   def handle(t: HttpExchange) {
     var response = "index"
     t.sendResponseHeaders(200, response.length)
     t.getResponseBody.write(response.getBytes)
     t.getResponseBody.close
   }
}
