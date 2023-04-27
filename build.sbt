val scalaJsIOVersion = "0.4.3"
val apiVersion = scalaJsIOVersion
val theScalaVersion = "2.13.10"

//homepage := Some(url("https://github.com/scalajs-io/express"))

lazy val root = (project in file(".")).
  enablePlugins(ScalaJSPlugin).
  settings(
    name := "express",
    organization := "io.scalajs",
    description := "Fast, unopinionated, minimalist web framework",
      publish := {},
      resolvers += Resolver.sonatypeRepo("releases"),
    version := apiVersion,
    scalaVersion := theScalaVersion,
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-language:implicitConversions", "-Xlint"),
    scalacOptions in(Compile, doc) ++= Seq("-no-link-warnings"),
    //scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    autoCompilerPlugins := true,
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.ESModule) },
    libraryDependencies += "org.scala-lang" % "scala-reflect" % theScalaVersion % Provided,
    libraryDependencies += "net.exoego" %%% "scala-js-nodejs-v16" % "0.14.0"
//	    "org.scalatest" %%% "scalatest" % "3.0.1" % "test",
//	    "io.scalajs" %%% "nodejs-core" % scalaJsIOVersion
  )

// loads the Scalajs-io root project at sbt startup
//onLoad in Global := (Command.process("project root", _: State)) compose (onLoad in Global).value
