package chs

import joint.V
import joint.dia._
import org.scalajs.dom
import org.scalajs.dom.raw.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel

package object views {
  @JSExportTopLevel("joint.shapes.chs.BaseNodeView")
  val BaseNodeView = ElementView.extender.extend(new ElementViewPrototype {
    events = js.Dictionary("click .tool-options" -> "onSettingsClick")
    var onSettingsClick: js.ThisFunction1[CellView, Event, Unit] = (cellview, event) => {
      cellview.model.attributes.openDialog.fold {
        dom.console.log(":::openDialog is defined:")
      } { fun => fun(cellview) }
    }
    renderMarkup = js.defined((cellView) => {
      val svg = joint.jointJs.util.template(cellView.asInstanceOf[js.Dynamic].constructor.markup.asInstanceOf[String])()
      val nodes = V(svg)
      cellView.vel.append(nodes)
    })
  }, new ElementViewStatic {
    markup =
      """<g class="rotatable">
      <rect class="body"/>
      <text class="label"/>
      <g class="tool-options">
        <circle r="11"/>
        <path/>
        <title>Setting</title>
      </g>
    </g>"""
  })

  @JSExportTopLevel("joint.shapes.chs.PlayNodeView")
  val PlayNodeView = BaseNodeView.asInstanceOf[ViewExtender].extend(static = new ElementViewStatic {
    markup =
      """<g class="rotatable">
      <rect class="body"/>
      <text class="label"/>
      <g class="tool-options">
        <circle r="11"/>
        <path/>
        <title>Play Node</title>
      </g>
    </g>"""
  })
}
