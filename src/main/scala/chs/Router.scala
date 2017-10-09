package chs

import japgolly.scalajs.react.extra.router.{BaseUrl, Redirect, Router, RouterConfigDsl}
import org.scalajs.dom

import scala.scalajs.js.JSApp

object RouterApp extends JSApp {

  val config = RouterConfigDsl[AppPage].buildConfig {
    dsl =>
      import dsl._
      (staticRoute(root, JointJs) ~> render(JointJsPage()))
        .notFound(redirectToPage(Home)(Redirect.Replace))
  }

  val baseUrl: BaseUrl = BaseUrl.until_#

  val router: Router[AppPage] = Router(baseUrl, config)

  override def main(): Unit = {
    router().renderIntoDOM(dom.document.getElementById("playground"))
  }

}


