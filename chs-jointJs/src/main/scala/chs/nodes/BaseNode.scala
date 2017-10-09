package chs.nodes

import chs.dialogs.PlayNodeDialog
import japgolly.scalajs.react.vdom.html_<^
import joint.Props
import joint.dia._
import joint.shapes.devs._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel

@js.native
trait BaseNode extends Model

@JSExportTopLevel("joint.shapes.chs.BaseNode")
object BaseNode extends ExtenderOps {

  class BaseNodePrototypeProperties extends PrototypeProperties {
    val dialog: js.Function1[Props, html_<^.VdomElement] = (props) => PlayNodeDialog(props)
  }


  private val options = new ModelOptions {
    position = new Position {
      x = 50
      y = 150
    }
    size = new Size {
      width = 90
      height = 90
    }
    ports = new PortOptions {
      groups = new GroupOptions {
        in = new Options {
          attrs = js.Dictionary(".port-body" -> new AttrStyle {
            fill = "#16A085"
            magnet = "passive"
          })
        }
        out = new Options {
          attrs = js.Dictionary(".port-body" -> new AttrStyle {
            fill = "#E74C3C"
          })
        }
      }
    }
    attrs = js.Dictionary(
      ".label" -> new AttrStyle {
        text = "Base Node"
        `ref-x` = .5
        `ref-y` = .2
      },
      "rect" -> new AttrStyle {
        fill = "#2ECC71"
      },
      ".tool-options" -> new AttrStyle {
        `ref-dx` = -70
        `ref-dy` = -30
        `ref-y` = 15
        cursor = "pointer"
      },
      ".tool-options>circle" -> new AttrStyle {
        r = 10
        fill = "black"
        stroke = "#333"
        `stroke-width` = 1
      },
      "path" -> new AttrStyle {
        d = "M31.229,17.736c0.064-0.571,0.104-1.148,0.104-1.736s-0.04-1.166-0.104-1.737l-4.377-1.557c-0.218-0.716-0.504-1.401-0.851-2.05l1.993-4.192c-0.725-0.91-1.549-1.734-2.458-2.459l-4.193,1.994c-0.647-0.347-1.334-0.632-2.049-0.849l-1.558-4.378C17.165,0.708,16.588,0.667,16,0.667s-1.166,0.041-1.737,0.105L12.707,5.15c-0.716,0.217-1.401,0.502-2.05,0.849L6.464,4.005C5.554,4.73,4.73,5.554,4.005,6.464l1.994,4.192c-0.347,0.648-0.632,1.334-0.849,2.05l-4.378,1.557C0.708,14.834,0.667,15.412,0.667,16s0.041,1.165,0.105,1.736l4.378,1.558c0.217,0.715,0.502,1.401,0.849,2.049l-1.994,4.193c0.725,0.909,1.549,1.733,2.459,2.458l4.192-1.993c0.648,0.347,1.334,0.633,2.05,0.851l1.557,4.377c0.571,0.064,1.148,0.104,1.737,0.104c0.588,0,1.165-0.04,1.736-0.104l1.558-4.377c0.715-0.218,1.399-0.504,2.049-0.851l4.193,1.993c0.909-0.725,1.733-1.549,2.458-2.458l-1.993-4.193c0.347-0.647,0.633-1.334,0.851-2.049L31.229,17.736zM16,20.871c-2.69,0-4.872-2.182-4.872-4.871c0-2.69,2.182-4.872,4.872-4.872c2.689,0,4.871,2.182,4.871,4.872C20.871,18.689,18.689,20.871,16,20.871z"
        fill = "white"
        transform = "scale(.55) translate(29, -16)"
      },
      "circle" -> new AttrStyle {
        transform = "translate(25)"
      })
  }
  private val nodeClass = Model.extender.define("chs.BaseNode", options, new BaseNodePrototypeProperties())

  override val extender = nodeClass.asInstanceOf[Extender]

  def apply(options: js.UndefOr[ModelOptions] = js.undefined): BaseNode =
    js.Dynamic.newInstance(nodeClass)(options).asInstanceOf[BaseNode]
}