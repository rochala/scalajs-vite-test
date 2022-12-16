import org.scalajs.linker.interface.ModuleSplitStyle

val publicDev = taskKey[String]("output directory for dev server")
val publicProd = taskKey[String]("output directory for build")

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "$name$",
    scalaVersion := "3.2.0",
    scalacOptions ++= Seq("-encoding", "utf-8", "-deprecation", "-feature"),

    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("example")))
    },

    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.3.0",

    publicDev := linkerOutputDirectory((Compile / fastLinkJS).value).getAbsolutePath(),
    publicProd := linkerOutputDirectory((Compile / fullLinkJS).value).getAbsolutePath(),
  )

def linkerOutputDirectory(v: Attributed[org.scalajs.linker.interface.Report]): File = {
  v.get(scalaJSLinkerOutputDirectory.key).getOrElse {
    throw new MessageOnlyException(
        "Linking report was not attributed with output directory. " +
        "Please report this as a Scala.js bug.")
  }
}
