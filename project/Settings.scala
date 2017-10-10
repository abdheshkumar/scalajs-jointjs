import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._

object Settings {

  /** The version of your application */
  val version = "1.0"

  /** Options for the scala compiler */
  val scalacOptions = Seq(
    "-Xlint",
    "-unchecked",
    "-deprecation",
    "-feature",
    "-P:scalajs:sjsDefinedByDefault"
  )

  /** Declare global dependency versions here to avoid mismatches in multi part dependencies */
  object versions {
    val scala = "2.12.3"
    val scalaDom = "0.9.2"
    val scalajsReact = "1.1.0"
    val scalaTags = "0.6.5"
    val uTest = "0.4.7"

    val react = "15.6.1"
    val akkaHttp = "10.0.9"
  }

  /** Dependencies for external JS libs that are bundled into a single .js file according to dependency order */
  val jsDependencies = Def.setting(Seq())

  /** Dependencies only used by the ScalaJs project */
  val scalajsDependencies = Def.setting(Seq(
    "org.scala-js" %%% "scalajs-dom" % versions.scalaDom,
    "be.doeraene" %%% "scalajs-jquery" % versions.scalaDom,
    "com.github.japgolly.scalajs-react" %%% "core" % versions.scalajsReact,
    "com.github.japgolly.scalajs-react" %%% "extra" % versions.scalajsReact,
    "com.lihaoyi" %%% "scalatags" % versions.scalaTags,
    "com.olvind" %%% "scalajs-react-components" % "0.8.0",
    "com.lihaoyi" %%% "utest" % versions.uTest % "test"
  ))
  /** Dependencies only used by the JVM project */
  val chsDependencies = Def.setting(Seq(
    "com.chs" %%% "com.chs.protocols" % "0.01"
  ))
}
