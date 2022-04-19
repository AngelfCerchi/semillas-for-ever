package ar.edu.unahur.obj2.ejemplo

abstract class Planta(val anioObtencion: Int, val altura: Double){

    open fun horasDeSolToleradas() = 7
     fun esFuerte() = this.horasDeSolToleradas() >= 9

    open fun daSemillas(): Boolean {
        return this.esFuerte() || this.condicionAdicional()
    }
    abstract fun parcelaIdeal(parcela: Parcela) : Boolean

    abstract fun espacio(): Double
    abstract fun condicionAdicional(): Boolean


}
open class Menta(anioObtencion: Int, altura: Double) : Planta(anioObtencion, altura) {
    override fun espacio(): Double{
        return this.altura + 1
    }
    override fun condicionAdicional(): Boolean {
        return this.altura >0.4
    }
    override fun parcelaIdeal(parcela: Parcela): Boolean {
        return parcela.superficie() > 6
    }
}

open class Soja(anioObtencion: Int, altura: Double) : Planta(anioObtencion, altura){
    override fun espacio(): Double {
        return this.altura/2
    }
    override fun condicionAdicional(): Boolean {
        return this.anioObtencion > 2007 && this.altura in 0.75..0.9
    }
    override fun horasDeSolToleradas(): Int {
        val tolerancia: Int = if (this.altura < 0.5){
            6
        }else if(this.altura in 0.5..0.9){
            8
        }else{
            12
        }
         return tolerancia
    }
    override fun parcelaIdeal(parcela: Parcela): Boolean {
        return parcela.horasSolRecibidas == this.horasDeSolToleradas()
    }
}

class Quinoa(anioObtencion: Int, altura: Double, val espacio: Double) : Planta(anioObtencion, altura){
    override fun horasDeSolToleradas(): Int {
        val tolerancia: Int = if (this.altura < 0.3){
            10
        }else{
            super.horasDeSolToleradas()
        }
        return tolerancia
    }
    override fun espacio() = espacio

    override fun condicionAdicional(): Boolean {
        return this.anioObtencion in 2001..2008
    }
    override fun parcelaIdeal(parcela: Parcela): Boolean {
        return parcela.plantadas.all{p: Planta -> p.altura < 1.5 }
    }
}

//Variedades

class SojaTrangenica(anioObtencion: Int, altura: Double): Soja(anioObtencion,altura){
    override fun daSemillas() = false
    override fun parcelaIdeal(parcela: Parcela): Boolean {
        return parcela.cantidadMaxima() == 1
    }
}

class Peperina(anioObtencion: Int, altura: Double) : Menta(anioObtencion, altura){
    override fun espacio() = super.espacio() * 2
}

