// conf.js
exports.config = {
  //framework: 'jasmine',
  seleniumAddress: 'http://localhost:4444/wd/hub',
  specs: ['spec.js'],
  
  directConnect: true,
capabilities: {
  'browserName': 'chrome',
  'binary': 'C:/Program Files/Google/Chrome/Application/chrome.exe'
}
  

}


ompleted 405 METHOD_NOT_ALLOWED
7      : GET "/pagos/usuarios/buscar/?documento=722258", parameters={masked}