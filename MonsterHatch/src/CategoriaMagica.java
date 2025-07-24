public class CategoriaMagica extends Pokemon{
    private int mana; //Cantidad de maná que posse el pokemon.
    private int manaMaximo; //Limite de maná maximo que tiene el pokemon.   
    private int regeneracionMana; //Sera el comportamiento pasivo que posee la categoria magica, entonces en cada nuevo turno que ha atacado restablece el 10% del mana.


    public CategoriaMagica(String nombre, int vida, int ataque, int defensa, EstrategiaBatalla estrategia, int manaMaximo) {
        super(nombre, vida, ataque, defensa, estrategia, manaMaximo);
        this.manaMaximo = manaMaximo;
        this.mana = manaMaximo;
        this.regeneracionMana = calcularRegeneracionMana(); //Calcular la regeneracion del 10% del maná maximo del pokemon.

    }

    /**Este codigo es para determinar el valor de regeneracion de mana:
     * Calcula la regeneracion de maná con el 10% del valor que se puso en maná máximo
     * Ademas por seguridad asegura que sea al menos 1 punto por turno, siendo predeterminado
     */
    private int calcularRegeneracionMana() {
        int regeneracion = (int)(manaMaximo * 0.1); //Agarra del 10% del maná máximo.
        return Math.max(1, regeneracion); //que al menos tenga 1 punto de maná por turno.
    }

    //Metodo para actualizar el maná maximo y para poder recalcular ese valor.
      public void setManaMaximo(int nuevoMaximo) {
        this.manaMaximo = nuevoMaximo;
        this.regeneracionMana = calcularRegeneracionMana(); //Recalcula la regeneración para mantener la proporción del 10% del maná maximo.
    }

    //Ahora para regenerar el maná se debe sobreescribir el metodo ejecutarAccion antes de actuar, ya que este da error y no se ejecuta.
    @Override
    public void ejecutarAccion(Pokemon enemigo) {
        regenerarMana();  //Se pondria como prioritario regenerar mana.
        super.ejecutarAccion(enemigo);  //Ahora si se ejecuta la acción segun su estrategia dada.
    }

    /**El comportamiento pasivo que posee la categoria magica:
     * Sera un metodo privado para esta categoria, siendo la unica que pueda regenerar maná en cada turno
     * Añadiendo que esta aumenta el maná actual que posee en la batalla hasta el limite maximo de manaMaximo que se puso
     * Esto para que no aumente el maná en la primera ronda y en las siguientes no sobre pase el limite establecido
     */
    private void regenerarMana() {
        mana = Math.min(mana + regeneracionMana, manaMaximo);
        System.out.println(getNombre() + " regenera " + regeneracionMana + " de maná (" + (int)(regeneracionMana * 100.0 / manaMaximo) + "%). Maná actual: " + mana);
    }

     /**Metodo al momento que la criatura use el maná:
     * @param cantidad La cantidad de maná a consumir.
     * @return true si habia suficiente maná y se consumio, false en caso contrario.
     */
    public boolean usarMana(int cantidad) {
        if (mana >= cantidad) {
            mana -= cantidad;
            System.out.println(getNombre() + " usa " + cantidad + " de maná. Maná restante: " + mana);
            return true;
        }
        System.out.println(getNombre() + " no tiene suficiente maná para usar esta habilidad");
        return false;
    }

    //Getter para obtener el valor del maná.
    public int getMana() {
        return mana;
    }

    //Getter para obtener el valor del maná maximo.
    public int getManaMaximo() {
        return manaMaximo;
    }
}
