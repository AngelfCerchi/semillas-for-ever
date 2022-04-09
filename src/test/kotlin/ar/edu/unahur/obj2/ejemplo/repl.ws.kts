import ar.edu.unahur.obj2.ejemplo.Parcela
import ar.edu.unahur.obj2.ejemplo.Soja


// Pueden usar este archivo para hacer pruebas rápidas,
// de la misma forma en que usaban el REPL de Wollok.

// OJO: lo que esté aquí no será tenido en cuenta
// en la corrección ni reemplaza a los tests.

val parcela = Parcela(20.0, 1.0, 9)
val soja = Soja(2008,1.0)
parcela.plantar(soja)
parcela.plantar(soja)
parcela.plantar(soja)
parcela.plantar(soja)
parcela.plantar(soja)
parcela.plantar(soja)
parcela.plantar(soja)
soja.horasDeSolToleradas()