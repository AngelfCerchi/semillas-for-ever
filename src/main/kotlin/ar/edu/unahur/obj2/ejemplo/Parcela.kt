package ar.edu.unahur.obj2.ejemplo

class Parcela(
    override val ancho: Double,
    override val largo: Double,
    override val horasSolRecibidas: Int,
    override val plantadas: MutableCollection<Planta> = mutableListOf()
):ParcelaInterfaz{

    override fun superficie(): Double {
        return ancho*largo
    }
    override fun cantidadMaxima(): Int {
        return if(this.ancho > largo) (this.superficie()/5).toInt() else ((superficie()/3) + largo).toInt()
    }

    override fun tieneComplicaciones(): Boolean {
        return this.plantadas.all{ p: Planta -> p.horasDeSolToleradas() < this.horasSolRecibidas}
    }

    override fun plantar(planta:Planta){
        if (this.sePuedePlantar()){
            this.plantadas.add(planta)
        }else{
            error("No se puede plantar")
        }
    }


}