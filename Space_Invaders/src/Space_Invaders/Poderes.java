package Space_Invaders;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Poderes
{
    /* poder
     *  0- no usado
     *  1- activo
     *  2- usado
     */
    private int poder;
    private int posicionPoderX;
    private int posicionPoderY;
    private int anchoPoder= 10;
    private int altoPoder= 30;
    private Colisiones colisiones ;
    private int anchoNave;
    private int altoNave;
    private int altoMundo;
    private int tipo=0;

    Poderes(int anchoMundo, int altoMundo, int anchoNave, int altoNave)
    {
        this.altoMundo = altoMundo;
        this.altoNave= altoNave;
        this.anchoNave = anchoNave;
        if(anchoNave>0)colisiones = new Colisiones (anchoMundo,altoMundo);
    }

    public void resetPoder()
    {
        poder=0;
        Random rnd = new Random();
        tipo = (int)(rnd.nextDouble() * 2.5);
    }

    public boolean nuevoPoder(int posicionPoderX, int posicionPoderY)
    {
        if(colisiones!=null && anchoNave!=0 && poder==0)
        {
            this.posicionPoderX = posicionPoderX;
            this.posicionPoderY = posicionPoderY;
            colisiones.getDisparo();
            poder = 1;
            return true;
        }
        return false;
    }

    public boolean dibujarPoder(Graphics2D g, int posicionNaveX, int posicionNaveY)
    {
        boolean r = false;
        if(anchoNave!=0 && poder==1)
        {
            if( posicionPoderY+altoPoder<altoMundo)
            {
                colisiones.setDisparo(posicionPoderX,posicionPoderY, anchoPoder,altoPoder);
                if( !colisiones.tryColision(posicionNaveX, posicionNaveY , anchoNave, altoNave))
                {
                    g.setColor(Color.red);
                    g.fillRect(posicionPoderX, posicionPoderY, anchoPoder,altoPoder);
                    posicionPoderY+=1;
                } 
                else
                {
                    poder = 2;
                    r= true;
                }
            }else poder=2;
        }
        return r;
    }

    public int getPoderes()
    {
        return poder;
    }

    public int getTipo()
    {
        return tipo;
    }
}