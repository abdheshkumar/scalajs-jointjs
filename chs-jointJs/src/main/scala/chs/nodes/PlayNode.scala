package chs.nodes

import chs.dialogs.PlayNodeDialog
import japgolly.scalajs.react.vdom.html_<^
import joint.Props
import joint.dia._
import joint.shapes.devs.{Extender, ExtenderOps, ModelOptions}

import scala.scalajs.js

@js.native
trait PlayNode extends BaseNode

object PlayNode extends ExtenderOps {

  class PlayNodePrototypeProperties() extends PrototypeProperties {
    val dialog: js.Function1[Props, html_<^.VdomElement] = (props) => PlayNodeDialog(props)
  }

  private val options = new ModelOptions {
    outPorts = js.Array("out1", "out2", "out3")
    inPorts = js.Array("in")
    attrs = js.Dictionary(".label" -> new AttrStyle {
      text = "Play Node"
      `ref-x` = .5
      `ref-y` = .2
    })
  }
  private val playClass = BaseNode.extender.define("chs.PlayNode", options, new PlayNodePrototypeProperties)

  override val extender: Extender = playClass.asInstanceOf[Extender]

  def apply(options: js.UndefOr[ModelOptions] = js.undefined): PlayNode =
    js.Dynamic.newInstance(playClass)(options).asInstanceOf[PlayNode]
}