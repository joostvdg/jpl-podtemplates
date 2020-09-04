function loadPodTemplateYamls() {
  props = readProperties file:'catalog.properties'
  return libraryResource(props.agentyaml)
}
