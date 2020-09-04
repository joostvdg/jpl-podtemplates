function call() {
  println '==> loadPodTemplateYamls'
  println ' => reading catalog.properties'
  def props = readProperties file:'catalog.properties'
  println " => found agent definition ${props.agentyaml}"
  return libraryResource(props.agentyaml)
}
