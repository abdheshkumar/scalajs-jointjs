package chs

import chandu0101.scalajs.react.components.materialui.MuiMuiThemeProvider
import chs.nodes.{BaseNode, GatherNode, PlayNode}
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.vdom.{TagOf, VdomElement}
import japgolly.scalajs.react.{BackendScope, Callback, CallbackTo, _}
import joint.Props
import joint.dia.{CellView, Graph}
import joint.shapes.devs.{Model, ModelOptions}
import org.scalajs.dom
import org.scalajs.dom.html.Div

import scala.scalajs.js
import scala.scalajs.js.JSON


sealed trait AppPage

case object Home extends AppPage

case object JointJs extends AppPage


object JointJsPage {

  case class State(isOpen: Boolean, cellView: js.UndefOr[CellView])

  class Backend($: BackendScope[Unit, State]) {

    val graph = new Graph()

    def buildGraph() = {


      val m1 = BaseNode(new ModelOptions {
        openDialog = js.defined((cellView) => open(cellView))
      })
      val m2 = PlayNode(new ModelOptions {
        openDialog = js.defined((cellView) => open(cellView))
      })

      val paper = DiagramUtility.createPaperLayout("#paper", graph)
      /* paper.on("element:pointerup", (cellView, event, _, _) => {

         dom.console.log(event.target)
         open(cellView)
       })*/


      val m3 = GatherNode()
      m2.translate(300, 0)
      m3.translate(0, 200)
      graph.addCell[ModelOptions, Model](m1)
      graph.addCell[ModelOptions, Model](m2)
      graph.addCell[ModelOptions, Model](m3)
    }

    val close = $.modState(_.copy(isOpen = false))

    private def open(cellView: CellView): Unit = {
      ($.setState(State(true, cellView)) >> Callback.log("Dialog Open")).runNow()
    }

    def getJson(S: State): CallbackTo[Unit] = Callback {
      dom.console.log(JSON.stringify(graph.toJSON()))
    }

    def render(S: State): TagOf[Div] = {
      val empty: VdomElement = ScalaComponent.static("EmptyComponent")(<.div(""))()
      val component = S.cellView.map(_.model).toOption.fold(empty)(_.dialog(Props(S.isOpen, S.cellView, close)))
      <.div(
        <.div(s"JointJs-React Template"),
        <.div(^.id := "paper", ""),
        <.div(^.id := "paper1", ""),
        MuiMuiThemeProvider()(<.div(component)),
        <.button(^.onClick --> getJson(S), "Get Json")
      )
    }
  }

  private val component = ScalaComponent.builder[Unit]("JointJsPage")
    .initialState(State(isOpen = false, js.undefined))
    .renderBackend[Backend]
    .componentDidMount(_f => Callback {
      _f.backend.buildGraph()
    }).build

  def apply(): VdomElement = component()
}

object HomePage {
  private val component =
    ScalaComponent.builder[Props]("HomePage")
      .render_P(p => {
        <.div(
          <.div(s"ScalaJS-React Template")
        )
      }
      ).build

  def apply(props: Props): VdomElement = component(props)
}