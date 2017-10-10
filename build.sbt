lazy val commonSettings = Seq(
  version := Settings.version,
  organization := "co.uk.chs",
  scalaVersion := Settings.versions.scala,
  scalacOptions ++= Settings.scalacOptions
)

lazy val joint = (project in file("joinJs"))
  .settings(name := "joinJs")
  .settings(commonSettings)
  .settings(
    libraryDependencies ++= Settings.scalajsDependencies.value,
    scalaJSUseMainModuleInitializer := true,
    scalaJSUseMainModuleInitializer in Test := false,
    testFrameworks += new TestFramework("utest.runner.Framework")
  ).enablePlugins(ScalaJSPlugin)

lazy val `chs-jointJs` = (project in file("chs-jointJs"))
  .settings(name := "chs-jointJs")
  .settings(commonSettings)
  .settings(
    libraryDependencies ++= Settings.scalajsDependencies.value ++ Settings.chsDependencies.value
  ).dependsOn(joint).enablePlugins(ScalaJSPlugin)

lazy val `chs-web-app` = (project in file("."))
  .settings(commonSettings)
  .settings(name := "chs-web-app")
  .settings(
    libraryDependencies ++= Settings.scalajsDependencies.value,
    scalaJSUseMainModuleInitializer := true,
    artifactPath in(Compile, fastOptJS) := file("web-app/js/app.js"),
    artifactPath in(Compile, packageJSDependencies) := file("web-app/js/app.dep.js"),
    artifactPath in(Compile, packageMinifiedJSDependencies) := file("web-app/js/deps.min.js"),
    artifactPath in(Test, fastOptJS) := file("web-app/js/app.test.js"),
    artifactPath in(Test, fullOptJS) := file("web-app/js/app.min.test.js"),
    artifactPath in(Test, packageJSDependencies) := file("web-app/js/deps.test.js"),
    artifactPath in(Test, packageMinifiedJSDependencies) := file("web-app/js/deps.min.test.js"))
  .dependsOn(`chs-jointJs`).enablePlugins(ScalaJSPlugin)