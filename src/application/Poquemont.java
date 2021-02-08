package application;

/**
 * classe qui modelise un poquemont capturable par un dresseur
 */
public class Poquemont {
  int degats, portee, posX, posY;
  Arene arene;
  Dresseur porteur;

  public Poquemont(Arene pArene){
    this.degats=2;
    this.portee=2;
    this.posX=5;
    this.posY=5;
    this.porteur=null;
    this.arene=pArene;
  }
  public Poquemont(int x, int y, int pDegats, int pPortee, Arene pArene) {
      this.arene = pArene;
      if (pArene.etreAccessible(x,y) ==true){
          this.posX = x;
          this.posY = y;
      }else{
          this.posX = 0;
          this.posY = 0;
      }
      if (pDegats < 0) {
          this.degats = 0;
      } else {
          this.degats = pDegats;
      }
      if (pPortee < 0) {
          this.portee = 0;
      } else {
          this.portee = pPortee;
      }
  }
/**
methode qui retourne les degats du Poquemont
*/

  public int getDegats(){
    return degats;
  }

  /**
  methode qui retourne la portee du poquemont
  */

  public int getPortee(){
    return portee;
  }

  /**
  methode qui retourne le dresseur ayant capture le Poquemont
  */

  public Dresseur getPorteur(){
    return porteur;
  }

  /**
  methode qui retoune la position en abscisse du Poquemont
  */

  public int getPosX(){
    return posX;
  }

  /**
  methode qui retourne la position du poquemont en ordonnee
  */

  public int getPosY(){
    return posY;
  }

  /**
  methode qui retourne un booléen qui précise si le poquemont a été capturé ou non
   * @param dresseur
   * @return
  */

  public boolean etrePris(Dresseur dresseur){
if (this.porteur==null && (this.arene==dresseur.getArene()) && this.posX==dresseur.getPosX() && this.posY==dresseur.getPosY()) {
  this.porteur= dresseur;
  return true;
} else {
  return false;
}
  }

/**
méthode qui retourne si le poquemont est devenu libre ou non
 * @return
*/

  public boolean etreDepose(){
if (this.porteur!=null) {
  this.porteur=null;
  return true;
} else {
  return false;
}
  }

  /**
  méthode qui met à jour la position du poquemont qui se deplace avec le dresseur qui vient de le capturer
  */

  public void changerPosition(){
if (this.porteur!=null){
  this.posX=this.getPosX();
  this.posY=this.getPosY();
}

  }

 /**
 méthode qui affiche la chaine "-poquemont" suivie de ses degats et de sa portée
  * @return
 */

  public String toString(){
    int degat = this.degats;
    int porte = this.portee;
    String s ="-poquemont (d:"+degat+", p:"+porte+")";
    return s;
  }



  }


