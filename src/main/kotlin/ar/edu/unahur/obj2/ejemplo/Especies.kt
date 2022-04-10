package ar.edu.unahur.obj2.ejemplo

open class Menta(override val anioObtencion: Int, override val altura: Double) : PlantaInterfaz{
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

open class Soja(override val anioObtencion: Int, override val altura: Double) : PlantaInterfaz{
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

class Quinoa(override val anioObtencion: Int, override val altura: Double, val espacio: Double) : PlantaInterfaz{
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
        return parcela.plantadas.all{p: PlantaInterfaz -> p.altura < 1.5 }
    }
}

//Variedades

class SojaTrangenica(anioObtencion: Int, altura: Double): Soja(anioObtencion, altura){
    override fun daSemillas() = false
    override fun parcelaIdeal(parcela: Parcela): Boolean {
        return parcela.cantidadMaxima() == 1
    }
}

class Peperina(anioObtencion: Int, altura: Double) : Menta(anioObtencion, altura){
    override fun espacio() = super.espacio() * 2
}

