describe('Sistema de Pagos ARI test', function() {
  it('Should load', function() {
    browser.get('http://localhost:4200/');

    expect(browser.getTitle()).toEqual('Sistema de Pagos ARI');
  });
  
  it('Registrar Usuario', function() {
    browser.get('http://localhost:4200/pagos/usuarios');
	var documento = parseFromString(Math.random()*100);
	element(by.name('nombre')).sendKeys("Nombre Prueba");
	element(by.name('apellido')).sendKeys("Apellido Prueba");
	element(by.name('documento')).sendKeys("documento");
	element(by.name('correo')).sendKeys("prueba@correo.com");
	element(by.name('guardar')).click();
    expect(element(by.name('trm')).isDisplayed()).toBeTruthy();    
  });
  
});