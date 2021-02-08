package application;

/**
 * classe qui modelise une arene et qui gere les murs de
 * l'environnement
 */
public class Arene {

int tailleX, tailleY;

public Arene(){
  this.tailleX=10;
  this.tailleY=10;
}

/**
*méthode qui retourne la taille de l’arène selon l’axe des abscisses

*/

public int getTailleX(){
  return tailleX;
}
  /**
*méthode qui retourne la taille de l’arène selon l’axe des ordonnées
*/

public int getTailleY(){
  return tailleY;
}
/**
*méthode qui retourne un booléen précisant si la case de coordonnées (x,y) est accessible
 * @param x
 * @param y
 * @return
*/
public boolean etreAccessible(int x, int y){
  if (x<0 || x>tailleX-1 || y<0 || y>tailleY-1 || x==3 && y==0 || x==3 && y==1 || x==3 && y==2 || x==7 && y==3 || x==7 && y==4 || x==7 && y==5 || x==7 && y==6 || x==3 && y==7 || x==3 && y==8 || x==3 && y==9){
    return false;
  } else {
    return true;
  }
}
}
