resolvers ++= Seq("Sonatype snapshots"  at "http://oss.sonatype.org/content/repositories/snapshots/","Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases/",
 "softprops-maven" at "http://dl.bintray.com/content/softprops/maven",
 "untyped" at "http://ivy.untyped.com")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")