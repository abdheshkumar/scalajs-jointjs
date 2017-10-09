package chs.nodes

import chs.dialogs.StartNodeDialog
import japgolly.scalajs.react.vdom.html_<^
import joint.Props
import joint.dia._
import joint.shapes.devs.{Extender, ExtenderOps, ModelOptions}

import scala.scalajs.js

@js.native
trait StartNode extends BaseNode

object StartNode extends ExtenderOps {

  class StartNodePrototypeProperties() extends PrototypeProperties {
    val dialog: js.Function1[Props, html_<^.VdomElement] = (props) => StartNodeDialog(props)
  }

  private val options = new ModelOptions {
    inPorts = js.Array[String]()
    outPorts = js.Array("out1")
    attrs = js.Dictionary(".label" -> new AttrStyle {
      text = "Start Node"
      `ref-x` = .5
      `ref-y` = .2
    })
  }
  private val startClass = BaseNode.extender.define("chs.StartNode", options, new StartNodePrototypeProperties)

  override val extender: Extender = startClass.asInstanceOf[Extender]

  def apply(options: js.UndefOr[ModelOptions] = js.undefined): StartNode =
    js.Dynamic.newInstance(startClass)(options).asInstanceOf[StartNode]
}