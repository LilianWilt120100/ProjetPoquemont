package application;

/**
 * classe qui modelise un dresseur de Poquemont
 */

public class Dresseur {

    String nom;
    int posX, posY, pv;
    Poquemont poquemontDresse;
    Arene arene;
    public Dresseur(Arene pArene) {
        this.nom = "Sacha";
        this.posX = 0;
        this.posY = 0;
        this.pv = 5;
        this.poquemontDresse = null;
        this.arene=pArene;

    }

    public Dresseur(String pNom, int departX, int departY, Arene pArene) {
        this.nom = pNom;
        this.pv = 5;
        this.poquemontDresse=null;
        this.arene=pArene;
        if (pArene.etreAccessible(departX, departY) == true) {
            this.posX = departX;
            this.posY = departY;
        } else {
            this.posX = 0;
            this.posY = 0;
        }


    }

    /**
     * méthode qui retourne le poquemont capturé par le dresseur
     */
    public Poquemont getPoquemontDresse() {
        return poquemontDresse;
    }

    /**
     * methode qui retourne les points de vie du dresseur
     */

    public int getPv() {
        return pv;
    }

    /**
     * methode qui retourne le nom du Dresseur
     */

    public String getNom() {
        return nom;
    }

    /**
     * methode qui retourne l'arene dans laquelle le dresseur évolue
     */

    public Arene getArene() {
        return arene;
    }

    /**
     * methode qui retourne la position du dresseur dans l'arene selon l'axe des abscisses
     */
    public int getPosX() {
        return posX;
    }

    /**
     * methode qui retourne la position du dresseur dans l'arene selon l'axe des ordonnees
     */
    public int getPosY() {
        return posY;
    }

    /**
     * methode qui permet au dresseur de prendre un poquemont et d'attaquer avec
     */

    public boolean prendrePoquemont(Poquemont poq) {
        if (poq == null || this.etreBlesse() != false || this.poquemontDresse != null || !poq.etrePris(this)) {

            return false;

        } else {
            poq.etrePris(this);
            this.poquemontDresse=poq;
            return true;
        }
    }

    /**
     * methode qui met à jour les attributs du poquemont déposé
     */
    public boolean deposerPoquemont() {
        if (this.etreBlesse() != false || this.poquemontDresse == null){
            return false;
        }else{


            this.poquemontDresse.etreDepose();
            this.poquemontDresse=null;
        }
        return true;
    }

    /**
     * methode qui fait varier la position du dresseur
     * @param dx
     * @param dy
     */
    public void seDeplacer(int dx, int dy) {
        if (Math.abs(dx + dy) == 1 && this.arene.etreAccessible(this.posX + dx, this.posY + dy) == true && this.etreBlesse() == false) {
            this.posX = this.posX + dx;
            this.posY = this.posY + dy;
        }
        if (poquemontDresse != null) {
            this.poquemontDresse.changerPosition();
            poquemontDresse.posX=getPosX();
            poquemontDresse.posY=getPosY();

        }
    }

    /**
     * methode qui reduit les pv du dresseur
     * @param degat
     */
    public void subirDegats(int degat) {
        if(this.pv<0){
            this.pv = 0;
        }
        if (degat >= 0) {
           this.pv=this.pv-degat;
        }

    }

    /**
     * methode qui annonce que le dresseur est bleesé à zéro point de vie
     * @return
     */
    public boolean etreBlesse() {
        if (this.pv > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * methode qui retourne les degats de l'attaque du dresseur
     * @return
     */
    public int getDegats() {
        int degats;
        if (poquemontDresse != null) {
            degats = poquemontDresse.getDegats();
        } else {
           degats = 1;

        }
        return degats;
    }

    /**
     * methode qui retourne la portée de l'attaque du dresseur
     * @return
     */

        public int getPortee () {
        int portee;
        if (poquemontDresse != null) {
            portee = poquemontDresse.getPortee();
        }
        else {
            portee = 1;
        }
            return portee;
    }

    /**
     * methode qui retourne la distance entre this et le dresseur
     * @param victime
     * @return
     */

    public int getDistance(Dresseur victime) {
      int distance;
        if (this.getArene() == victime.getArene()){
            distance = Math.abs(this.posY - victime.posY)+ Math.abs(this.posX - victime.posX);
        }else{
            distance = 0;
        }
        return distance;

    }

    /**
     * methode qui retire les degats de l'attaque aux points de vie de la cible
     * @param victime
     * @return
     */
    public boolean attaquer(Dresseur victime) {
        if (this.etreBlesse() != false || this.arene != victime.arene || this.getPortee() < this.getDistance(victime)){
        return false;
    }else{
        victime.subirDegats(this.getDegats());
    }
    if (victime.etreBlesse()==true){
        victime.pv=0;
    }
        return true;

    }

    /**
     * methode qui affiche le statut du dresseur
     * @return
     */
    public String toString() {
        String s= "dresseur(" + this.nom + ":" + this.pv + ")";
        if (this.poquemontDresse != null){
            s = s + this.poquemontDresse.toString();
        }
        return s;
    }
}
