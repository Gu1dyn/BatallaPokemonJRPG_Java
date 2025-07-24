public class App {
    public static void main(String[] args) throws Exception {
            
        /**Creación del pokemon:
         * Se les da un nombre, las estaditicas y el tipo de comportamiento que usaran en el combate
        */

        Pokemon Frieren = new CategoriaMagica("Frieren", 50, 30, 8, new ComportamientoMagico(30, 20), 300);
        Pokemon Aura = new CategoriaMagica("Aura", 50, 10, 4, new ComportamientoMagico(20, 10), 100);

        System.out.println("\n===== INICIO DE LA SIMULACIÓN =====");

        System.out.println("Inicio de la batalla entre Frieren y Aura");
        Frieren.ejecutarAccion(Aura);
        Aura.ejecutarAccion(Frieren);

        System.out.println("\n===== FIN DE LA SIMULACIÓN =====");

    }
}
