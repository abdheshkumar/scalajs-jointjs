package chs.nodes

import chs.dialogs.GatherNodeDialog
import japgolly.scalajs.react.vdom.html_<^
import joint.Props
import joint.dia._
import joint.shapes.devs.{Extender, ExtenderOps, ModelOptions}

import scala.scalajs.js

@js.native
trait GatherNode extends BaseNode

object GatherNode extends ExtenderOps {

  class GatherNodePrototypeProperties() extends PrototypeProperties {
    val dialog: js.Function1[Props, html_<^.VdomElement] = (props) => GatherNodeDialog(props)
  }

  private val options = new ModelOptions {
    inPorts = js.Array[String]("in")
    outPorts = js.Array("out1")
    attrs = js.Dictionary(".label" -> new AttrStyle {
      text = "Gather Node"
      `ref-x` = .5
      `ref-y` = .2
    })
  }
  private val gatherClass = BaseNode.extender.define("chs.GatherNode", options, new GatherNodePrototypeProperties)

  override val extender: Extender = gatherClass.asInstanceOf[Extender]

  def apply(options: js.UndefOr[ModelOptions] = js.undefined): GatherNode =
    js.Dynamic.newInstance(gatherClass)(options).asInstanceOf[GatherNode]
}