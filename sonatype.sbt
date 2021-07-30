homepage := Some(url("https://github.com/kornev/kornev-luaj-lib"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/kornev/kornev-luaj-lib"),
    "git@github.com:kornev/kornev-luaj-lib.git"
  )
)
developers := List(
  Developer("kornev", "Vadim Kornev", "kornev@zoho.com", url("https://github.com/kornev"))
)
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
publishMavenStyle := true

sources in (Compile, doc) := Seq.empty

sonatypeCredentialHost := "s01.oss.sonatype.org"
sonatypeRepository := "https://s01.oss.sonatype.org/service/local"
publishTo := sonatypePublishToBundle.value
